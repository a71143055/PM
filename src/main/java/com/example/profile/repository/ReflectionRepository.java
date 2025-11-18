package com.example.profile.repository;

import com.example.profile.model.Reflection;
import com.example.profile.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReflectionRepository extends JpaRepository<Reflection, Long> {
    List<Reflection> findByUserOrderByDateDesc(User user);
}
