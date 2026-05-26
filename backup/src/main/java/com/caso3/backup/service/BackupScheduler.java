package com.caso3.backup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class BackupScheduler {

    @Autowired
    private BackupService service;

    @Scheduled(cron = "0 0 * * * *") // cada hora
    public void ejecutarBackup() {
        service.generarBackup();
    }
}