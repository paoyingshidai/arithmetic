package com.michael.arithmetic.presort.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("category")
public class IndexController {


    @RequestMapping("index")
    public String index() {

        return "index";
    }

}
