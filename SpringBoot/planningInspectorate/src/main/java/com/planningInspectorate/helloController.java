package com.planningInspectorate;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class helloController {
    @GetMapping("/")
    @ResponseBody
    public String helloWorld(@RequestParam(defaultValue = "world", required = false) String name){
        return "Hello " + name + " from planning inspectorate project!";
    }

}
