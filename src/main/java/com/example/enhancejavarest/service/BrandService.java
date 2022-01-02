package com.example.enhancejavarest.service;

import com.example.enhancejavarest.Constants.CampaignType;
import com.example.enhancejavarest.entity.*;
import com.example.enhancejavarest.repository.*;
import com.example.enhancejavarest.request.BrandLoginRequest;
import com.example.enhancejavarest.request.CreateBlogCampaignRequest;
import com.example.enhancejavarest.request.CreateDealCampaignRequest;
import com.example.enhancejavarest.request.CreateVideoCampaignRequest;
import com.example.enhancejavarest.response.GetBlogsResponse;
import com.example.enhancejavarest.response.GetVideoResponse;
import com.example.enhancejavarest.response.UserLoginResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Service
@Log4j2
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private CampaignRepository campaignRepository;

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private DealRepository dealRepository;

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

    public String createVideoCampaign(CreateVideoCampaignRequest createVideoCampaignRequest) throws Exception {
        Brand checkBrand = null;
        try {
            checkBrand = brandRepository.getById(createVideoCampaignRequest.getBrandId());
            System.out.println(checkBrand.getId()+checkBrand.getBrandName());
        }catch (Exception e){
            System.out.println(e.toString());
            throw e;
        }
        try{
            Video video = new Video();
            video.setVideoUrl(createVideoCampaignRequest.getVideoUrl());
            Video savedVideo = videoRepository.save(video);
            Campaign newCampaign = new Campaign();
            newCampaign.setName(createVideoCampaignRequest.getName());
            newCampaign.setType(CampaignType.VIDEO);
            newCampaign.setMaxValue(createVideoCampaignRequest.getMaxValue());
            newCampaign.setBrand(checkBrand);
            newCampaign.setEstimatedViews(createVideoCampaignRequest.getEstimatedViews());
            newCampaign.setEstimatedClicks(0);
            newCampaign.setCurrentClicks(0);
            newCampaign.setCurrentViews(0);
            newCampaign.setCoinBalanceRemaining((int)(10*createVideoCampaignRequest.getMaxValue()));
            newCampaign.setBlog(null);
            newCampaign.setVideo(savedVideo);
            newCampaign.setDeal(null);
            campaignRepository.save(newCampaign);
            return "Video created and saved successfully";
        }catch(Exception e){
            throw new Exception("Unable to create video because: "+e.toString());
        }
    }

    public String createBlogCampaign(CreateBlogCampaignRequest createBlogCampaignRequest) throws Exception{
        Brand checkBrand = null;
        try {
            checkBrand = brandRepository.getById(createBlogCampaignRequest.getBrandId());
            System.out.println(checkBrand.getId()+checkBrand.getBrandName());
        }catch (Exception e){
            System.out.println(e.toString());
            throw e;
        }
        try{
            Blog blog = new Blog();
            blog.setBlogBody(createBlogCampaignRequest.getBlogBody());
            Blog savedBlog = blogRepository.save(blog);
            Campaign newCampaign = new Campaign();
            newCampaign.setName(createBlogCampaignRequest.getName());
            newCampaign.setType(CampaignType.BLOG);
            newCampaign.setMaxValue(createBlogCampaignRequest.getMaxValue());
            newCampaign.setBrand(checkBrand);
            newCampaign.setEstimatedViews(createBlogCampaignRequest.getEstimatedViews());
            newCampaign.setEstimatedClicks(0);
            newCampaign.setCurrentClicks(0);
            newCampaign.setCurrentViews(0);
            newCampaign.setCoinBalanceRemaining((int)(10*createBlogCampaignRequest.getMaxValue()));
            newCampaign.setBlog(savedBlog);
            newCampaign.setVideo(null);
            newCampaign.setDeal(null);
            campaignRepository.save(newCampaign);
            return "Blog created and saved successfully";
        }catch(Exception e){
            throw new Exception("Unable to create blog because: "+e.toString());
        }
    }

    public List<GetBlogsResponse> getBlogs(Integer id) throws Exception{
        try{
            List<Map<String, Object>> blogs = blogRepository.getBlogsByBrandId(id);
            List<GetBlogsResponse> result = new ArrayList<>();
            for (Map<String, Object> blog : blogs) {
                GetBlogsResponse newObject = new GetBlogsResponse();
                newObject.setBlogId((Integer) blog.get("blog_id"));
                newObject.setBrandId((Integer) blog.get("brand_id"));
                newObject.setCampaignId((Integer) blog.get("campaign_id"));
                newObject.setName((String) blog.get("name"));
                newObject.setMaxValue((Double) blog.get("max_value"));
                newObject.setEstimatedViews((Integer) blog.get("estimated_views"));
                newObject.setCurrentViews((Integer) blog.get("current_views"));
                newObject.setCoinBalanceRemaining((Integer) blog.get("coin_balance_remaining"));
                newObject.setBlogBody((String) blog.get("blog_body"));
                result.add(newObject);
            }
            return result;
        } catch (Exception e){
            throw new Exception("Unable to fetch blog because: "+e.toString());
        }
    }

    public List<GetVideoResponse> getVideosByBrandId(Integer id) throws Exception {
        try{
            List<Map<String, Object>> blogs = videoRepository.getVideoByBrandId(id);
            List<GetVideoResponse> result = new ArrayList<>();
            for (Map<String, Object> blog : blogs) {
                GetVideoResponse newObject = new GetVideoResponse();
                newObject.setVideoId((Integer) blog.get("video_id"));
                newObject.setBrandId((Integer) blog.get("brand_id"));
                newObject.setCampaignId((Integer) blog.get("campaign_id"));
                newObject.setName((String) blog.get("name"));
                newObject.setMaxValue((Double) blog.get("max_value"));
                newObject.setEstimatedViews((Integer) blog.get("estimated_views"));
                newObject.setCurrentViews((Integer) blog.get("current_views"));
                newObject.setCoinBalanceRemaining((Integer) blog.get("coin_balance_remaining"));
                newObject.setVideoUrl((String) blog.get("video_url"));
                result.add(newObject);
            }
            return result;
        } catch (Exception e){
            throw new Exception("Unable to fetch videos because: "+e.toString());
        }
    }

    public String createDealCampaign(CreateDealCampaignRequest createDealCampaignRequest) throws Exception{
        try{
            
        }catch (Exception e){
            throw new Exception("Unable to save deal because: "+e.toString());
        }
    }
}
