package com.example.gitlab.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "milestones", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"title", "project_id", "group_id"})
})
public class Milestone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 2048)
    private String description;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate dueDate;

    @Column(nullable = false)
    private String state;

    @Column
    private Long projectId;

    @Column
    private Long groupId;

    // Getters and Setters
    // (Omitted for brevity, use Lombok @Getter/@Setter in real code)
}