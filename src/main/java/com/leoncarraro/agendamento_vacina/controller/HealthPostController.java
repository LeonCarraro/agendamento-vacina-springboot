package com.leoncarraro.agendamento_vacina.controller;

import com.leoncarraro.agendamento_vacina.model.entity.HealthPost;
import com.leoncarraro.agendamento_vacina.repository.HealthPostRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/health-posts")
@AllArgsConstructor
public class HealthPostController {

    private final HealthPostRepository healthPostRepository;

    @GetMapping
    public ResponseEntity<List<HealthPost>> findAll() {
        return ResponseEntity.ok(healthPostRepository.findAll());
    }
}
