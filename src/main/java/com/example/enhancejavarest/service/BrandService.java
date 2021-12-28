package com.example.enhancejavarest.service;

import com.example.enhancejavarest.entity.Brand;
import com.example.enhancejavarest.entity.User;
import com.example.enhancejavarest.repository.BrandRepository;
import com.example.enhancejavarest.request.BrandLoginRequest;
import com.example.enhancejavarest.response.UserLoginResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@Log4j2
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;

    public String registerBrand(Brand brand) throws Exception{
        Brand existingBrand = brandRepository.findByEmail(brand.getEmail().toLowerCase());
        if(existingBrand != null){
            throw new Exception("Brand email already exists");
        }
        existingBrand = brandRepository.findByBrandName(brand.getBrandName().toLowerCase());
        if(existingBrand != null){
            throw new Exception("Brand name already exists");
        }
        Brand newBrand = new Brand();
        newBrand.setEmail(brand.getEmail().toLowerCase());
        newBrand.setBrandName(brand.getBrandName().toLowerCase());
        newBrand.setPassword(brand.getPassword());
        newBrand.setBalance(0.0);
        brandRepository.save(newBrand);
        return "Brand created";
    }

    public String loginBrand(BrandLoginRequest brandLoginRequest) throws Exception{
        Brand brand = brandRepository.findByEmail(brandLoginRequest.getBrandEmail().toLowerCase());
        if(brand==null){
            throw new Exception("Unable to find the email");
        }else{
            if(!brand.getPassword().equals(brandLoginRequest.getBrandPassword())){
                throw new Exception("Password mismatch");
            }
            return "Successfully logged in";
        }
    }
}
