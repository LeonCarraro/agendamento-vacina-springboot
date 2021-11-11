package com.leoncarraro.agendamento_vacina.controller;

import com.leoncarraro.agendamento_vacina.model.entity.Schedule;
import com.leoncarraro.agendamento_vacina.repository.ScheduleRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/schedules")
@AllArgsConstructor
public class ScheduleController {

    private final ScheduleRepository scheduleRepository;

    @GetMapping
    public ResponseEntity<List<Schedule>> findAll() {
        return ResponseEntity.ok(scheduleRepository.findAll());
    }
}
