package com.example.profile.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileDto {
    private String fullName;
    private String bio;
    private String profileImageUrl;
    private String visibility;
}
