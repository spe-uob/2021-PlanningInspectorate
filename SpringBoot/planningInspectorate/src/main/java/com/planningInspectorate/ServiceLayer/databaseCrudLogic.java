package com.planningInspectorate.ServiceLayer;
import org.springframework.stereotype.Service;

@Service
public class databaseCrudLogic {


    public String GetRecords(){ return "Get records"; }

    public String EditRecord(){
        return "Edit records";
    }

    public String AddRecord(){
        return "Add records";
    }

    public String DeleteRecord(){
        return "Delete Records";
    }






}