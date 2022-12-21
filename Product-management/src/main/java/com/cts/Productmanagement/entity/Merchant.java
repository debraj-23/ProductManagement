package com.cts.Productmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fname;
    private String lname;
    private String email;
    private String password;
}
