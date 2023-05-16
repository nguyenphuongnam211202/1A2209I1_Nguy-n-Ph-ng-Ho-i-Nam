package com.example.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.*;

@org.springframework.stereotype.Controller
public class Controller extends HttpServlet {
    @GetMapping("")
    public String showForm(){
        return "index";
    }

    @GetMapping("/change")
    public ModelAndView change(Model model, @RequestParam("USD") int usd){
        ModelAndView modelAndView = new ModelAndView("index");
        int vnd = usd*22000;
        modelAndView.addObject("VND",vnd);
        return modelAndView;
    }

}