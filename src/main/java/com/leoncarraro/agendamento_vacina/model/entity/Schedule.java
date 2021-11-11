package com.leoncarraro.agendamento_vacina.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "TB_SCHEDULES")
@Getter
@Setter
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dayOfWeek;
    private LocalDate dayOfMonth;
    private LocalTime schedule;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule ageGroup = (Schedule) o;
        return id.equals(ageGroup.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
