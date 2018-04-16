package com.example.demo.service.export;

import com.example.demo.dto.ClientDTO;
import java.io.*;
import java.util.*;
import org.apache.poi.xssf.usermodel.*;
<<<<<<< HEAD
import org.springframework.stereotype.Service;

@Service
=======


>>>>>>> 6fb39d24ac020203d67dc8ae549e5778ded29dda
public class ExportXLSXSService {

    public void export(OutputStream os, List<ClientDTO> clients) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet  sheet = workbook.createSheet("clients");
<<<<<<< HEAD
        XSSFRow headerRow = sheet.createRow(0);
        XSSFCell cellPrenom = headerRow.createCell(0);
        cellPrenom.setCellValue("Prénom");
=======

>>>>>>> 6fb39d24ac020203d67dc8ae549e5778ded29dda
        workbook.write(os);
        workbook.close();
    }
}
