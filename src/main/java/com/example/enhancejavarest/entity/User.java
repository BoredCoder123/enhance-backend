package com.example.enhancejavarest.entity;

import com.example.enhancejavarest.Constants.Gender;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="user_table")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @Column(name="id")
    @GeneratedValue
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="email", unique = true)
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="coins_balance")
    private Integer coinsBalance;

    @Column(name="age")
    private Integer age;

    @Column(name="share_age")
    private Boolean shareAge;

    @Column(name="gender")
    private Gender gender;

    @Column(name="share_gender")
    private Boolean shareGender;

    @Lob
    @Column(name="interest")
    private String[] interest;

    @Column(name="share_interest")
    private Boolean shareInterest;

    @Lob
    @Column(name="features")
    private String[] features;

    @Column(name="share_features")
    private Boolean shareFeatures;

    @Lob
    @Column(name="brand_preference")
    private String[] brandPreference;
}
