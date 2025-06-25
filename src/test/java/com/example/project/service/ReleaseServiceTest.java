package com.example.project.service;

import com.example.project.entity.Release;
import com.example.project.entity.Milestone;
import com.example.project.exception.ResourceNotFoundException;
import com.example.project.repository.ReleaseRepository;
import com.example.project.repository.MilestoneRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ReleaseServiceTest {
    @Mock
    private ReleaseRepository releaseRepository;
    @Mock
    private MilestoneRepository milestoneRepository;
    @InjectMocks
    private ReleaseService releaseService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetReleaseById_NotFound() {
        when(releaseRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> releaseService.getReleaseById(1L));
    }

    @Test
    void testCreateRelease_MilestoneNotFound() {
        Release release = new Release();
        when(milestoneRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> releaseService.createRelease(release, 1L));
    }
}
