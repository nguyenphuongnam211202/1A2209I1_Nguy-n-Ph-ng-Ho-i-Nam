package com.codegym.controller;

import com.codegym.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("email/")
public class EmailController {
    @RequestMapping(value = "showForm", method = RequestMethod.GET)
    public String showForm(ModelMap model) {
        model.addAttribute("email", new Email());
        return "index";
    }
    @RequestMapping(value = "/result",method = RequestMethod.POST)
    public String submit(@ModelAttribute Email email, Model model){
        model.addAttribute("languages", email.getLanguages());
        model.addAttribute("pageSize", email.getPageSize());
        model.addAttribute("filter", email.isFilter());
        model.addAttribute("signature", email.getSignature());
        return "result";

    }
}
