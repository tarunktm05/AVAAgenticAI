package com.example.project.repository;

import com.example.project.entity.Release;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ReleaseRepositoryTest {
    @Autowired
    private ReleaseRepository releaseRepository;

    @Test
    void testSaveAndFind() {
        Release release = new Release();
        release.setName("Test Release");
        Release saved = releaseRepository.save(release);
        assertThat(releaseRepository.findById(saved.getId())).isPresent();
    }
}
