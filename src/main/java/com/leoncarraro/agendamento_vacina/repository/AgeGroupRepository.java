package com.leoncarraro.agendamento_vacina.repository;

import com.leoncarraro.agendamento_vacina.model.entity.AgeGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgeGroupRepository extends JpaRepository<AgeGroup, Long> {
}
