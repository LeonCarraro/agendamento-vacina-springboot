package com.leoncarraro.agendamento_vacina.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TB_AGE_GROUPS")
@Getter
@Setter
public class AgeGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgeGroup ageGroup = (AgeGroup) o;
        return id.equals(ageGroup.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
