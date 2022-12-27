package com.cts.Productmanagement.repository;

import com.cts.Productmanagement.entity.Merchant;
import com.cts.Productmanagement.entity.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;


    @Test
    @DisplayName("Save Merchant object")
    public void WhenMerchantSave_ThenMerchantShouldSaveInDb()
    {
        Merchant merchant = Merchant.builder()
                .fname("Kevin")
                .lname("Paul")
                .email("kevin@gmail.com")
                .password("kevin12")
                .build();

        Merchant m = userRepository.save(merchant);

        assertNotNull(m);
        assertThat(m.getId()).isNotEqualTo(null);
    }

}