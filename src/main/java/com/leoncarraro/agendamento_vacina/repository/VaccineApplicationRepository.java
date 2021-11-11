package com.leoncarraro.agendamento_vacina.repository;

import com.leoncarraro.agendamento_vacina.model.entity.VaccineApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccineApplicationRepository extends JpaRepository<VaccineApplication, Long> {
}
