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
    public CompleteRecord[] GetRecords(String searchTerm){


        // todo: search the database using searchTerm, for now only 1 column then create an array of CompleteRecord[]
        // and return it in this function
        CompleteRecord temp = new CompleteRecord("1","b","c","d","e","f","g","g");
        CompleteRecord temp2 = new CompleteRecord("3","b","c","d","e","f","g","g");
        CompleteRecord temp3 = new CompleteRecord("4","b","c","d","e","f","g","g");
        CompleteRecord[] returnTest = {temp,temp2,temp3};

        return returnTest;

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
    public boolean AddRecord(CompleteRecord data){

        //TODO: add code here



        //return "Add records";
        return true;
    }

    // Uses the url parameter of an api request to delete a record based on its id
    public boolean DeleteRecord(Long id){

        //TODO: add code here

         //"Delete Records";
        return true;
    }


}