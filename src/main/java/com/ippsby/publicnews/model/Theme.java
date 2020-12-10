package com.ippsby.publicnews.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "theme")
public class Theme implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long themeId;

    @Column(name = "themeName")
    @NotBlank
    private String themeName;

    @ManyToMany(mappedBy = "themes")
    @JsonBackReference
    private List<Pe> peList;




}
