package com.example.demo.service;

import com.example.demo.entity.Article;
import com.example.demo.entity.Client;
import com.example.demo.entity.Facture;
import com.example.demo.entity.LigneFacture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
@Transactional
public class InitData {

    @Autowired
    private EntityManager em;

    public void insertTestData() {

        Client client  = new Client();
        client.setNom("PETRILLO");
        client.setPrenom("Alexandre");
        em.persist(client);

        Client client2  = new Client();
        client2.setNom("FOYARD");
        client2.setPrenom("Remi");
        em.persist(client2);

        Client client3  = new Client();
        client3.setNom("PINTEAUX");
        client3.setPrenom("Julien");
        em.persist(client3);

        Article article = new Article();
        article.setLibelle("Carte mère ASROCK 2345");
        article.setPrix(79.90);
        em.persist(article);

        Facture facture = new Facture();
        facture.setClient(client);
        em.persist(facture);

        LigneFacture ligneFacture1 = new LigneFacture();
        ligneFacture1.setFacture(facture);
        ligneFacture1.setArticle(article);
        ligneFacture1.setQuantite(1);
        em.persist(ligneFacture1);

    }
}
