package com.example.project.controller;

import com.example.project.entity.Release;
import com.example.project.service.ReleaseService;
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

class ReleaseControllerTest {
    @Mock
    private ReleaseService releaseService;

    @InjectMocks
    private ReleaseController releaseController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllReleases() {
        Release r1 = new Release();
        Release r2 = new Release();
        when(releaseService.getAllReleases()).thenReturn(Arrays.asList(r1, r2));
        List<Release> result = releaseController.getAllReleases();
        assertEquals(2, result.size());
    }

    @Test
    void testGetReleaseById() {
        Release r = new Release();
        when(releaseService.getReleaseById(1L)).thenReturn(r);
        ResponseEntity<Release> response = releaseController.getReleaseById(1L);
        assertEquals(r, response.getBody());
    }
}
