package com.example.gitlab.dto;

public class ReleaseAssociationResponseDTO {

    private Long releaseId;
    private Long milestoneId;
    private String status;

    public ReleaseAssociationResponseDTO(Long releaseId, Long milestoneId, String status) {
        this.releaseId = releaseId;
        this.milestoneId = milestoneId;
        this.status = status;
    }

    // Getters and Setters
}