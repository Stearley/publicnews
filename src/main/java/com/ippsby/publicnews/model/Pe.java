package com.ippsby.publicnews.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "pe")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "peId")
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

    @OneToMany(mappedBy ="pe")
    private List<News> news;

    @ManyToMany
    @JoinTable(name = "peThematics",
            joinColumns = @JoinColumn(name = "peId"),
            inverseJoinColumns = @JoinColumn(name = "themeId"))
//    @JsonManagedReference
    private List <Theme> themes;

    @JsonIgnore
    @ManyToMany(mappedBy = "peList")
    private List<UserModel> userModel;




}

