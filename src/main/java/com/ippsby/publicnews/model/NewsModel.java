package com.ippsby.publicnews.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table (name = "news")
public class NewsModel {

    @Id
    @GeneratedValue
    private long newsId;
    private String title;
    private String annotation;
    private long user_id;
   // private date date;

}
