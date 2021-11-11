package com.leoncarraro.agendamento_vacina.controller;

import com.leoncarraro.agendamento_vacina.model.entity.AgeGroup;
import com.leoncarraro.agendamento_vacina.repository.AgeGroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/age-groups")
@AllArgsConstructor
public class AgeGroupController {

    private final AgeGroupRepository ageGroupRepository;

    @GetMapping
    public ResponseEntity<List<AgeGroup>> findAll() {
        return ResponseEntity.ok(ageGroupRepository.findAll());
    }
}
