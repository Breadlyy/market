package com.example.market.controller;

import com.example.market.entities.Product;
import com.example.market.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class ProductController {

    ProductService productService;

    @GetMapping("/")
    public String products(Model model, @RequestParam(name = "name", required = false) String name)
    {
        model.addAttribute("products", productService.findAllByName(name));
        model.addAttribute("newProduct", new Product());
        return "products";
    }
    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Integer id, Model model)
    {
        model.addAttribute("product", productService.findById(id));
        return "productInfo";
    }
    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Integer id)
    {
        productService.deleteById(id);
        return "redirect:/";
    }
    @PostMapping("/product/create")
    public String create(@ModelAttribute("newProduct") Product product, Model model)
    {
        productService.save(product);
        return "redirect:/";
    }
}
