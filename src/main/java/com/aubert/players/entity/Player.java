package com.aubert.players.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity(name = "joueur")
public class Player {
    @Id
    private int id;

    @Column
    private String nom;

    @Column
    private String prenom;

    @Column
    private int age;

    @Column
    private String classement;

    public Player(int id, String nom, String prenom, int age, String classement) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.classement = classement;
    }
}
