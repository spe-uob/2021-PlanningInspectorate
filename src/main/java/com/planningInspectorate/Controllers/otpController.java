package com.planningInspectorate.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class otpController {

    @GetMapping("/otp")
    public String GetMainPage(){
        return "otpUpdatePage";
    }
}