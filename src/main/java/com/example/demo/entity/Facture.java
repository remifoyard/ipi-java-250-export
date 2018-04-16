package com.example.demo.entity;

import javax.persistence.*;
<<<<<<< HEAD
import java.util.HashSet;
import java.util.Set;
=======
import java.util.*;
>>>>>>> 79a558fc43e0fc48d6ca8ee66f53c103f1b978a4

/**
 * Created by Kayne on 09/04/2018.
 */
@Entity
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

<<<<<<< HEAD
    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "facture")
    private Set<LigneFacture> ligneFactures = new HashSet<>();

=======
    @OneToMany(mappedBy = "facture")
    private Set<LigneFacture> ligneFacture = new HashSet<>();

    @ManyToOne
    private Client client;

>>>>>>> 79a558fc43e0fc48d6ca8ee66f53c103f1b978a4
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

<<<<<<< HEAD
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<LigneFacture> getLigneFactures() {
        return ligneFactures;
    }

    public void setLigneFactures(Set<LigneFacture> ligneFactures) {
        this.ligneFactures = ligneFactures;
=======
    public Set<LigneFacture> getLigneFacture() {
        return ligneFacture;
    }

    public void setLigneFacture(Set<LigneFacture> ligneFacture) {
        this.ligneFacture = ligneFacture;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
>>>>>>> 79a558fc43e0fc48d6ca8ee66f53c103f1b978a4
    }
}
