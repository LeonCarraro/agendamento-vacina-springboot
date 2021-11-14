package com.leoncarraro.agendamento_vacina.repository;

import com.leoncarraro.agendamento_vacina.model.entity.VaccineApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VaccineApplicationRepository extends JpaRepository<VaccineApplication, Long> {

    Optional<VaccineApplication> findByUserId(Long id);
}
