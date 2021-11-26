package com.planningInspectorate.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class databaseCrudController {

    @GetMapping
    public String GetRecords(){
        return "Hello world";
    }

    @GetMapping
    public String EditRecord(){
        return "Hello world";
    }

    @GetMapping
    public String AddRecord(){
        return "Hello world";
    }

    @GetMapping
    public String DeleteRecord(){
        return "Hello world";
    }
}
