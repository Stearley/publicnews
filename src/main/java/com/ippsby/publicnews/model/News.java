package com.ippsby.publicnews.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;


@Data
@Entity
@Table (name = "news")
public class News implements Serializable {

    @JsonView(Security.Public.class)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long newsId;

    @JsonView(Security.Public.class)
    private String title;

    @JsonView(Security.Public.class)
    @Column(name = "annotation")
    private String annotation;

    @JsonView(Security.Local.class)
    @Column(name ="newsStatus")
    private long newsStatus;

    @ManyToOne//связь новостей и пе(обратная)
    @JoinColumn(name = "peIdSubs")
    @JsonIgnore
    private Pe pe;


}
