package com.example.crm.util;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseBuilder {

    public <T> ResponseEntity<T> buildResponse(T body, int status) {
        return ResponseEntity.status(status).body(body);
    }
}
