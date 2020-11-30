package com.ippsby.publicnews.model;

import com.fasterxml.jackson.annotation.JsonView;
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

    //@JsonView(Security.Local.class)
    private long userId;

    private Date publicationDate;


    //@ManyToOne
    //@JoinColumn(name = "userCreate")
    //private UserModel userCreate;

    //@JoinColumn(name = "dateCreate")
   // private Date dateCreate;

    @ManyToOne//связь новостей и пользователей(обратная)
    @JoinColumn(name = "userNewsId")
    private UserModel userModel;

}
