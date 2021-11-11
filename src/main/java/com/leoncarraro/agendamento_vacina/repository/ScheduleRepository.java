package com.leoncarraro.agendamento_vacina.repository;

import com.leoncarraro.agendamento_vacina.model.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
