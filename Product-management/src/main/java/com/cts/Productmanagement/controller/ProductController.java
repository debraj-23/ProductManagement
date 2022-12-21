package com.cts.Productmanagement.controller;

import com.cts.Productmanagement.entity.Merchant;
import com.cts.Productmanagement.entity.Product;
import com.cts.Productmanagement.service.ProductService;
import com.cts.Productmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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

    @GetMapping("/")
    public List<Product> productList(){
        return productService.productList();
    }

    @PostMapping("/user")
    public Merchant addUser(@RequestBody Merchant merchant){
        return userService.addUser(merchant);
    }

}
