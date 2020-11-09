package com.ippsby.publicnews.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Entity
@Table(name = "theme")
public class ThemeModel implements Serializable {

    @Id
    @GeneratedValue
    private long themeId;

    @Column(name = "theme_name")
    @NotBlank
    private String themeName;

}
