package com.leoncarraro.agendamento_vacina.controller;

import com.leoncarraro.agendamento_vacina.model.entity.VaccineApplication;
import com.leoncarraro.agendamento_vacina.model.vo.VaccineApplicationVO;
import com.leoncarraro.agendamento_vacina.service.VaccineApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/vaccines-application")
@AllArgsConstructor
public class VaccineApplicationController {

    private final VaccineApplicationService vaccineApplicationService;

    @PostMapping
    public ResponseEntity<VaccineApplication> save(@RequestBody VaccineApplicationVO vaccineApplicationVO) {
        return ResponseEntity
                .created(null)
                .body(vaccineApplicationService.save(vaccineApplicationVO));
    }
}
