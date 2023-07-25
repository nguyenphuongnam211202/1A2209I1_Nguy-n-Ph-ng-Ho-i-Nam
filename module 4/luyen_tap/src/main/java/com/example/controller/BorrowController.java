package com.example.controller;

import com.example.model.Borrow;
import com.example.service.IBookService;
import com.example.service.IBorrowService;
import com.example.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/borrow")
public class BorrowController {
    @Autowired
    private IBookService iBookService;
    @Autowired
    private IPersonService iPersonService;
    @Autowired
    private IBorrowService iBorrowService;


    @GetMapping("/list")
    public ModelAndView showList(@PageableDefault(value = 3,sort = "idBorrow",direction =  Sort.Direction.ASC) Pageable pageable){
        Page<Borrow> borrows = iBorrowService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("list-borrow");
        modelAndView.addObject("borrows",borrows);
        if(borrows.getContent().size() == 0){
            modelAndView.addObject("message","chua co phieu muon nao");
        }
        return modelAndView;
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("borrow", new Borrow());
        model.addAttribute("books", iBookService.findAll());
        model.addAttribute("people", iPersonService.findAll());
        return "create-borrow";
    }


    @PostMapping("/create")
    public String doCreate(@Validated @ModelAttribute("borrow") Borrow borrow,
                           BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("books", iBookService.findAll());
            model.addAttribute("people", iPersonService.findAll());
            return "/create-borrow";
        }
        borrow.setStatusBorrow("dang muon");
        borrow.setBook(iBookService.findById(borrow.getBook().getIdBook()));
        iBorrowService.create(borrow);
        return "redirect:/borrow/list";
    }

    @GetMapping("/return/{id}")
    public String doReturn(Model model,
                             @PathVariable("id") int id) {
        Borrow borrow = iBorrowService.findById(id);
        borrow.doReturn();
        model.addAttribute("borrow", iBorrowService.update(borrow));
        model.addAttribute("books", iBookService.findAll());
        model.addAttribute("people", iPersonService.findAll());
        return "redirect:/borrow/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        iBorrowService.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Xóa thành công!");
        return "redirect:/borrow/list";
    }


}
