package com.aubert.players.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity(name = "joueur")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nom;

    @Column
    private String prenom;

    @Column
    private int age;

    @Column
    private String classement;

    public Player(String nom, String prenom, int age, String classement) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.classement = classement;
    }
}
