package com.example.demo.entity;

import javax.persistence.*;

/**
 * Created by Kayne on 09/04/2018.
 */
@Entity
public class LigneFacture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Facture facture;

<<<<<<< HEAD
    @ManyToOne
    private Article article;

    @Column
    private Integer quantite;

=======
    @Column
    private Double quantite;

    @ManyToOne
    private Article article;

>>>>>>> 79a558fc43e0fc48d6ca8ee66f53c103f1b978a4
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

<<<<<<< HEAD
    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
=======
    public Double getQuantite() {
        return quantite;
    }

    public void setQuantite(Double quantite) {
        this.quantite = quantite;
>>>>>>> 79a558fc43e0fc48d6ca8ee66f53c103f1b978a4
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

<<<<<<< HEAD
    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

=======
    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }
>>>>>>> 79a558fc43e0fc48d6ca8ee66f53c103f1b978a4
}
