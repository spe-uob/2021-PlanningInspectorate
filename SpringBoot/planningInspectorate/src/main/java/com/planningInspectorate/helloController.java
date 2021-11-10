package com.planningInspectorate;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class helloController {
    @GetMapping("/")
    public String helloWorld(@RequestParam(defaultValue = "world", required = false) String name, Model model){
        model.addAttribute("name",name);
        return "hello";
    }

}
