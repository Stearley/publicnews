package com.ippsby.publicnews.model;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;


@Data
@Entity
@Table(name = "users" )
public class UserModel implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long userId;

    @Column(name = "roleId")
    private long roleId;

    @Column(name = "username")
    private String username;

    @Column(name = "password", length = 36)
        private String password;

   // @OneToMany(mappedBy = "newsId")
    //private List<News> newsModels;

    @OneToMany(mappedBy = "userModel")//связь пользователя и новостей
    private List<News> news;

    @ManyToMany
    @JoinTable(name = "peList",
            joinColumns = @JoinColumn(name = "peId"),
            inverseJoinColumns = @JoinColumn(name = "userId"))
    private List <Pe> peList;



    



}
