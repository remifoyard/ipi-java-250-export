package com.example.demo.service.export;

import org.springframework.stereotype.Service;
import com.example.demo.dto.ClientDTO;

import java.io.IOException;
import java.util.List;
import java.io.Writer;
import java.util.*;

@Service
public class ExportCSVService {

    public void export(Writer printWriter, List<ClientDTO> clients) throws IOException {
        printWriter.write("Nom;");
        printWriter.write("Prénom\n");
        for(ClientDTO cl : clients){
            String nom = cl.getNom();
            String nomValide = nom.replace(";", " ");

            String prenom = cl.getPrenom();
            String prenomValide = prenom.replace(";", " ");

            printWriter.write(nomValide+";"+prenomValide+"\n");
        }
    }
}
