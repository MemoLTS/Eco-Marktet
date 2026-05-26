package com.caso3.backup.service;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BackupService {

    @Autowired
    private RestTemplate restTemplate;

    public void generarBackup() {
        String data = restTemplate.getForObject(
            "http://localhost:8084/productos",
            String.class
        );

        try {
            String fileName = "backup_" + System.currentTimeMillis() + ".json";

            Files.write(
                Paths.get("backups/" + fileName),
                data.getBytes()
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}