package com.example.demo.service.export;

import com.example.demo.dto.ClientDTO;
import com.example.demo.dto.FactureDTO;
import com.example.demo.dto.LigneFactureDTO;
import com.example.demo.entity.Client;
import com.example.demo.entity.Facture;
import com.example.demo.entity.LigneFacture;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.List;
import java.lang.*;
import java.util.stream.Stream;
import javax.persistence.*;


@Service
public class ExportPDFITextService {
    public void export(OutputStream os, FactureDTO facture) throws IOException, DocumentException {

        Document document = new Document();
        PdfWriter.getInstance(document, os);

        ClientDTO client = facture.getClient();
        List<LigneFactureDTO> ligneFactureDTO = facture.getLigneFactures();

        document.open();

        Font font1 = FontFactory.getFont(FontFactory.COURIER, 18, BaseColor.BLACK);

        Paragraph para = new Paragraph(client.getNom()+" "+client.getPrenom(), font1);
        document.add(para);
        Paragraph para2 = new Paragraph("Facture numéro "+facture.getId(),font1);
        document.add(para2);
        Paragraph para3 = new Paragraph("\n");
        document.add(para3);

        PdfPTable table = new PdfPTable(3);

        addTableHeader(table);

        Font font3 = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLUE);

        Double total = 0.0;

        for(LigneFactureDTO lf : ligneFactureDTO ){

            PdfPCell designation = new PdfPCell(new Phrase(lf.getDesignation(),font3));
            designation.setHorizontalAlignment(Element.ALIGN_CENTER);
            designation.setVerticalAlignment(Element.ALIGN_MIDDLE);
            designation.setPadding(6);
            table.addCell(designation);

            PdfPCell quantite = new PdfPCell(new Phrase(lf.getQuantite().toString(),font3));
            quantite.setHorizontalAlignment(Element.ALIGN_CENTER);
            quantite.setVerticalAlignment(Element.ALIGN_MIDDLE);
            quantite.setPadding(6);
            table.addCell(quantite);

            PdfPCell prix = new PdfPCell(new Phrase(lf.getPrixUnitaire().toString(),font3));
            prix.setHorizontalAlignment(Element.ALIGN_CENTER);
            prix.setVerticalAlignment(Element.ALIGN_MIDDLE);
            prix.setPadding(6);
            table.addCell(prix);

            total +=(lf.getPrixUnitaire() * lf.getQuantite());
        }

        DecimalFormat df = new DecimalFormat("###.##");
        String total2 = df.format(total);

        PdfPCell cellTotal = new PdfPCell(new Phrase("Total",font3));
        cellTotal.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellTotal.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellTotal.setPadding(6);
        cellTotal.setColspan(2);
        table.addCell(cellTotal);

        PdfPCell cellTotal2 = new PdfPCell(new Phrase(total2,font3));
        cellTotal2.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellTotal2.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellTotal2.setPadding(6);
        table.addCell(cellTotal2);

        document.add(table);
        document.close();
    }

    private void addTableHeader(PdfPTable table) {
        Font font = FontFactory.getFont(FontFactory.COURIER, 18, BaseColor.WHITE);
        Stream.of("Description", "Quantite", "Prix")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.BLUE);
                    header.setPhrase(new Phrase(columnTitle, font));
                    header.setHorizontalAlignment(Element.ALIGN_CENTER);
                    header.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    header.setPadding(8);
                    table.addCell(header);
                });
    }

}
