package com.example.profile.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "reflections")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Reflection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private String mood;

    @Column(columnDefinition = "TEXT")
    private String reflection;

    @Column(columnDefinition = "TEXT")
    private String goals;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
