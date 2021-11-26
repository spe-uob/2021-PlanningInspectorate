package com.planningInspectorate.Controllers;

import com.planningInspectorate.ServiceLayer.databaseCrudLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/dbCrud")
public class databaseCrudController {



    private final databaseCrudLogic databaseCrudLogic;


    @Autowired
    public databaseCrudController(com.planningInspectorate.ServiceLayer.databaseCrudLogic databaseCrudLogic) {
        this.databaseCrudLogic = databaseCrudLogic;
    }


    @GetMapping("/getRecords")
    public String GetRecords(){ return databaseCrudLogic.GetRecords(); }

    @GetMapping("/editRecords")
    public String EditRecord(){
        return databaseCrudLogic.EditRecord();
    }

    @GetMapping("/addRecords")
    public String AddRecord(){
        return databaseCrudLogic.AddRecord();
    }

    @GetMapping("/deleteRecords")
    public String DeleteRecord(){
        return databaseCrudLogic.DeleteRecord();
    }


}
