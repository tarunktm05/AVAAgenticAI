package com.example.gitlab.service;

import com.example.gitlab.entity.Release;
import com.example.gitlab.exception.ReleaseTagNotUniqueException;
import com.example.gitlab.repository.ReleaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReleaseService {

    @Autowired
    private ReleaseRepository releaseRepository;

    public void validateReleaseTagUnique(String tag, Long projectId) {
        releaseRepository.findByTagAndProjectId(tag, projectId)
                .ifPresent(r -> { throw new ReleaseTagNotUniqueException("Release tag must be unique within project"); });
    }

    public Release getReleaseById(Long releaseId) {
        return releaseRepository.findById(releaseId)
                .orElseThrow(() -> new com.example.gitlab.exception.ReleaseNotFoundException("Release not found"));
    }
}