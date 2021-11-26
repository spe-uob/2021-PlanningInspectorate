package com.planningInspectorate.Controllers;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
@RequestMapping(path="api/v1/dbCrud")
public class databaseCrudController {

    //private final dbLogic dbLogic;


    @GetMapping("/getRecords")
    public String GetRecords(){
        return "Get records";
    }

    @GetMapping("/editRecords")
    public String EditRecord(){
        return "Edit records";
    }

    @GetMapping("/addRecords")
    public String AddRecord(){
        return "Add records";
    }

    @GetMapping("/deleteRecords")
    public String DeleteRecord(){
        return "Delete Records";
    }
}
