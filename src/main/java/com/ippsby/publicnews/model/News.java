package com.ippsby.publicnews.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;


@Data
@Entity
@Table (name = "news")
public class News implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long newsId;

    @NotBlank
    private String title;

    @NotBlank
    @Column(name = "annotation")
    private String annotation;

    @Temporal(TemporalType.DATE)
    private Date publicationDate;


    @ManyToOne//связь новостей и пе(обратная)
    @JoinColumn(name = "peId")
    private Pe pe;

    @ManyToOne//связь новостей и пользователей(обратная)
    @JoinColumn(name = "userNewsId")
    private UserModel userModel;

}
