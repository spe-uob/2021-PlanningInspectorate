package com.planningInspectorate.ServiceLayer;
import org.springframework.stereotype.Service;



@Service
public class databaseCrudLogic {


    public String GetRecords(String searchTerm){

        //TODO: add code here


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

    public String DeleteRecord(){

        //TODO: add code here
        return "Delete Records";

    }


}