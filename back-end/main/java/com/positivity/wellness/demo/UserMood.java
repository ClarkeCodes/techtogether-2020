package com.positivity.wellness.demo;

import lombok.Data;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
public class UserMood {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String userId;

    private Mood mood;

    private Date when;

    @ElementCollection
    private List<String> wins;

    @Override
    public String toString() {
        return "UserMood{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", mood=" + mood +
                ", when=" + when +
                '}';
    }
}
