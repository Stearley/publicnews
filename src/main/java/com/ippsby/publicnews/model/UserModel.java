package com.ippsby.publicnews.model;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@Table(name = "users" )
@EntityListeners(AuditingEntityListener.class)
public class UserModel extends Auditable<String> {
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

    @ManyToMany
    @JoinTable(name = "peList",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "peId"))
    private List <Pe> peList;


    public void addPe(Pe pe) {
        peList.add(pe);
    }
}
