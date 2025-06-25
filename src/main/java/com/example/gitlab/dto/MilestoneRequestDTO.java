package com.example.gitlab.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public class MilestoneRequestDTO {

    @NotBlank
    @Size(max = 255)
    private String title;

    @Size(max = 2048)
    private String description;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate dueDate;

    private Long projectId;
    private Long groupId;

    // Getters and Setters
}