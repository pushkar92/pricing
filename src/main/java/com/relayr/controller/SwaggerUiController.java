package com.relayr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SwaggerUiController {

    @RequestMapping(value = "/")
    public String index(){
        return "redirect:swagger-ui.html";
    }
}
