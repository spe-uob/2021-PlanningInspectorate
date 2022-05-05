package com.planningInspectorate.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/")
public class loginController {

//    @GetMapping("login")
//    public String getLoginView() {
//        return "login";
//    }

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("login")
    public String getLoginView(@RequestParam(value = "error", defaultValue = "false") boolean loginError) {
        if (loginError) {
            // you custom error handling logic will go here
            System.out.println("Login failed");
        }
        return "login";
    }
}