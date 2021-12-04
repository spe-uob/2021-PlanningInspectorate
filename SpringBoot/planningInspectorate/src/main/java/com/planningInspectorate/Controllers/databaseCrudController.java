package com.planningInspectorate.Controllers;

import com.planningInspectorate.ServiceLayer.databaseCrudLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public String GetRecords(@PathVariable String searchTerm){ return databaseCrudLogic.GetRecords(); }

    @PutMapping("/editRecords/{data}")
    public String EditRecord(@PathVariable String data){
        return databaseCrudLogic.EditRecord();
    }

    @PostMapping("/addRecords/{data}")
    public String AddRecord(@PathVariable String data){
        return databaseCrudLogic.AddRecord();
    }

    @DeleteMapping("/deleteRecords/{id}")
    public String DeleteRecord(@PathVariable String id){
        return databaseCrudLogic.DeleteRecord();
    }


}
