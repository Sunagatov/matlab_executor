package com.aerospace.university.matlab_executor.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class FileHandlerService {

    public String read(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    public void write(String data, String filePath) throws IOException {
        Files.write(Paths.get(filePath), data.getBytes());
    }

    public String replace(String text, String oldWord, String newWord) {
        return text.replace(oldWord, newWord);
    }
}
