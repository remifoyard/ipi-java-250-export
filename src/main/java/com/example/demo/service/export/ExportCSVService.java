package com.example.demo.service.export;

import org.springframework.stereotype.Service;
import com.example.demo.dto.ClientDTO;

import java.io.IOException;
import java.util.List;
import java.io.Writer;

@Service
public class ExportCSVService {

    public void export(Writer printWriter, List<ClientDTO> clients) throws IOException {
        printWriter.write("HELLO WORLD RF !");
    }
}
