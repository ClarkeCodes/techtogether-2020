package com.positivity.wellness.demo;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Account {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserMood userMood;

    @Override
    public String toString() {
        return "Account{" +
                "firstName'" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", userMood='" + userMood + '\'' +
                '}';
    }
}
