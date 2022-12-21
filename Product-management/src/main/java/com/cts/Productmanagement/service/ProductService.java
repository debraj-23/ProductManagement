package com.cts.Productmanagement.service;

import com.cts.Productmanagement.entity.Product;

import java.util.List;

public interface ProductService {
  public  Product addProduct(Product product);

 public List<Product> productList();
}
