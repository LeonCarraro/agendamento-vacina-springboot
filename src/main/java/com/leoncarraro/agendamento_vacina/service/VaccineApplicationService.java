package com.leoncarraro.agendamento_vacina.service;

import com.leoncarraro.agendamento_vacina.exception.UserNotFoundException;
import com.leoncarraro.agendamento_vacina.exception.VaccineApplicationNotFoundException;
import com.leoncarraro.agendamento_vacina.model.entity.*;
import com.leoncarraro.agendamento_vacina.model.enumeration.Status;
import com.leoncarraro.agendamento_vacina.model.vo.VaccineApplicationVO;
import com.leoncarraro.agendamento_vacina.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VaccineApplicationService {

    private final UserRepository userRepository;
    private final AgeGroupRepository ageGroupRepository;
    private final HealthPostRepository healthPostRepository;
    private final ScheduleRepository scheduleRepository;
    private final VaccineApplicationRepository vaccineApplicationRepository;

    public VaccineApplication save(VaccineApplicationVO vaccineApplicationVO) {
        return vaccineApplicationRepository.save(validate(vaccineApplicationVO));
    }

    public VaccineApplication update(VaccineApplicationVO vaccineApplicationVO, Long id) {
        VaccineApplication old = findById(id);
        VaccineApplication actual = validate(vaccineApplicationVO);

        BeanUtils.copyProperties(actual, old, "id", "user", "isActive");

        old.setIsActive(Status.ATIVO);

        return vaccineApplicationRepository.save(old);
    }

    public VaccineApplication findById(Long id) {
        return vaccineApplicationRepository.findById(id)
                .orElseThrow(() -> new VaccineApplicationNotFoundException("Agendamento não encontrado!"));
    }

    public VaccineApplication findByUserId(Long id) {
        return vaccineApplicationRepository.findByUserId(id)
                .orElseThrow(() -> new VaccineApplicationNotFoundException("Agendamento não encontrado!"));
    }

    public void delete(Long id) {
        VaccineApplication vaccineApplication = findById(id);
        vaccineApplication.setIsActive(Status.INATIVO);
        vaccineApplicationRepository.save(vaccineApplication);
    }

    private VaccineApplication validate(VaccineApplicationVO vaccineApplicationVO) {
        User user = userRepository.findById(vaccineApplicationVO.getUserId())
                .orElseThrow(() -> new UserNotFoundException("CPF não cadastrado!"));
        AgeGroup ageGroup = ageGroupRepository.findById((long) vaccineApplicationVO.getGroupId())
                .orElseThrow(() -> new RuntimeException("Grupo de idade não cadastrado!"));
        HealthPost healthPost = healthPostRepository.findById((long) vaccineApplicationVO.getHealthPostId())
                .orElseThrow(() -> new RuntimeException("Posto de saúde cadastrado!"));
        Schedule schedule = scheduleRepository.findById((long) vaccineApplicationVO.getScheduleId())
                .orElseThrow(() -> new RuntimeException("Agenda cadastrada!"));

        return VaccineApplication
                .builder()
                .isActive(Status.ATIVO)
                .user(user)
                .ageGroup(ageGroup)
                .healthPost(healthPost)
                .schedule(schedule)
                .build();
    }
}
