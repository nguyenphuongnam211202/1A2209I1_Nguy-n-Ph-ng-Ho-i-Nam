package com.example.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.*;

@org.springframework.stereotype.Controller
public class Controller  {
    @GetMapping("")
    public String showForm(){
        return "index";
    }

    @PostMapping("/change")
    public ModelAndView change(Model model, @RequestParam("usd") int usd){
        ModelAndView modelAndView = new ModelAndView("index");
        int vnd = usd*22000;
        modelAndView.addObject("vnd",vnd +" VND");
        return modelAndView;
    }

}