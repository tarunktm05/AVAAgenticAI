package com.example.gitlab.service;

import com.example.gitlab.dto.MilestoneRequestDTO;
import com.example.gitlab.dto.MilestoneResponseDTO;
import com.example.gitlab.entity.Milestone;
import com.example.gitlab.exception.DuplicateMilestoneTitleException;
import com.example.gitlab.exception.InvalidDateRangeException;
import com.example.gitlab.repository.MilestoneRepository;
import com.example.gitlab.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MilestoneService {

    @Autowired
    private MilestoneRepository milestoneRepository;

    @Autowired
    private ValidationUtil validationUtil;

    @Transactional
    public MilestoneResponseDTO createMilestone(MilestoneRequestDTO request) {
        if (!validationUtil.isDateRangeValid(request.getStartDate(), request.getDueDate())) {
            throw new InvalidDateRangeException("Start date must be before or equal to due date");
        }
        if (request.getProjectId() != null) {
            milestoneRepository.findByTitleAndProjectId(request.getTitle(), request.getProjectId())
                    .ifPresent(m -> { throw new DuplicateMilestoneTitleException("Milestone title must be unique within project"); });
        }
        if (request.getGroupId() != null) {
            milestoneRepository.findByTitleAndGroupId(request.getTitle(), request.getGroupId())
                    .ifPresent(m -> { throw new DuplicateMilestoneTitleException("Milestone title must be unique within group"); });
        }
        Milestone milestone = new Milestone();
        milestone.setTitle(request.getTitle());
        milestone.setDescription(request.getDescription());
        milestone.setStartDate(request.getStartDate());
        milestone.setDueDate(request.getDueDate());
        milestone.setState("active");
        milestone.setProjectId(request.getProjectId());
        milestone.setGroupId(request.getGroupId());
        Milestone saved = milestoneRepository.save(milestone);

        MilestoneResponseDTO response = new MilestoneResponseDTO();
        response.setId(saved.getId());
        response.setTitle(saved.getTitle());
        response.setDescription(saved.getDescription());
        response.setStartDate(saved.getStartDate());
        response.setDueDate(saved.getDueDate());
        response.setState(saved.getState());
        return response;
    }
}