package com.example.profile.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "profile")
public class Profile {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String fullName;
    private String bio;
    private String profileImageUrl;
    private String visibility = "PUBLIC";
    private LocalDateTime updatedAt = LocalDateTime.now();
}
