package com.codegym.pratice.controller;

import com.codegym.pratice.model.BenhAn;
import com.codegym.pratice.model.BenhNhan;
import com.codegym.pratice.service.IBenhAnService;
import com.codegym.pratice.service.IBenhNhanService;
import com.codegym.pratice.service.Impl.BenhAnServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class BenhVienController {
    @Autowired
    private IBenhNhanService benhNhanService;

    @Autowired
    private IBenhAnService benhAnService;

    @GetMapping({"/list", ""})
    public String showList(Model model) {
        model.addAttribute("benhAnList", benhAnService.findAllBenhAn());
        return "/list";
    }

    @GetMapping("/edit/{id}")
    public String showDetail(Model model,
                             @PathVariable("id") String id) {
        BenhAn benhAn = benhAnService.findById(id);
        model.addAttribute("benhAn", benhAn);
        return "/edit";
    }

    @PostMapping("/edit")
    public String doUpdate(@Validated @ModelAttribute("benhAn") BenhAn benhAn, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return "/edit";
        }
        benhNhanService.save(benhAn.getBenhNhan());
        benhAnService.save(benhAn);
        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id ) {
        benhAnService.remove(id);
        return "redirect:/list";
    }
}
