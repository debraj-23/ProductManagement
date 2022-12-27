package com.cts.Productmanagement.service;

import com.cts.Productmanagement.entity.Product;
import com.cts.Productmanagement.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @InjectMocks
    private ProductServiceImpl productService;
    @Mock
    private ProductRepository productRepository;

    @Test
    @DisplayName("Product should be saved in database")
    public void WhenProductSave_ThenProductShouldSaveInDb()
    {
        Product product = new Product();
        product.setId(1L);
        product.setName("Iphone14");
        product.setDescription("Mobile");
        product.setPrice(72000);

        when(productRepository.save(any(Product.class))).thenReturn(product);
        Product newProduct = productService.addProduct(product);

        assertNotNull(newProduct);
        assertThat(newProduct.getName()).isEqualTo("Iphone14");
    }

    @Test
    @DisplayName("Should return list of all the products")
    public void whenGetProduct_ThenListOfProductShouldReturn(){
        Product product = Product.builder()
                .id(1L)
                .name("Iphone14")
                .description("Mobile")
                .price(72000)
                .build();
        Product product1 = Product.builder()
                .id(2L)
                .name("Iphone12")
                .description("Mobile")
                .price(48000)
                .build();
        List<Product> list = new ArrayList<>();
        list.add(product);
        list.add(product1);

        when(productRepository.findAll()).thenReturn(list);

        List<Product> products =  productService.productList();

        assertEquals(2, products.size());
        assertNotNull(products);
    }
}