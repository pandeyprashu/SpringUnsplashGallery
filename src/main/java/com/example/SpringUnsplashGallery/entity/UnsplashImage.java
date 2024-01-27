package com.example.SpringUnsplashGallery.entity;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UnsplashImage {
    @JsonProperty("id")
    private String id;

    @JsonProperty("urls")
    private Urls urls;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Urls getUrls() {
        return urls;
    }

    public void setUrls(Urls urls) {
        this.urls = urls;
    }
// getters and setters
}



