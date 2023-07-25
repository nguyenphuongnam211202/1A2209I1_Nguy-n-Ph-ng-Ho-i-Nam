package com.codegym.practice.controller;

import com.codegym.practice.service.IBookService;
import com.codegym.practice.service.ICodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private ICodeService codeService;

    @GetMapping({"/list",""})
    public String showList(Model model) {
        model.addAttribute("books", bookService.findAllBook());
        return "/list";
    }
}
