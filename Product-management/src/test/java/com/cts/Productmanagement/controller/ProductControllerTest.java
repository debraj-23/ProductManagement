package com.cts.Productmanagement.controller;

import com.cts.Productmanagement.entity.Merchant;
import com.cts.Productmanagement.entity.Product;
import com.cts.Productmanagement.service.ProductService;
import com.cts.Productmanagement.service.UserService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)

public class ProductControllerTest {

    @MockBean
    private ProductService productService;

    @MockBean
    private UserDetailsService userDetailsService;

    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    private Product product;

    private Merchant user;


   /* @BeforeEach
    void setUp(){
        product = Product.builder()
                .id(1L)
                .name("Iphone14")
                .description("Mobile")
                .price(72000)
                .build();
    }*/

    @Test
    @DisplayName("Save product object")
    void WhenAddProduct_ThenShouldCreateNewProduct() throws Exception{

        Product inputProduct = Product.builder()
                .id(1L)
                .name("Iphone14")
                .description("Mobile")
                .price(72000)
                .build();

        Mockito.when(productService.addProduct(inputProduct))
                .thenReturn(product);

        mockMvc.perform(MockMvcRequestBuilders.post("/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"name\":\"Iphone14\",\n" +
                        "    \"description\":\"Mobile\",\n" +
                        "    \"price\":\"72000\"\n" +
                        "}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Get list of product")
    public void WhenGetProduct_ThenShouldReturnProduct() throws Exception {
        List<Product> list = Arrays.asList(new Product(1L,"Iphone14","Mobile",72000),new Product(2L,"Iphone11","Mobile",40000));
        Mockito.when(productService.productList())
                .thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.get("/view")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Iphone14"));
    }

    @Test
    @DisplayName("Save merchant object")
    public void WhenAddMerchant_ThenShouldCreateNewMerchant() throws Exception{

        Merchant inputUser = Merchant.builder()
                .id(1L)
                .fname("Lucas")
                .lname("Paul")
                .email("Lucas@gmail.com")
                .password("lucas12")
                .build();

        Mockito.when(userService.addUser(inputUser))
                .thenReturn(user);

        mockMvc.perform(MockMvcRequestBuilders.post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"fname\":\"Lucas\",\n" +
                        "    \"lname\":\"Paul\",\n" +
                        "    \"email\":\"Lucas@gmail.com\",\n" +
                        "    \"password\":\"lucas12\"\n" +
                        "}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
