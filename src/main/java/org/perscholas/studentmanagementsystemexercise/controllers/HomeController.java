package org.perscholas.studentmanagementsystemexercise.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class HomeController {

    @GetMapping("/")
    public String index(){
        log.warn("executing...");
        return "template";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/403")
    public String accessDenied(){
        return "403";
    }


}
