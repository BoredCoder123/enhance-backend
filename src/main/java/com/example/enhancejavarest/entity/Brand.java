package com.example.enhancejavarest.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "brand")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Brand {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name="email", unique = true)
    private String email;

    @Column(name = "brand_name", unique = true)
    private String brandName;

    @Column(name = "password")
    private String password;

    @Column(name = "balance")
    private Double balance;
}
