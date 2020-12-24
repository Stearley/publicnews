package com.ippsby.publicnews.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "theme")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "themeId")
public class Theme implements Serializable {


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long themeId;


    @Column(name = "themeName")
    @NotBlank
    private String themeName;

    @ManyToMany(mappedBy = "themes")
//    @JsonBackReference
    private List<Pe> peList;


}
