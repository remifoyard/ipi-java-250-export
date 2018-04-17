package com.example.demo.controller;

import com.example.demo.dto.ClientDTO;
import com.example.demo.dto.FactureDTO;
import com.example.demo.entity.Facture;
import com.example.demo.service.ClientService;
import com.example.demo.service.FactureService;
import com.example.demo.service.export.ExportCSVService;
import com.example.demo.service.export.ExportPDFITextService;
import com.example.demo.service.export.ExportXLSXSService;
import com.example.demo.service.export.ExportXLSXSService2;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.io.*;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import com.itextpdf.text.DocumentException;

@Controller
@RequestMapping("/")
public class ExportController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ExportCSVService exportCSVService;

    @Autowired
    private ExportXLSXSService exportXLSXService;

    @Autowired
    private ExportXLSXSService2 exportXLSXService2;

    @Autowired
    private ExportPDFITextService exportPDFITextService;

    @Autowired
    private FactureService factureService;

    //@Autowired
    //private ExportPDFITextService exportPDFITextService;

    @GetMapping("/clients/csv")
    public void clientsCSV(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=\"clients.csv\"");
        List<ClientDTO> clients = clientService.findAllClients();
        exportCSVService.export(response.getWriter(), clients);
    }

    @GetMapping("/clients/xlsx")
    public void clientsXLSX(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Content-Disposition", "attachment; filename=\"clients.xlsx\"");
        List<ClientDTO> clients = clientService.findAllClients();
        exportXLSXService.export(response.getOutputStream(), clients);
    }

    @GetMapping("/client/{id}/xlsx")
    public void clientXLSX(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) throws IOException, DocumentException {
        ClientDTO client = clientService.findById(id);
        response.setHeader("Content-Disposition", "attachment; filename=\""+client.getNom()+"_"+client.getPrenom()+"_Factures.xlsx\"");
        List<Facture> factures = factureService.findByClientId(id);
        exportXLSXService2.export(response.getOutputStream(), client, factures);
    }


    @GetMapping("/factures/{id}/pdf")
    public void facturePDF(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) throws IOException, DocumentException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"facture " + id + ".pdf\"");
        FactureDTO facture = factureService.findById(id);
        exportPDFITextService.export(response.getOutputStream(), facture);
    }
}
