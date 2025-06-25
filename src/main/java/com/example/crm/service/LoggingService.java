package com.example.crm.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoggingService {

    public void logInfo(String message) {
        log.info(message);
    }

    public void logWarn(String message) {
        log.warn(message);
    }

    public void logError(String message, Throwable t) {
        log.error(message, t);
    }
}
