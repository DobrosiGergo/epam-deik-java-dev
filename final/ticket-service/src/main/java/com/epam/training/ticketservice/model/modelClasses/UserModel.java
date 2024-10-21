package com.epam.training.ticketservice.model.modelClasses;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@Table(name= "Users")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique=true)
    private String username;
    private String passwd;
    @Enumerated(EnumType.STRING)
    private Role role;
    public enum Role{
        ADMIN
    }
}

