package com.ippsby.publicnews.model;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Data
@Entity
@Table(name = "users" )
public class UserModel implements Serializable {
    @JsonView(Security.Local.class)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long userId;

    @JsonView(Security.Local.class)
    @Column(name = "roleId")
    private long roleId;

    @JsonView(Security.Public.class)
    @Column(name = "username")
    private String username;

    @JsonView(Security.Public.class)
    @Column(name = "password", length = 36)
        private String password;


    @JsonView(Security.Public.class)
    @OneToMany(mappedBy = "userModel")//связь пользователя и новостей
    private List<News> news;

    @JsonView(Security.Public.class)
    @ManyToMany
    @JoinTable(name = "peList",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "peId"))
    private List <Pe> peList;







}
