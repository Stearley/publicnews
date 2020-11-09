package com.ippsby.publicnews.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;


@Data
@Entity
@Table (name = "news")
public class NewsModel implements Serializable {

    @Id
    @GeneratedValue
    private long newsId;

    @NotBlank
    @Column(name = "title")
    private String title;

    @NotBlank
    @Column(name = "annotation")
    private String annotation;

    private long userId;

    private Date publicationDate;

}
