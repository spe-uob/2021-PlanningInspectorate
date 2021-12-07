package com.planningInspectorate.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.planningInspectorate.ServiceLayer.databaseCrudLogic;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.planningInspectorate.DataLayer.CompleteRecord;

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
        System.out.println("get request recieved with search term: "+searchTerm);
        CompleteRecord temp = new CompleteRecord("a","b","c","d","e","f","g");
        CompleteRecord temp2 = new CompleteRecord("a","b","c","d","e","f","g");
        CompleteRecord temp3 = new CompleteRecord("a","b","c","d","e","f","g");
        CompleteRecord[] returnTest = {temp,temp2,temp3};
        return returnTest;
        //return databaseCrudLogic.GetRecords(searchTerm);
    }

    @PutMapping("/editRecords")
    public String EditRecord(@RequestBody CompleteRecord data){
        return databaseCrudLogic.EditRecord(data);
    }

    @PostMapping("/addRecord")
    public void AddRecord(@RequestBody CompleteRecord data){
        databaseCrudLogic.AddRecord(data);
    }

    @DeleteMapping("/deleteRecord")
    public void DeleteRecord(@PathVariable Long id){
         databaseCrudLogic.DeleteRecord(id);
    }

}
