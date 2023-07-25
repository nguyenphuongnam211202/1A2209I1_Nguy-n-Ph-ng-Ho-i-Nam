package com.example.controller;

import com.example.model.Book;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("book")
public class BookController {
    @Autowired
    private IBookService iBookService;
    @Autowired
    private IPersonService iPersonService;
    @Autowired
    private IBorrowService iBorrowService;


    @GetMapping("/list")
    public ModelAndView showList(@PageableDefault(value = 3,sort = "idBook",direction =  Sort.Direction.ASC) Pageable pageable){
        Page<Book> books = iBookService.findAllPage(pageable);
        ModelAndView modelAndView = new ModelAndView("list-book");
        modelAndView.addObject("books",books);
        if(books.getContent().size() == 0){
            modelAndView.addObject("message","chua co sach nao");
        }
        return modelAndView;
    }
}
