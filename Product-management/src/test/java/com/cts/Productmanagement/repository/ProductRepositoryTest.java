package com.cts.Productmanagement.repository;

import com.cts.Productmanagement.entity.Product;
import org.aspectj.apache.bcel.util.ClassPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.TestPropertySources;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;


    @Test

    @DisplayName("Save product object")
    public void WhenProductSave_ThenProductShouldSaveInDb()
    {
        Product product = Product.builder()
                .name("Iphone14")
                .description("Mobile")
                .price(72000)
                .build();

        Product p = productRepository.save(product);

        assertNotNull(p);
        assertThat(p.getId()).isNotEqualTo(null);
    }

    @Test
    @DisplayName("should return list of all products")
    public void WhenGetProduct_ThenShouldReturnProducts() {
        Product product = Product.builder()
                .name("Iphone14")
                .description("Mobile")
                .price(72000)
                .build();

        Product product1 = Product.builder()
                .name("Iphone12")
                .description("Mobile")
                .price(48000)
                .build();

        productRepository.save(product);
        productRepository.save(product1);


        List<Product> list = new ArrayList<>();
        productRepository.findAll().forEach(e -> list.add(e));
        assertNotNull(list);
        assertThat(list.size()).isGreaterThan(0);
    }
}