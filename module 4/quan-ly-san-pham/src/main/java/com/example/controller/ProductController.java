package com.example.controller;

import com.example.model.Product;
import com.example.service.ProductServiceImpl;
import com.example.service.iProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping({"/product",""})
public class ProductController {
    private final iProductService productService = new ProductServiceImpl();

    @GetMapping({"/list",""})
    public String list(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("products", productList);
        return "list";
    }



    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("product",new Product());
        return "create";
    }
    @GetMapping("/update")
    public String showUpdate(@RequestParam("id") int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "update";
    }

    @PostMapping("/create")
    public String doCreate(@ModelAttribute("product") Product product){
        productService.save(product);
        return "redirect:/product/list";
    }

    @PostMapping("/update")
    public String doUpdate(@ModelAttribute("product") Product product){
        productService.update(product.getId(),product);
        return "redirect:/product/list";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(Model model, @PathVariable("id") int id){
        model.addAttribute("product", productService.findById(id));
        return "detail";
    }

    @PostMapping("/findById")
    public String findById(Model model,@RequestParam("id") int id){
        List<Product> productList = new ArrayList<>();
        productList.add(productService.findById(id));
        model.addAttribute("products", productList);
        return "list";
    }
}

