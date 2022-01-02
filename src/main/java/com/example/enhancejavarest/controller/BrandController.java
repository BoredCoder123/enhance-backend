package com.example.enhancejavarest.controller;

import com.example.enhancejavarest.entity.Brand;
import com.example.enhancejavarest.request.BrandLoginRequest;
import com.example.enhancejavarest.request.CreateBlogCampaignRequest;
import com.example.enhancejavarest.request.CreateVideoCampaignRequest;
import com.example.enhancejavarest.response.GetBlogsResponse;
import com.example.enhancejavarest.service.BrandService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity loginBrand(@RequestBody BrandLoginRequest brandLoginRequest){
        try{
            String returnedString = brandService.loginBrand(brandLoginRequest);
            return new ResponseEntity<String>(returnedString, HttpStatus.OK);
        }catch(Exception e){
            log.error(e.toString());
            return new ResponseEntity<String>("Unable to register brand", HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/create-video-campaign")
    public ResponseEntity createVideoCampaign(@RequestBody CreateVideoCampaignRequest createVideoCampaignRequest){
        try{
            String returnedString = brandService.createVideoCampaign(createVideoCampaignRequest);
            return new ResponseEntity(returnedString, HttpStatus.CONFLICT);
        }catch(Exception e){
            log.error(e.toString());
            return new ResponseEntity<String>("Unable to add video campaign", HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/create-blog-campaign")
    public ResponseEntity createBlogCampaign(@RequestBody CreateBlogCampaignRequest createBlogCampaignRequest){
        try{
            String returnedString = brandService.createBlogCampaign(createBlogCampaignRequest);
            return new ResponseEntity(returnedString, HttpStatus.CONFLICT);
        }catch(Exception e){
            log.error(e.toString());
            return new ResponseEntity<String>("Unable to add blog campaign", HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/blogs/{id}")
    public ResponseEntity getBlogs(@PathVariable Integer id){
        try{
            List<GetBlogsResponse> getBlogsResponse = brandService.getBlogs(id);
            return new ResponseEntity<List>(getBlogsResponse, HttpStatus.OK);
        }catch (Exception e){
            log.error(e.toString());
            return new ResponseEntity<String>("Unable to fetch blog campaign", HttpStatus.CONFLICT);
        }
    }
}
