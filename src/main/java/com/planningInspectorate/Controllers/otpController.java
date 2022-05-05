package com.planningInspectorate.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class otpController {

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/otp")
    public String GetMainPage(){
        return "otpUpdatePage";
    }
}