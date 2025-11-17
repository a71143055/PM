package com.example.profile.service;

import com.example.profile.model.Profile;
import com.example.profile.repository.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {
    private final ProfileRepository profileRepository;
    public ProfileService(ProfileRepository profileRepository) { this.profileRepository = profileRepository; }

    public Profile save(Profile profile) { return profileRepository.save(profile); }
    public List<Profile> findAll() { return profileRepository.findAll(); }
}
