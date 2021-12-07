package com.planningInspectorate.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.planningInspectorate.ServiceLayer.databaseCrudLogic;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.planningInspectorate.DataLayer.CompleteRecord;

import java.sql.SQLOutput;

@RestController
@RequestMapping(path="api/v1/dbCrud")
public class databaseCrudController {


    //reference to servicelayer logic
    private final databaseCrudLogic databaseCrudLogic;

    //dependency injection instantiating  databasecrudlogic^^
    @Autowired
    public databaseCrudController(com.planningInspectorate.ServiceLayer.databaseCrudLogic databaseCrudLogic) {
        this.databaseCrudLogic = databaseCrudLogic;
    }

    @GetMapping("/getRecords/{searchTerm}")
    public CompleteRecord[] GetRecords(@PathVariable String searchTerm){
        return databaseCrudLogic.GetRecords(searchTerm);
    }

    @PutMapping("/editRecords")
    public String[] EditRecord(@RequestBody String[] data){
        System.out.println(data.length);
        return data;
//        return databaseCrudLogic.EditRecord(data);
    }

    @PostMapping("/addRecord")
    public boolean AddRecord(@RequestBody CompleteRecord data){
        return databaseCrudLogic.AddRecord(data);
    }

    @DeleteMapping("/deleteRecord/{id}")
    public boolean DeleteRecord(@PathVariable Long id){
         return databaseCrudLogic.DeleteRecord(id);
    }

}
