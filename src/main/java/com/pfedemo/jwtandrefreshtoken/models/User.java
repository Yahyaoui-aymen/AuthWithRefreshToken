package com.pfedemo.jwtandrefreshtoken.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users" ,
       uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
        })
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = " id")
    private Long id ;

    @NotBlank
    @Size(max = 15)
    @Column(name = "username")
    private String username;

    @NotBlank
    @Size(max = 30)
    @Email
    @Column(name = "email")
    private String email;

    @NotBlank
    @Size(min = 10 , max = 30)
    @Column(name = "password")
    private String password;

    @NotBlank
    @Column(name = "first_name")
    private String firstName ;

    @NotBlank
    @Column(name = "last_name")
    private String lasttName ;

    @Column(name = "image_url")
    private String imageURL ;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();



    public User() {
    }

    public User(String username, String email, String password, String firstName, String lasttName, String imageURL) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lasttName = lasttName;
        this.imageURL = imageURL;
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lasttName='" + lasttName + '\'' +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }

}


