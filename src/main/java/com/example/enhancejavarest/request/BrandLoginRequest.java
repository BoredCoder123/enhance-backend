package com.example.enhancejavarest.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BrandLoginRequest {
    private String brandEmail;
    private String brandPassword;
}
