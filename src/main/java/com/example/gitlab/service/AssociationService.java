package com.example.gitlab.service;

import com.example.gitlab.dto.ReleaseAssociationResponseDTO;
import com.example.gitlab.entity.Milestone;
import com.example.gitlab.entity.Release;
import com.example.gitlab.exception.MilestoneNotFoundException;
import com.example.gitlab.exception.ReleaseAlreadyAssociatedException;
import com.example.gitlab.repository.MilestoneRepository;
import com.example.gitlab.repository.ReleaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AssociationService {

    @Autowired
    private MilestoneRepository milestoneRepository;

    @Autowired
    private ReleaseRepository releaseRepository;

    @Transactional
    public ReleaseAssociationResponseDTO associateReleaseWithMilestone(Long releaseId, Long milestoneId) {
        Release release = releaseRepository.findById(releaseId)
                .orElseThrow(() -> new com.example.gitlab.exception.ReleaseNotFoundException("Release not found"));
        Milestone milestone = milestoneRepository.findById(milestoneId)
                .orElseThrow(() -> new MilestoneNotFoundException("Milestone not found"));

        if (release.getMilestoneId() != null) {
            throw new ReleaseAlreadyAssociatedException("Release already associated with a milestone");
        }

        release.setMilestoneId(milestone.getId());
        releaseRepository.save(release);

        return new ReleaseAssociationResponseDTO(release.getId(), milestone.getId(), "associated");
    }
}