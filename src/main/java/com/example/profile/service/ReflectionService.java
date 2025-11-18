package com.example.profile.service;

import com.example.profile.model.Reflection;
import com.example.profile.model.User;
import com.example.profile.repository.ReflectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReflectionService {
    private final ReflectionRepository reflectionRepository;

    public ReflectionService(ReflectionRepository reflectionRepository) {
        this.reflectionRepository = reflectionRepository;
    }

    public void save(Reflection reflection) {
        reflectionRepository.save(reflection);
    }

    public void delete(Long id) {
        reflectionRepository.deleteById(id);
    }

    public List<Reflection> findByUser(User user) {
        return reflectionRepository.findByUserOrderByDateDesc(user);
    }
}
