package com.example.crm.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerResponseDTO {
    private String id;
    private String name;
    private String email;
    private String phone;
}
