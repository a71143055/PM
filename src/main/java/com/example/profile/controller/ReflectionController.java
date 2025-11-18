package com.example.profile.controller;

import com.example.profile.model.Reflection;
import com.example.profile.model.User;
import com.example.profile.service.ReflectionService;
import com.example.profile.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/reflections")
public class ReflectionController {
    private final ReflectionService reflectionService;
    private final UserService userService;

    public ReflectionController(ReflectionService reflectionService, UserService userService) {
        this.reflectionService = reflectionService;
        this.userService = userService;
    }

    @GetMapping
    public String listReflections(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName()).orElseThrow();
        List<Reflection> reflections = reflectionService.findByUser(user);
        model.addAttribute("reflections", reflections);
        model.addAttribute("newReflection", new Reflection());
        return "reflections";
    }

    @PostMapping
    public String addReflection(@ModelAttribute("newReflection") Reflection reflection, Principal principal) {
        User user = userService.findByUsername(principal.getName()).orElseThrow();
        reflection.setUser(user);
        if (reflection.getDate() == null) {
            reflection.setDate(LocalDate.now());
        }
        reflectionService.save(reflection);
        return "redirect:/reflections";
    }

    @PostMapping("/delete/{id}")
    public String deleteReflection(@PathVariable Long id) {
        reflectionService.delete(id);
        return "redirect:/reflections";
    }

    // CSV 문서화
    @GetMapping(value = "/export.csv", produces = "text/csv")
    @ResponseBody
    public String exportCsv(Principal principal) {
        User user = userService.findByUsername(principal.getName()).orElseThrow();
        StringBuilder sb = new StringBuilder("date,mood,reflection,goals\n");
        reflectionService.findByUser(user).forEach(r -> sb.append(escape(r.getDate()))
                .append(",").append(escape(r.getMood()))
                .append(",").append(escape(r.getReflection()))
                .append(",").append(escape(r.getGoals()))
                .append("\n"));
        return sb.toString();
    }

    // HTML 문서화
    @GetMapping("/export.html")
    public String exportHtml(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName()).orElseThrow();
        model.addAttribute("reflections", reflectionService.findByUser(user));
        model.addAttribute("username", user.getUsername());
        return "reflections_export"; // 별도 템플릿
    }

    private String escape(Object v) {
        if (v == null) return "";
        String s = v.toString().replace("\"", "\"\"");
        return "\"" + s + "\"";
    }
}
