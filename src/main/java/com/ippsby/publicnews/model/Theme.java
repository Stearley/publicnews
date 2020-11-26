package com.ippsby.publicnews.model;

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
    private List<Pe> peList;
}