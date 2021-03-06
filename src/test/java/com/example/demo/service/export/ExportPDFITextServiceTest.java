package com.example.demo.service.export;

import com.example.demo.dto.ClientDTO;
import com.example.demo.dto.FactureDTO;
import com.example.demo.dto.LigneFactureDTO;
import com.example.demo.entity.LigneFacture;
import com.itextpdf.text.DocumentException;
import org.junit.Test;

import java.util.*;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExportPDFITextServiceTest {

    @Test
    public void test() throws IOException, DocumentException {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setNom("PETRILLO");
        clientDTO.setPrenom("Alexandre");


        LigneFactureDTO ligneFactureDTO1 = new LigneFactureDTO();
        ligneFactureDTO1.setDesignation("Carte mère");
        ligneFactureDTO1.setQuantite(1);
        ligneFactureDTO1.setPrixUnitaire(79.90);

        LigneFactureDTO ligneFactureDTO2 = new LigneFactureDTO();
        ligneFactureDTO2.setDesignation("Clavier Logitech");
        ligneFactureDTO2.setQuantite(1);
        ligneFactureDTO2.setPrixUnitaire(39.90);

        FactureDTO factureDTO = new FactureDTO();
        factureDTO.setClient(clientDTO);
        factureDTO.getLigneFactures().add(ligneFactureDTO1);
        factureDTO.getLigneFactures().add(ligneFactureDTO2);

        ExportPDFITextService exportPDFITextService = new ExportPDFITextService();
        FileOutputStream fos = new FileOutputStream("./target/factureDTO-itext.pdf");
        exportPDFITextService.export(fos, factureDTO);
        fos.close();
    }
}