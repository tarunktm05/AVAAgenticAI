package com.example.gitlab.controller;

import com.example.gitlab.dto.ErrorResponseDTO;
import com.example.gitlab.dto.MilestoneRequestDTO;
import com.example.gitlab.dto.MilestoneResponseDTO;
import com.example.gitlab.service.MilestoneService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/milestones")
public class MilestoneController {

    @Autowired
    private MilestoneService milestoneService;

    @PostMapping
    public ResponseEntity<?> createMilestone(@Valid @RequestBody MilestoneRequestDTO request) {
        try {
            MilestoneResponseDTO response = milestoneService.createMilestone(request);
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new ErrorResponseDTO(ex.getMessage()));
        }
    }
}