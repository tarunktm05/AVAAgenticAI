package com.example.gitlab.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "releases", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"tag", "project_id"})
})
public class Release {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tag;

    @Column(length = 2048)
    private String description;

    @Column(nullable = false)
    private Long projectId;

    @Column
    private Long milestoneId;

    // Getters and Setters
    // (Omitted for brevity, use Lombok @Getter/@Setter in real code)
}