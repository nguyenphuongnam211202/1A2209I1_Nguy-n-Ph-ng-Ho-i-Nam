package com.codegym.controller;

import com.codegym.entity.Comment;
import com.codegym.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping({"/picture",""})
    public String showPicture(Model model) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate today = LocalDate.now();
        model.addAttribute("comments", commentService.findAllToday(today.format(dateTimeFormatter)));
        model.addAttribute("comment",new Comment());
        return "picture";
    }

    @GetMapping("/likeComment")
    public String likeComment(@RequestParam("id") int id, Model model) {
    commentService.addLike(commentService.findById(id));
    return "redirect:/picture";
    }



    @PostMapping("/saveComment")
    public String saveComment (@ModelAttribute("comment") Comment comment){
        commentService.addComment(comment);
        return "redirect:/picture";
    }

}
