package com.example.SpringUnsplashGallery.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.example.SpringUnsplashGallery.entity.UnsplashImage;

@Controller
public class ImageController {
     @Value("${unsplash.accessKey}")
    private String unsplashAccessKey;

    @GetMapping("/")
    public String showImages(Model model) {
        // Unsplash API endpoint to get random photos
        String apiUrl = "https://api.unsplash.com/photos/random?count=5&client_id=" + unsplashAccessKey;

        // Make an API call using RestTemplate
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UnsplashImage[]> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, UnsplashImage[].class);
        UnsplashImage[] images = response.getBody();
        // Add the image data to the model
        model.addAttribute("images", images);

        return "index";
    }
    
}
