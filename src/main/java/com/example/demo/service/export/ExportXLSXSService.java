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

        for(ClientDTO cl : clients){

            XSSFRow headerRow = sheet.createRow(i);
            XSSFCell cellPrenom = headerRow.createCell(0);
            cellPrenom.setCellValue(cl.getPrenom());
            XSSFCell cellNom = headerRow.createCell(1);
            cellNom.setCellValue(cl.getNom());
            i++;
        }
        workbook.write(os);
        workbook.close();
    }
}
