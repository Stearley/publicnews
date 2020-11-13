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
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int newsId;

    @NotBlank
    private String title;

    @NotBlank
    @Column(name = "annotation")
    private String annotation;

    private int userId;

    private Date publicationDate;

}
