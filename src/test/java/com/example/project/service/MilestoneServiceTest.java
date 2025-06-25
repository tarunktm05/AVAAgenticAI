package com.example.project.service;

import com.example.project.entity.Milestone;
import com.example.project.exception.ResourceNotFoundException;
import com.example.project.repository.MilestoneRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MilestoneServiceTest {
    @Mock
    private MilestoneRepository milestoneRepository;

    @InjectMocks
    private MilestoneService milestoneService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetMilestoneById_NotFound() {
        when(milestoneRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> milestoneService.getMilestoneById(1L));
    }
}
