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
        client.setNom("PETRI;LLO");
        client.setPrenom("Alexandre");
        client.setAge(28);
        em.persist(client);

        Client client2  = new Client();
        client2.setNom("FOYARD");
        client2.setPrenom("Remi");
        client2.setAge(30);
        em.persist(client2);

        Client client3  = new Client();
        client3.setNom("PINTEAUX");
        client3.setPrenom("Julien");
        client3.setAge(26);
        em.persist(client3);

        Article article = new Article();
        article.setLibelle("Carte mère ASROCK 2345");
        article.setPrix(79.90);
        em.persist(article);

        Article article2 = new Article();
        article2.setLibelle("Clavier Logitech");
        article2.setPrix(39.90);
        em.persist(article2);

        Article article3 = new Article();
        article3.setLibelle("Carte mémoire");
        article3.setPrix(29.90);
        em.persist(article3);

        Article article4 = new Article();
        article4.setLibelle("Ecran LCD");
        article4.setPrix(139.90);
        em.persist(article4);

        Facture facture = new Facture();
        facture.setClient(client);
        em.persist(facture);

        LigneFacture ligneFacture1 = new LigneFacture();
        ligneFacture1.setFacture(facture);
        ligneFacture1.setArticle(article);
        ligneFacture1.setQuantite(1);
        em.persist(ligneFacture1);

        LigneFacture ligneFacture2 = new LigneFacture();
        ligneFacture2.setFacture(facture);
        ligneFacture2.setArticle(article2);
        ligneFacture2.setQuantite(2);
        em.persist(ligneFacture2);

        Facture facture2 = new Facture();
        facture2.setClient(client2);
        em.persist(facture2);

        LigneFacture ligneFacture3 = new LigneFacture();
        ligneFacture3.setFacture(facture2);
        ligneFacture3.setArticle(article3);
        ligneFacture3.setQuantite(3);
        em.persist(ligneFacture3);

        LigneFacture ligneFacture4 = new LigneFacture();
        ligneFacture4.setFacture(facture2);
        ligneFacture4.setArticle(article2);
        ligneFacture4.setQuantite(2);
        em.persist(ligneFacture4);

        LigneFacture ligneFacture5 = new LigneFacture();
        ligneFacture5.setFacture(facture2);
        ligneFacture5.setArticle(article4);
        ligneFacture5.setQuantite(4);
        em.persist(ligneFacture5);

        Facture facture3 = new Facture();
        facture3.setClient(client);
        em.persist(facture3);

        LigneFacture ligneFacture6 = new LigneFacture();
        ligneFacture6.setFacture(facture3);
        ligneFacture6.setArticle(article3);
        ligneFacture6.setQuantite(2);
        em.persist(ligneFacture6);

        LigneFacture ligneFacture7 = new LigneFacture();
        ligneFacture7.setFacture(facture3);
        ligneFacture7.setArticle(article4);
        ligneFacture7.setQuantite(1);
        em.persist(ligneFacture7);

        Facture facture4 = new Facture();
        facture4.setClient(client3);
        em.persist(facture4);

        LigneFacture ligneFacture8 = new LigneFacture();
        ligneFacture8.setFacture(facture4);
        ligneFacture8.setArticle(article3);
        ligneFacture8.setQuantite(5);
        em.persist(ligneFacture8);

    }
}
