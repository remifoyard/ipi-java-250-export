package com.example.demo.service.export;

import com.example.demo.dto.ClientDTO;
import java.io.*;
import java.util.*;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Service;

@Service
public class ExportXLSXSService {

    public void export(OutputStream os, List<ClientDTO> clients) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet  sheet = workbook.createSheet("clients");

        Integer i=0;

        XSSFRow headerRow1 = sheet.createRow(i);

        XSSFCell cellNom1 = headerRow1.createCell(0);
        cellNom1.setCellValue("Nom");

        XSSFCell cellPrenom1 = headerRow1.createCell(1);
        cellPrenom1.setCellValue("Prenom");

        for(ClientDTO cl : clients){
            i++;

            XSSFRow headerRow = sheet.createRow(i);

            XSSFCell cellNom = headerRow.createCell(0);
            cellNom.setCellValue(cl.getNom());

            XSSFCell cellPrenom = headerRow.createCell(1);
            cellPrenom.setCellValue(cl.getPrenom());
        }

        workbook.write(os);
        workbook.close();
    }
}
