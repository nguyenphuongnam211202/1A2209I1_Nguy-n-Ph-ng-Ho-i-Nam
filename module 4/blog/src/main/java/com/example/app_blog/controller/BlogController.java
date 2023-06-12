package com.example.app_blog.controller;


import com.example.app_blog.model.Blog;
import com.example.app_blog.service.IAppBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlogController {
    @Autowired
    private IAppBlogService service;

    @GetMapping({"/list",""})
    public String showList(Model model) {
        model.addAttribute("blog", service.findAll());
        return "/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "/create";
    }

    @PostMapping("/create")
    public String doCreate(@ModelAttribute("blog") Blog blog) {
        service.create(blog);
        return "redirect:/list";
    }
    @GetMapping("/detail/{id}")
    public String showDetail(Model model,
                             @PathVariable("id") int id) {
        Blog blog= service.findById(id);
        model.addAttribute("blog", blog);
        return "/detail";
    }
    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable("id")int id, Model model){
        model.addAttribute("blog",service.findById(id));
        return "/update";
    }

    @PostMapping("/update")
    public String doUpdate(@ModelAttribute("blog") Blog blog){
        service.update(blog);
        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String doDelete(@PathVariable("id") int id){
        service.deleteById(id);
        return "redirect:/list";
    }

}
