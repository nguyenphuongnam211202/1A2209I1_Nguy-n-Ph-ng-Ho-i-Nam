package com.example.sandwich;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@Controller
public class Sandwich extends HttpServlet {
    @RequestMapping("/")
    public String loadIndex() {
        return "index";
    }


    @GetMapping(path = "/save")
    public String save(
            @RequestParam("condiment") String[] condiment,
            ModelMap modelMap
    ) {
        modelMap.addAttribute("condiment", condiment);
        return "save";
    }
}