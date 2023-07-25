package com.example.controller;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import com.example.service.CategoryService;
import com.example.service.ProductService;
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
    private IProductRepository productRepository;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;

    @GetMapping({"/list",""})
    public ModelAndView showList(@PageableDefault(value = 3,sort = "idProduct",direction =  Sort.Direction.ASC) Pageable pageable){
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
        product.setStatus("cho duyet");
        product.setCategory(categoryService.findById(product.getCategory().getCategoryId()));
        productRepository.save(product);
        return "redirect:/list";
    }

//    @GetMapping("/search")
//    public ModelAndView listCustomers(@RequestParam("name") Optional<String> name, @RequestParam("price") double price, @RequestParam("category") Optional<String> category , Pageable pageable) {
//        Page<Product> products;
//        if (!name.isPresent() ) {
//            products = productRepository.findAllByNameContaining(String.valueOf(name),pageable);
//        } else {
//            products = productService.findAll(pageable);
//        }
//        ModelAndView modelAndView = new ModelAndView("list");
//        modelAndView.addObject("products", products);
//        return modelAndView;
//    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        productService.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Xóa thành công!");
        return "redirect:/list";
    }
    @GetMapping("/search")
    public ModelAndView listCustomers(@RequestParam("name") Optional<String> search, Pageable pageable){
        Page<Product> products;
        if(search.isPresent()){
            products= productService.searchByName(search.get(), pageable);
        } else {
            products = productService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView listCustomers(@RequestParam("category") Optional<String> category,@RequestParam("name") Optional<String> search,@RequestParam("price") double price, Pageable pageable){
        Page<Product> products;
        if(search.isPresent()){
            products= productService.searchByName(search.get(), pageable);
        } else if(price!=0){
            products = productService.searchByPrice(price,pageable);
        } else {
            products = productService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("products", products);
        return modelAndView;
    }

}
