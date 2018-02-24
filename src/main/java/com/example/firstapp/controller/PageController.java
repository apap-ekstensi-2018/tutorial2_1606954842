package com.example.firstapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class PageController {
    @RequestMapping("/hello")
    public String index(){
        return "hello";
    }

//    @RequestMapping("/greeting")
//    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "dunia") String name, Model model){
//        model.addAttribute("name", name);
//        return  "greeting";
//    }

    @RequestMapping(value = {"/greeting","/greeting/{name}"})
    public String greetingPath(@PathVariable Optional<String> name, Model model){
        if (name.isPresent()){
            model.addAttribute("name",name.get());
        }else{
            model.addAttribute("name", "apap");
        }
        return "greeting";
    }

    @RequestMapping("/perkalian")
    public String perkalian(@RequestParam(value = "a", required = false, defaultValue = "0") int a, @RequestParam(value = "b", required = false, defaultValue = "0") int b, Model model){
        model.addAttribute("a",a);
        model.addAttribute("b",b);
        model.addAttribute("c",a*b);
        return "perkalian";
    }
}
