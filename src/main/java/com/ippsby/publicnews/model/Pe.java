package com.ippsby.publicnews.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "pe")
public class Pe implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long peId;

    @Column(name = "name")
    @NotBlank
    private String name;

    @Column(name = "fullname")
    @NotBlank
    private String fullName;

    @Column(name = "description")
    @NotBlank
    private String description;


    //UserModel userModel;
    //NewsModel newsModel;

    private long newsId;

    @ManyToMany
    @JoinTable(name = "peThematics",
            joinColumns = @JoinColumn(name = "peId"),
            inverseJoinColumns = @JoinColumn(name = "themeId"))
            private List <Theme> themes;

    @ManyToMany(mappedBy = "peList")
    private List<UserModel> userModel;

}

