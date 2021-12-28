package com.example.enhancejavarest.controller;

import com.example.enhancejavarest.entity.Brand;
import com.example.enhancejavarest.request.BrandLoginRequest;
import com.example.enhancejavarest.service.BrandService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping("/b/register")
    public ResponseEntity registerBrand(@RequestBody Brand brand){
        try{
            String returnedString = brandService.registerBrand(brand);
            return new ResponseEntity<String>(returnedString, HttpStatus.OK);
        }catch(Exception e){
            log.error(e.toString());
            return new ResponseEntity<String>("Unable to register brand", HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/b/login")
    private ResponseEntity loginBrand(@RequestBody BrandLoginRequest brandLoginRequest){
        try{
            String returnedString = brandService.loginBrand(brandLoginRequest);
            return new ResponseEntity<String>(returnedString, HttpStatus.OK);
        }catch(Exception e){
            log.error(e.toString());
            return new ResponseEntity<String>("Unable to register brand", HttpStatus.CONFLICT);
        }
    }
}
