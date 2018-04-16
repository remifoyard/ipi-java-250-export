package com.example.demo.entity;

import javax.persistence.*;
import java.util.*;

/**
 * Created by Kayne on 09/04/2018.
 */
@Entity
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "facture")
    private Set<LigneFacture> ligneFacture = new HashSet<>();

    @ManyToOne
    private Client client;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
    }
}
