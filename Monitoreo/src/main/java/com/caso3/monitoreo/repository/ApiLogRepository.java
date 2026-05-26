package com.caso3.monitoreo.repository;

import com.caso3.monitoreo.model.ApiLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiLogRepository extends JpaRepository<ApiLog, Long> {
}