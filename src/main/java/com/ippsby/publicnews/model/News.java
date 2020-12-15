package com.ippsby.publicnews.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.ippsby.publicnews.dto.NewsDto;
import com.ippsby.publicnews.dto.PeDto;
import com.ippsby.publicnews.dto.ThemeDto;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Data
@Entity
@Table (name = "news")
public class News implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long newsId;

    @NotBlank
    private String title;

    @NotBlank
    @Column(name = "annotation")
    private String annotation;

    @Temporal(TemporalType.DATE)
    private Date publicationDate;

    @ManyToOne//связь новостей и пе(обратная)
    @JoinColumn(name = "peIdSubs")
    @JsonIgnore
    private Pe pe;

    public NewsDto newsDto(){
        return new NewsDto(
                newsId,
                annotation,
                title,
                publicationDate,
                pe
        );
    }


}
