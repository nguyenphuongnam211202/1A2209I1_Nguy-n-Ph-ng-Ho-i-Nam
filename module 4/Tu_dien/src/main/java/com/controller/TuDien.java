package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class Tu_dien {
    @GetMapping({"/search",""})
    public String Search(@RequestParam (defaultValue = "")String search, Model model){
        String result=null;
        Map<String,String> map=new LinkedHashMap<>();
        map.put("father", "bố");
        map.put("mother", "mẹ);
        map.put("brother", "anh");
        map.put("sister", "chị");
        result=map.get(search);
        model.addAttribute("search",search);
        if(result!=null){
            model.addAttribute("result",result);
        }else{
            result="Khong tim thay";
            model.addAttribute("result",result);
        }
        return "index";

    }
}
