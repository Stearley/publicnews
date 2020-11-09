package com.ippsby.publicnews.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Entity
@Table(name = "pe")
public class PeModel implements Serializable {

    @Id
    @GeneratedValue
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


    private long themeId;

    private long newsId;


}
