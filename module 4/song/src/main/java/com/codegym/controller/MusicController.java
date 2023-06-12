package com.codegym.controller;

import com.codegym.entity.Music;
import com.codegym.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRange;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
@RequestMapping({"/music",""})
public class MusicController {

    @Autowired
    private IMusicService musicService;

    @GetMapping({"list",""})
    public String List(Model model){
        List<Music> musicList = musicService.findAll();
        model.addAttribute("musics",musicList);
        return "list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("music",new Music());
        return "create";
    }

    @PostMapping("/create")
    public String doCreate(@ModelAttribute("music") Music music){
        musicService.create(music);
        return "redirect:/ music/list";
    }


    }
