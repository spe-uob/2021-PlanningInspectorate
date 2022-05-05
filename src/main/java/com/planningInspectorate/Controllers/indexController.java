package com.planningInspectorate.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


// Controller for basic web requests to the various pages of the site
// create backend
@CrossOrigin(origins = "http://localhost:8081")
@Controller
public class indexController {
    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/")
    public String GetMainPage(){
        return "index";
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/newConsultationList")
    public String GetNewConsListPage(){
        return "createNewConsList";
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/manageDatabase")
    public String GetManageDBPage(){
        return "manageDatabase";
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/formResponses")
    public String GetCreatePage(){
        return "viewFormResponses";
    }
}
