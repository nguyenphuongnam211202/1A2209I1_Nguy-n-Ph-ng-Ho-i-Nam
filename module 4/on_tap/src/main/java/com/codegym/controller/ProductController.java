package com.codegym.controller;

import com.codegym.entity.Product;
import com.codegym.service.CategoryService;
import com.codegym.service.ProductService;
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

import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;

    @GetMapping({"/list",""})
    public ModelAndView showList(@PageableDefault(value = 3,sort = "name",direction =  Sort.Direction.DESC)Pageable pageable){
        Page<Product> products = productService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("products",products);
        if(products.getContent().size() == 0){
            modelAndView.addObject("message","chua co san pham nao");
        }
        return modelAndView;
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.findAll());
        return "create";
    }

    @PostMapping("/create")
    public String doCreate(@Validated @ModelAttribute("product") Product product,
                           BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryService.findAll());
            return "/create";
        }
        product.setCategory(categoryService.findById(product.getCategory().getCategoryId()));
        productService.create(product);
        return "redirect:/list";
    }

    @PostMapping("/update")
    public String doUpdate(@Validated @ModelAttribute("product") Product product,
                           BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryService.findAll());
            return "/update";
        }
        product.setCategory(categoryService.findById(product.getCategory().getCategoryId()));
        productService.update(product);
        return "redirect:/list";
    }

    @GetMapping("/update/{id}")
    public String showUpdate(Model model,
                             @PathVariable("id") int id) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.findAll());
        return "update";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        productService.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Xóa thành công!");
        return "redirect:/list";
    }


    @GetMapping("/search")
    public ModelAndView listCustomers(@RequestParam("name") Optional<String> name, @RequestParam("quantity") Optional<Integer> quantity, Pageable pageable) {
        Page<Product> products;
        if (name.isPresent() || quantity.isPresent()) {
            products = productService.searchByNameAndQuantity(name.orElse(null), quantity.orElse(null), pageable);
        } else {
            products = productService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("products", products);
        return modelAndView;
    }

//    @GetMapping("/search")
//    public ModelAndView listCustomers(@RequestParam("search") Optional<String> search, Pageable pageable){
//        Page<Product> products;
//        if(search.isPresent()){
//            products= productService.searchByName(search.get(), pageable);
//        } else {
//            products = productService.findAll(pageable);
//        }
//        ModelAndView modelAndView = new ModelAndView("list");
//        modelAndView.addObject("products", products);
//        return modelAndView;
//    }

}
