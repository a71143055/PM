package com.example.profile.controller;

import com.example.profile.model.Profile;
import com.example.profile.service.ProfileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping
    public String listProfiles(Model model) {
        model.addAttribute("profile", profileService.findAll());
        return "profile"; // profile.html
    }

    @PostMapping
    public String createProfile(@RequestParam String fullName,
                                @RequestParam String bio) {
        Profile profile = new Profile();
        profile.setFullName(fullName);
        profile.setBio(bio);
        profileService.save(profile);
        return "redirect:/profile";
    }
}

