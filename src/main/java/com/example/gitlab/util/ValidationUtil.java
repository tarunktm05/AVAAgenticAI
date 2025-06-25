package com.example.gitlab.util;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ValidationUtil {

    public boolean isDateRangeValid(LocalDate start, LocalDate end) {
        return start != null && end != null && !start.isAfter(end);
    }
}