package com.example.springProject.controller;

// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController 
// @Controller
public class HomeController {

    @RequestMapping("/")
    // @ResponseBody
    public String home() {
        return "Welcome to the Home Page!";
    }

    @RequestMapping("/about")
    public String about(){
        return "This is about my project.";
    }
}
