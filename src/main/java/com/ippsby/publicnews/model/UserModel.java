package com.ippsby.publicnews.model;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


@Data
@Entity
@Table(name = "users" )
public class UserModel implements Serializable {

    @Id
    @GeneratedValue
    private long userId;

    @NotBlank
    @Column(name = "role_id")
    private long roleId;

    @Column(name = "username")
    @NotEmpty(message = "Please enter your username")
    private String username;

    @Column(name = "password")
    @NotEmpty(message = "Please enter your password")
    private String password;

    



}
