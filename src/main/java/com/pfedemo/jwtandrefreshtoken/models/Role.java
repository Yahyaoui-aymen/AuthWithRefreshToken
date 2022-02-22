package com.pfedemo.jwtandrefreshtoken.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_id")
    private Integer id ;

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private ERole  name ;

    public Role() {
    }

}
