package com.codegym.controller;

import com.codegym.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SongController {
    @GetMapping({"","/showForm"})
    public String showForm(Model model){
        model.addAttribute("song",new Song());
        return "form";
    }

    @PostMapping("/check")
    public String check(Model model, @Validated @ModelAttribute("song") Song song, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()) {
            return "form";
        }
        return "list";
    }

}
