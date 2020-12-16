package com.ippsby.publicnews.dto;

import com.ippsby.publicnews.model.Pe;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class NewsDto implements Serializable {
    public NewsDto(long newsId, String annotation, String title, Date publicationDate, Pe pe) {
        this.newsId = newsId;
        this.annotation = annotation;
        this.publicationDate = publicationDate;
        this.title = title;
        this.pe = pe;
    }

    private long newsId;
    private String annotation;
    private Date publicationDate;
    private String title;
    private Pe pe;

}