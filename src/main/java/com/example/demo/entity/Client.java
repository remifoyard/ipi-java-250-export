package com.example.demo.entity;

import javax.persistence.*;

/**
 * Created by Kayne on 09/04/2018.
 */
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
<<<<<<< HEAD
    private String prenom;

    @Column
    private String nom;
=======
    private String nom;

    @Column
    private String prenom;

    @Column
    private String mail;

>>>>>>> 79a558fc43e0fc48d6ca8ee66f53c103f1b978a4

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

<<<<<<< HEAD
=======
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

>>>>>>> 79a558fc43e0fc48d6ca8ee66f53c103f1b978a4
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

<<<<<<< HEAD
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
=======
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
>>>>>>> 79a558fc43e0fc48d6ca8ee66f53c103f1b978a4
    }
}
