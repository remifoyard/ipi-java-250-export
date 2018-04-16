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
        XSSFRow headerRow = sheet.createRow(0);
        XSSFCell cellPrenom = headerRow.createCell(0);
        cellPrenom.setCellValue("Prénom");
        workbook.write(os);
        workbook.close();
    }
}
