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
        return ("Get records: "+searchTerm);

    }

    public String EditRecord(){

        //TODO: add code here
        return "Edit records";

    }

    public void AddRecord(){

        //TODO: add code here



        //return "Add records";

    }

    public void DeleteRecord(Long id){

        //TODO: add code here

        //need to add the exception where there isnt an id like that later
        contactRepository.deleteById(id);

         //"Delete Records";

    }


}