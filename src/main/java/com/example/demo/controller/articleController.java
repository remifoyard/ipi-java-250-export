package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping(value = "/articles")
public class articleController {

    @Autowired
    private Article article;

    @RequestMapping(value = "/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String indexArticle(@PathVariable(value = "id") Long idCom, Commercial commercial, Map<String, Object> model) {
        if (idCom == 0) {
            return "erreur";
        } else {
            Commercial com = commercialService.updateEmploye(idCom,commercial);
            model.put("employe", com);
            return "employes/detail";
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String newCommercial( Commercial commercial, Map<String, Object> model) {
        Commercial com = commercialService.creerEmploye(commercial);
        model.put("employe", com);
        return "employes/detail";
    }

}