package com.example.controller;

import com.example.model.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.*;

@Controller
public class MayTinh extends HttpServlet {


 @GetMapping("")
    public String showForm(){
     return "index";
 }

 @PostMapping("/calculate")
    public ModelAndView calculate(Model model, @RequestParam("num1") int num1,
                                  @RequestParam("num2") int num2,
                                  @RequestParam("action") String action){
     float result = 0;
     switch (action){
         case "cong":
            result = num1+num2 ;
            break;
         case "tru":
             result = num1-num2;
             break;
         case "nhan":
             result = num1*num2;
             break;
         case "chia":
              result = num1/num2;
              break;
     }
     ModelAndView modelAndView = new ModelAndView("index");
     modelAndView.addObject("result",result);
     return modelAndView;
 }
}