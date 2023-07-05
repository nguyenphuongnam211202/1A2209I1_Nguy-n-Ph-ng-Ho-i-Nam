package com.codegym.controller;


import com.codegym.model.Products;
import com.codegym.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ProductServiceImpl productService;

    @RequestMapping("/")
    public ModelAndView getIndex(){
        List<Products> res= productService.findAll();

        return new ModelAndView("index","res",res);
    }

    @RequestMapping("/checkout")
    public ModelAndView getCheckOut(){
        return new ModelAndView("checkout");
    }
}
