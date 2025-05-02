package com.project.hamroschool.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Logincontroller {
    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String Login(@RequestParam(required = false, name = "error") String error,
                        @RequestParam(required = false, name="logout") String logout,Model model) {
        String errormsg="";

        if (error != null) {
            errormsg="Wrong Username or Password";
        }
        if(logout!= null){
            errormsg="You have Successfully logged out";
        }
        model.addAttribute("errormsg",errormsg);
        return "login";
    }
}
