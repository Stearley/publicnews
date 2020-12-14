package com.ippsby.publicnews.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.ippsby.publicnews.dto.PeDto;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "pe")
public class Pe implements Serializable {

//    @JsonView(Security.Local.class)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long peId;

//    @JsonView(Security.Local.class)
    @Column(name = "name")
    @NotBlank
    private String name;

//    @JsonView(Security.Local.class)
    @Column(name = "fullname")
    @NotBlank
    private String fullName;

//    @JsonView(Security.Local.class)
    @Column(name = "description")
    @NotBlank
    private String description;

//    @JsonView(Security.Local.class)
    @OneToMany(mappedBy ="pe")
    private List<News> news;

//    @JsonView(Security.Public.class)
    @ManyToMany
    @JoinTable(name = "peThematics",
            joinColumns = @JoinColumn(name = "peId"),
            inverseJoinColumns = @JoinColumn(name = "themeId"))
    @JsonManagedReference
    private List <Theme> themes;


    @JsonIgnore
    @ManyToMany(mappedBy = "peList")
    private List<UserModel> userModel;

    public PeDto peDto(){
        return new PeDto(
                peId,
                description,
                fullName,
                name,
                news

        );
    }


}

