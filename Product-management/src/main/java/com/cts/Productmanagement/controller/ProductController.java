package com.cts.Productmanagement.controller;

import com.cts.Productmanagement.entity.Merchant;
import com.cts.Productmanagement.entity.Product;
import com.cts.Productmanagement.service.ProductService;
import com.cts.Productmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product)
    {
        return productService.addProduct(product);
    }

    @GetMapping("/view")
    public List<Product> productList(){
        return productService.productList();
    }

    @PostMapping("/user")
    public Merchant addUser(@RequestBody Merchant merchant){
        return userService.addUser(merchant);
    }

}