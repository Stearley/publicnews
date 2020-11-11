package com.ippsby.publicnews.model;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;


@Data
@Entity
@Table(name = "users" )
public class UserModel implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long userId;

    @NotBlank
    @Column(name = "role_id")
    private long roleId;

    @Column(name = "username")
    private String username;

    @Column(name = "password", length = 36)
    private String password;

    //@PrePersist
    //public void create(){
      //  IfroleId = 1;
    //}

    



}
