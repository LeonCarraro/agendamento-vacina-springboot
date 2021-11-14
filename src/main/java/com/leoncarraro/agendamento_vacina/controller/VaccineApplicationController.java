package com.leoncarraro.agendamento_vacina.controller;

import com.leoncarraro.agendamento_vacina.model.entity.VaccineApplication;
import com.leoncarraro.agendamento_vacina.model.vo.VaccineApplicationVO;
import com.leoncarraro.agendamento_vacina.service.VaccineApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/vaccines-application")
@AllArgsConstructor
public class VaccineApplicationController {

    private final VaccineApplicationService vaccineApplicationService;

    @PostMapping
    public ResponseEntity<VaccineApplication> save(@RequestBody VaccineApplicationVO vaccineApplicationVO) {
        VaccineApplication vaccineApplication = vaccineApplicationService.save(vaccineApplicationVO);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .pathSegment("{id}")
                .buildAndExpand(vaccineApplication.getId())
                .toUri();

        return ResponseEntity
                .created(uri)
                .body(vaccineApplication);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VaccineApplication> update(@RequestBody VaccineApplicationVO vaccineApplicationVO,
                                                     @PathVariable Long id) {
        return ResponseEntity.ok(vaccineApplicationService.update(vaccineApplicationVO, id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VaccineApplication> findById(@PathVariable Long id) {
        return ResponseEntity.ok(vaccineApplicationService.findById(id));
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<VaccineApplication> findByUserId(@PathVariable Long id) {
        return ResponseEntity.ok(vaccineApplicationService.findByUserId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vaccineApplicationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
