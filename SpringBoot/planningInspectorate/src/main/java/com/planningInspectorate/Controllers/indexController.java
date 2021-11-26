package com.planningInspectorate.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


// Controller for basic web requests to the various pages of the site
// create backend
@Controller
public class indexController {
    @GetMapping("/")
    public String GetMainPage(){
        return "index";
    }

    @GetMapping("/newConsultationList")
    public String GetNewConsListPage(){
        return "createNewConsList";
    }

    @GetMapping("/manageDatabase")
    public String GetManageDBPage(){
        return "manageDatabase";
    }

    @GetMapping("/formResponses")
    public String GetCreatePage(){
        return "viewFormResponses";
    }
}
