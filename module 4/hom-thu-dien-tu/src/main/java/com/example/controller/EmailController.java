package com.example.controller;

import com.example.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@Controller
public class EmailController  {
    @GetMapping(value = "/")
    public String getIndex(Model model){
        model.addAttribute("form",new Email());
        return "index";
    }

    @ModelAttribute("language")
    public List<String> getLanguage(){
        List<String> languages = new ArrayList<>();
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("Chinese");

        return languages;
    }
    @ModelAttribute("pageSize")
    public List<Integer> getPageSize(){
        List<Integer> pageSizes = new ArrayList<>();
        pageSizes.add(5);
        pageSizes.add(10);
        pageSizes.add(15);
        pageSizes.add(25);
        pageSizes.add(50);
        pageSizes.add(100);
        return pageSizes;
    }

    @PostMapping("/submit")
    public ModelAndView submit(@ModelAttribute Email email){
        ModelAndView modelAndView = new ModelAndView("info","outputForm",email);
        return modelAndView;

    }

}