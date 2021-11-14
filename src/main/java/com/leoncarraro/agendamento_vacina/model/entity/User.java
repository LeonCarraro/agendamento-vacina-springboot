package com.leoncarraro.agendamento_vacina.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.leoncarraro.agendamento_vacina.model.enumeration.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "TB_USER")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private LocalDate birthDate;
    private String email;
    private String password;

    @OneToOne(mappedBy = "user")
    @JsonIgnore
    private VaccineApplication vaccineApplication;

    @JsonProperty("hasSchedule")
    public boolean hasSchedule() {
        return vaccineApplication != null &&
               vaccineApplication.getId() != null &&
               vaccineApplication.getIsActive().equals(Status.ATIVO);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
