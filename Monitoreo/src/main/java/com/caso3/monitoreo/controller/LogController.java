package com.caso3.monitoreo.controller;


import com.caso3.monitoreo.model.ApiLog;
import com.caso3.monitoreo.repository.ApiLogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/logs")
public class LogController {

    @Autowired
    private ApiLogRepository repository;

    @PostMapping
    public ApiLog guardar(@RequestBody ApiLog log) {

        log.setFecha(LocalDateTime.now());

        return repository.save(log);
    }
}

