package com.example.profile.controller;

import com.example.profile.model.Profile;
import com.example.profile.service.ProfileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/profiles")
public class ProfileController {
    private final ProfileService profileService;
    public ProfileController(ProfileService profileService) { this.profileService = profileService; }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("profiles", profileService.findAll());
        return "profile";
    }

    @PostMapping
    public String create(Profile profile) {
        profileService.save(profile);
        return "redirect:/profiles";
    }
}
