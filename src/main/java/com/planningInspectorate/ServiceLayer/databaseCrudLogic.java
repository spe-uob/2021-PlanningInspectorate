package com.planningInspectorate.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import com.planningInspectorate.DataLayer.*;

import javax.naming.directory.SearchResult;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

// TODO: REWRITE THIS. IT IS AWFUL.

@Service
public class databaseCrudLogic {

    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private OrganisationRepository organisationRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private SpecialContactRepository specialContactRepository;
    @Autowired
    private UpdateRecordRepository updateRecordRepository;

    // GetRecords takes a string as a url parameter and returns the matching records
    public CompleteRecord[] GetRecords(String searchTerm){
        // todo: search the database using searchTerm, for now only 1 column then create an array of CompleteRecord[]
        // and return it in this function

        List<List<String>> result;
        try {
            result = departmentRepository.getRecord(searchTerm);
        }
        catch (Exception e){
            return new CompleteRecord[]{new CompleteRecord("0")};
        }

        CompleteRecord[] records = new CompleteRecord[result.size()];
        for(int i = 0; i < records.length; i++){
            List<String> currentResult = result.get(i);
            //String recordId = currentResult.get(0).toString() + ":" + currentResult.get(1).toString() + ":" + currentResult.get(2);
            String recordId = currentResult.get(0);
            String deptName = currentResult.get(1);
            String orgName = currentResult.get(2);
            String test = currentResult.get(3);
            String notes = currentResult.get(4);
            String method = currentResult.get(5);
            String name = currentResult.get(6);
            String email = currentResult.get(7);
            CompleteRecord record = new CompleteRecord(recordId, deptName, orgName, test, notes, method, name, email);
            records[i] = record;
        }
        return records;

    }

    // creates otp from contact_id and inserts into database
    public String GetRecordOneTimePin(String recordId) throws NoSuchAlgorithmException {

        oneTimePinUtil pinGen = new oneTimePinUtil();
        String otp = pinGen.GenerateOneTimePinHashFromId(recordId);
        contactRepository.addOtp(otp, Long.parseLong(recordId));

        return otp;
    }

    // EditRecord uses the JSON body of an api request to modify a record.
    // data is a Complete Record passed to the function it can have any number of fields as null, null fields shouldn't
    // be altered
    public boolean EditRecord(CompleteRecord data){

        long contactId;
        try {
            contactId = Long.parseLong(data.getId());
        }
        catch (Exception e){
            System.out.println(e.toString());
            return true;
        }

        // update organisation
        long organisationId = Long.parseLong(contactRepository.getOrg(contactId));
        organisationRepository.updateOrg(data.getOrganisationName(), contactId);
        // update person
        long personId = Long.parseLong(contactRepository.getPerson(contactId));
        personRepository.updatePerson(data.getEmail(), data.getContactMethod(), data.getName(), personId);
        // update department
        long deptId = Long.parseLong(contactRepository.getDept(contactId));
        departmentRepository.updateDepartment(data.getDepartment(), data.getNotes(), organisationId, data.getApfpTest(), deptId);

        return true;
    }

    // AddRecord uses the JSON body of an api request to create a record. So long as one field holds a value any of the
    // others can be null. If they are columns in database are nullable so do that
    public boolean AddRecord(CompleteRecord data){

        try{
        if(organisationRepository.getByName(data.getOrganisationName()).size() == 0){
            //organisationRepository.addOrg(data.getOrganisationName());
            organisationRepository.save(new Organisation(data.getOrganisationName()));
        }} catch (Exception e){
            return true;
        }
        System.out.println(organisationRepository.getByName(data.getOrganisationName()).get(0).get(0));
        long orgId = Long.parseLong(organisationRepository.getByName(data.getOrganisationName()).get(0).get(0));

        if(departmentRepository.getByName(data.getDepartment(), orgId).size() == 0){
            departmentRepository.save(new Department(orgId, data.getDepartment(), data.getApfpTest(), data.getNotes()));
        }

        long deptId = Long.parseLong(departmentRepository.getByName(data.getDepartment(), orgId).get(0));

        //personRepository.addPers(data.getName(), data.getContactMethod(), data.getEmail());
        personRepository.save(new Person(data.getContactMethod(), data.getName(), data.getEmail()));
        long persId = Long.parseLong(
                personRepository.getPerson(data.getName(), data.getContactMethod(), data.getEmail())
                .get(0));

        //contactRepository.insertContact(deptId, persId);
        contactRepository.save(new Contact(deptId, persId));
        //CompleteRecord temp = new CompleteRecord("1","a","b","c","d","e","f","g");

        //return "Add records";
        return true;
    }

    // Uses the url parameter of an api request to delete a record based on its id
    public boolean DeleteRecord(String id){
        /*var ids = id.split(":");
        long deptId = Long.parseLong(ids[0]);
        long personId = Long.parseLong(ids[2]);
        contactRepository.deleteContactsBy(deptId, personId);*/

        long contactId = Long.parseLong(id);

        try{
        if(contactRepository.existsById(contactId)){
            contactRepository.deleteById(contactId);
        }} catch (Exception e){
            System.out.println(e.toString());
            return true;
        }

         //"Delete Records";
        return true;
    }

    // check if a record exits via otp
    public boolean VerifyOTP(String pin) {
        List<String> otpRow = contactRepository.getOtpRow(pin);
        if(otpRow == null){
            return false;
        }
        else if(otpRow.size() == 0){
            return false;
        }
        else{
            return true;
        }
        //return otpRow != null && otpRow.size() > 0;
    }

    // get all record data corresponding to otp
    public CompleteRecord GetRecordFromOtp(String pin) {
        List<String> data = departmentRepository.getRecordFromOtp(pin);
        var result = data.get(0).split(",");
        String recordId = result[0];
        String deptName = result[1];
        String orgName = result[2];
        String test = result[3];
        String notes = result[4];
        String method = result[5];
        String name = result[6];
        String email = result[7];
        CompleteRecord record = new CompleteRecord(recordId, deptName, orgName, test, notes, method, name, email);

        return record;
    }

    // update data corresponding to otp
    public void updateOtp(String[] data) {

        /*long contactId;
        try {
            contactId = Long.parseLong(data.getId());
        }
        catch (Exception e){
            System.out.println(e.toString());
            return true;
        }

        // update organisation
        long organisationId = Long.parseLong(contactRepository.getOrg(contactId));
        organisationRepository.updateOrg(data.getOrganisationName(), contactId);
        // update person
        long personId = Long.parseLong(contactRepository.getPerson(contactId));
        personRepository.updatePerson(data.getEmail(), data.getContactMethod(), data.getName(), personId);
        // update department
        long deptId = Long.parseLong(contactRepository.getDept(contactId));
        departmentRepository.updateDepartment(data.getDepartment(), data.getNotes(), organisationId, data.getApfpTest(), deptId);
        */

        String otp = data[0];
        String deptName = data[1];
        String orgName = data[2];
        String test = data[3];
        String notes = data[4];
        String method = data[5];
        String personName = data[6];
        String email = data[7];

        var info = contactRepository.getOtpRow(otp);

        long contactId = Long.parseLong(info.get(0));
        long departmentId = Long.parseLong(info.get(1));
        long personId = Long.parseLong(info.get(2));
        long orgId = Long.parseLong(contactRepository.getOrg(contactId));

        departmentRepository.updateDepartment(deptName, notes, orgId, test, departmentId);
        organisationRepository.updateOrg(orgName, orgId);
        personRepository.updatePerson(email, method, personName, personId);
    }
}