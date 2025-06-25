package com.example.crm.util;

import com.example.crm.dto.CustomerRequestDTO;
import com.example.crm.exception.ValidationException;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class ValidationUtil {

    private static final Pattern PHONE_PATTERN = Pattern.compile("^\+?[1-9]\d{1,14}$");

    public void validateCustomer(CustomerRequestDTO request) {
        if (request.getName() == null || request.getName().trim().isEmpty()) {
            throw new ValidationException("Name is required");
        }
        if (request.getEmail() == null || request.getEmail().trim().isEmpty()) {
            throw new ValidationException("Email is required");
        }
        if (!request.getEmail().matches("^[\w-.]+@([\w-]+\.)+[\w-]{2,4}$")) {
            throw new ValidationException("Invalid email address");
        }
        if (request.getPhone() == null || request.getPhone().trim().isEmpty()) {
            throw new ValidationException("Phone is required");
        }
        if (!PHONE_PATTERN.matcher(request.getPhone()).matches()) {
            throw new ValidationException("Invalid phone number");
        }
    }
}
