package com.liuweiwei.librarymanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jsp")
public class Jspp {
    @GetMapping("/photoSet")
    public String userSet(){
        return "jsp/photoSet";
    }
    @GetMapping("/1")
    public String userSet1(){
        return "/jsp/1";
    }
}
