package com.caso3.backup.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/backup")
public class BackupController {

    @GetMapping("/productos")
    public String backupProductos() {
        return "Backup ejecutado";
    }
}