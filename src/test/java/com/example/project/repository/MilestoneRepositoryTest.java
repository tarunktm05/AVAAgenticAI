package com.example.project.repository;

import com.example.project.entity.Milestone;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class MilestoneRepositoryTest {
    @Autowired
    private MilestoneRepository milestoneRepository;

    @Test
    void testSaveAndFind() {
        Milestone milestone = new Milestone();
        milestone.setName("Test Milestone");
        Milestone saved = milestoneRepository.save(milestone);
        assertThat(milestoneRepository.findById(saved.getId())).isPresent();
    }
}
