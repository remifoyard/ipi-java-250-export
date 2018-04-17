package com.example.demo.service.export;

import com.example.demo.dto.ClientDTO;
import com.example.demo.dto.FactureDTO;
import com.example.demo.dto.LigneFactureDTO;
import com.example.demo.entity.Facture;
import com.example.demo.entity.Article;

import com.example.demo.entity.LigneFacture;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.List;

@Service
public class ExportXLSXSService2 {

    public void export(OutputStream os, ClientDTO client, List<Facture> factures) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        CellStyle style = workbook.createCellStyle();

        Font font = workbook.createFont();
        font.setColor(IndexedColors.BLUE.getIndex());
        style.setFont(font);

        client.getId();

        Integer i;
        Double total;
        Integer totalQ;
        for(Facture fa : factures){
            i=0;
            total = 0.0;
            totalQ = 0;

            XSSFSheet  sheet = workbook.createSheet("Facture N°"+fa.getId());

            XSSFRow headerRow = sheet.createRow(i);

            XSSFCell cellNomPrenom = headerRow.createCell(0);
            cellNomPrenom.setCellValue(client.getNom()+" "+client.getPrenom());
            cellNomPrenom.setCellStyle(style);

            for(LigneFacture lf : fa.getLigneFactures()){
                i++;
                Article art = lf.getArticle();
                XSSFRow row = sheet.createRow(i);

                XSSFCell cellDesignation = row.createCell(0);
                cellDesignation.setCellValue(art.getLibelle());

                XSSFCell cellQuantite = row.createCell(1);
                cellQuantite.setCellValue(lf.getQuantite());

                XSSFCell cellPrix = row.createCell(2);
                cellPrix.setCellValue(art.getPrix());

                total +=(art.getPrix() * lf.getQuantite());
                totalQ += lf.getQuantite();

            }

            i++;
            DecimalFormat df = new DecimalFormat("###.##");
            String total2 = df.format(total);

            XSSFRow row2 = sheet.createRow(i);
            XSSFCell cellTotal = row2.createCell(0);
            cellTotal.setCellValue("Total");

            XSSFCell cellTotalQ = row2.createCell(1);
            cellTotalQ.setCellValue(totalQ);

            XSSFCell cellTotal2 = row2.createCell(2);
            cellTotal2.setCellValue(total2);

            sheet.addMergedRegion(new CellRangeAddress(0,0,0,2));

        }

        workbook.write(os);
        workbook.close();
    }
}
