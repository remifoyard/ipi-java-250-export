package com.example.demo.service.export;

import com.example.demo.dto.ClientDTO;
import java.io.*;
import java.util.*;
import org.apache.poi.xssf.usermodel.*;


public class ExportXLSXSService {

    public void export(OutputStream os, List<ClientDTO> clients) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet  sheet = workbook.createSheet("clients");

        workbook.write(os);
        workbook.close();
    }
}
