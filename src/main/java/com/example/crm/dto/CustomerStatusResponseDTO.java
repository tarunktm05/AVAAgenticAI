package com.example.crm.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerStatusResponseDTO {
    private String id;
    private String status;
}
