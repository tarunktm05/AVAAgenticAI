package com.example.gitlab.controller;

import com.example.gitlab.dto.ErrorResponseDTO;
import com.example.gitlab.dto.ReleaseAssociationResponseDTO;
import com.example.gitlab.service.AssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/releases")
public class ReleaseController {

    @Autowired
    private AssociationService associationService;

    @PostMapping("/{releaseId}/milestone/{milestoneId}")
    public ResponseEntity<?> associateReleaseWithMilestone(@PathVariable Long releaseId, @PathVariable Long milestoneId) {
        try {
            ReleaseAssociationResponseDTO response = associationService.associateReleaseWithMilestone(releaseId, milestoneId);
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new ErrorResponseDTO(ex.getMessage()));
        }
    }
}