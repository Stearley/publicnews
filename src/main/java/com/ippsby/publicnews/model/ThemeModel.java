package com.ippsby.publicnews.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "theme")
public class ThemeModel {

    @Id
    @GeneratedValue
    private long themeId;

    @Column(name = "theme_name")
    @NotBlank
    private String themeName;

}
