package com.planningInspectorate.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import com.planningInspectorate.DataLayer.*;

import javax.naming.directory.SearchResult;
import java.util.Optional;

@Service
public class databaseCrudLogic {

    @Autowired
    private ContactRepository contactRepository;
    private DepartmentRepository departmentRepository;
    private OrganisationRepository organisationRepository;
    private PersonRepository personRepository;
    private SpecialContactRepository specialContactRepository;


    @GetMapping
    public String GetRecords(String searchTerm){

        //TODO: add code here
        //Search searchTerm from data layer
        Optional<Object> foundContact = contactRepository.findAll(searchTerm);
        Optional<Object> foundDepartment = departmentRepository.findAll(searchTerm);
        Optional<Object> foundOrganization = organisationRepository.findAll(searchTerm);
        Optional<Object> foundPerson = personRepository.findAll(searchTerm);
        Optional<Object> foundSpecialContact =specialContactRepository.findAll(searchTerm);

        // migrate all found data
        //return the migrated data
                //.orElseThrow(() -> ("Couldn't find term" + searchTerm));

        return ("Get records: "+searchTerm);

    }

    public String EditRecord(){

        //TODO: add code here
        return "Edit records";

    }

    public String AddRecord(){

        //TODO: add code here
        return "Add records";

    }

    public String DeleteRecord(String contactId){
        contactRepository.deleteById((long) Integer.parseInt(contactId));
        //TODO: add code here
        return "Delete Records";

    }


}