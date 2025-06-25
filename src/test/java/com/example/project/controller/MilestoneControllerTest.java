package com.example.project.controller;

import com.example.project.entity.Milestone;
import com.example.project.service.MilestoneService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MilestoneControllerTest {
    @Mock
    private MilestoneService milestoneService;

    @InjectMocks
    private MilestoneController milestoneController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllMilestones() {
        Milestone m1 = new Milestone();
        Milestone m2 = new Milestone();
        when(milestoneService.getAllMilestones()).thenReturn(Arrays.asList(m1, m2));
        List<Milestone> result = milestoneController.getAllMilestones();
        assertEquals(2, result.size());
    }

    @Test
    void testGetMilestoneById() {
        Milestone m = new Milestone();
        when(milestoneService.getMilestoneById(1L)).thenReturn(m);
        ResponseEntity<Milestone> response = milestoneController.getMilestoneById(1L);
        assertEquals(m, response.getBody());
    }
}
