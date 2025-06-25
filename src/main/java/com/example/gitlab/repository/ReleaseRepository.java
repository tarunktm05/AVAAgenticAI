package com.example.gitlab.repository;

import com.example.gitlab.entity.Release;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReleaseRepository extends JpaRepository<Release, Long> {

    Optional<Release> findByTagAndProjectId(String tag, Long projectId);

}