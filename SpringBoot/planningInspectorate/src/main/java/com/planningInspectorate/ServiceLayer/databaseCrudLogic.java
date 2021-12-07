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

    // GetRecords takes a string as a url parameter and returns the matching records
    public String GetRecords(String searchTerm){

        //TODO: add code here
        return ("Get records: "+searchTerm);

    }

    // EditRecord uses the JSON body of an api request to modify a record.
    // data is a Complete Record passed to the function it can have any number of fields as null, null fields shouldn't
    // be altered
    public String EditRecord(CompleteRecord data){

        //TODO: add code here
        return "Edit records";

    }

    // AddRecord uses the JSON body of an api request to create a record. So long as one field holds a value any of the
    // others can be null. If they are columns in database are nullable so do that
    public void AddRecord(CompleteRecord data){

        //TODO: add code here



        //return "Add records";

    }

    // Uses the url parameter of an api request to delete a record based on its id
    public void DeleteRecord(Long id){

        //TODO: add code here

        //need to add the exception where there isnt an id like that later
        contactRepository.deleteById(id);

         //"Delete Records";

    }


}