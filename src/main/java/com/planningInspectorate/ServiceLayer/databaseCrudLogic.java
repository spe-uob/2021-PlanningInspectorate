package com.planningInspectorate.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import com.planningInspectorate.DataLayer.*;

import javax.naming.directory.SearchResult;
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
    // GetRecords takes a string as a url parameter and returns the matching records
    public CompleteRecord[] GetRecords(String searchTerm){


        // todo: search the database using searchTerm, for now only 1 column then create an array of CompleteRecord[]
        // and return it in this function
        var result = departmentRepository.getRecord(searchTerm);
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

    // EditRecord uses the JSON body of an api request to modify a record.
    // data is a Complete Record passed to the function it can have any number of fields as null, null fields shouldn't
    // be altered
    public boolean EditRecord(CompleteRecord data){
        long contactId = Long.parseLong(data.getId());
        // delete contact

        // using contact id via the dept id get the organisation id and delete row
        // re-create row with same id and new org name
        /*long contactId = Long.parseLong(data.getId());
        long organisationId = Long.parseLong(contactRepository.getOrg(contactId));
        organisationRepository.deleteById(organisationId);
        Organisation org = new Organisation(organisationId, data.getOrganisationName());
        organisationRepository.save(org);

        // delete current dept using id and re create dept row with same id and new data
        long deptId = Long.parseLong(contactRepository.getDept(contactId));
        departmentRepository.deleteById(deptId);
        Department dept = new Department(deptId, Long.toString(organisationId), data.getDepartment(), data.getApfpTest(), data.getNotes());
        departmentRepository.save(dept);

        // delete person using id and re create person row with same id and new data
        long personId = Long.parseLong(contactRepository.getPerson(contactId));
        personRepository.deleteById(personId);
        Person person = new Person(personId, data.getContactMethod(), data.getName(), data.getEmail());
        personRepository.save(person);*/
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
        }} catch (Exception e) {
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

        if(contactRepository.existsById(contactId)){
            contactRepository.deleteById(contactId);
        }

         //"Delete Records";
        return true;
    }


}