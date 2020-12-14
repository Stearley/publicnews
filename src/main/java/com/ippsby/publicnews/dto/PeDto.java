package com.ippsby.publicnews.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.ippsby.publicnews.model.News;
import com.ippsby.publicnews.model.Security;
import com.ippsby.publicnews.model.Theme;
import com.ippsby.publicnews.model.UserModel;

import java.io.Serializable;
import java.util.List;

public class PeDto  implements Serializable {
    public PeDto (long peId, String description, String fullName, String name,List<News> news, List<Theme> themes){
        this.peId = peId;
        this.description = description;
        this.fullName = fullName;
        this.name = name;
        this.news = news;

    }

    private long peId;
    private String description;
    private String fullName;
    private String name;
    private List<News> news;




    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    public long getPeId() {
        return peId;
    }

    public void setPeId(long peId) {
        this.peId = peId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
