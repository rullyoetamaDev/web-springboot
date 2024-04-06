package com.arlspringboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.arlspringboot.entity.ProductEntity;
import com.arlspringboot.service.ProductService;

@Controller
@RequestMapping("")
public class HomeController {

    @Autowired
    private ProductService dataProducts; // membuat variable dataProducts dari ProductService yang sudah dibuat di ProductService.java

    // GetMapping => ini Annotation untuk mapping controllernya siapa, disini controllernya index.html
    @GetMapping
    // ini sebuah function dimana akan mereturn index.html
    public String welcome(Model model) {
        // doing something
        String messages = "ARL Web Spring";
        model.addAttribute("msg", messages);
        model.addAttribute("products", dataProducts.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        String messages = "ARL Web Spring";
        model.addAttribute("msg", messages);
        //data dari binding di add.html di tampung di ProductEntity() ini
        model.addAttribute("addProduct", new ProductEntity());
        return "add";
    }

    //Function saat klik button Save
    @PostMapping("/save")
    //ProductEntity ini mendapatkan value saat di klik save dan value didapet dari ProductEntity diatas
    public String save(Model model, ProductEntity addProduct){
        ProductService.addProduct(addProduct);
        String messages = "ARL Web Spring";
        model.addAttribute("msg", messages);
        model.addAttribute("products", dataProducts.findAll());
        return "redirect:/";
    }

     @GetMapping("/edit/{id}")
      public String edit(@PathVariable("id") Long id, Model model) {
            // call service untuk edit
            model.addAttribute("productEdit", ProductService.findById(id));
            return "edit";
      }

      @PostMapping("/update")
      public String update(ProductEntity product, Model model) {
            // call service update
            ProductService.updateProduct(product);
            return "redirect:/";
      }

      @GetMapping("/delete/{id}")
      public String delete(@PathVariable("id") Long id) {
            // call service untuk delete
            ProductService.deleteByid(id);
            return "redirect:/";
      }
}
