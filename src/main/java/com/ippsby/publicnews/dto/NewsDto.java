package com.ippsby.publicnews.dto;

import java.io.Serializable;
import java.util.Date;

public class NewsDto implements Serializable {
    public NewsDto(long newsId, String annotation, String title, Date publicationDate) {
        this.newsId = newsId;
        this.annotation = annotation;
        this.publicationDate = publicationDate;
        this.title = title;
    }
    private long newsId;
    private String annotation;
    private Date publicationDate;
    private String title;

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getNewsId() {
        return newsId;
    }

    public void setNewsId(long newsId) {
        this.newsId = newsId;
    }
}
