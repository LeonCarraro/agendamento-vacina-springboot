package com.leoncarraro.agendamento_vacina.service;

import com.leoncarraro.agendamento_vacina.exception.UserNotFoundException;
import com.leoncarraro.agendamento_vacina.model.entity.*;
import com.leoncarraro.agendamento_vacina.model.vo.VaccineApplicationVO;
import com.leoncarraro.agendamento_vacina.repository.*;
import lombok.AllArgsConstructor;
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
        User user = userRepository.findByCpf(vaccineApplicationVO.getCpf())
                .orElseThrow(() -> new UserNotFoundException("CPF não cadastrado!"));
        AgeGroup ageGroup = ageGroupRepository.findById((long) vaccineApplicationVO.getGroupId())
                .orElseThrow(() -> new RuntimeException("Grupo de idade não cadastrado!"));
        HealthPost healthPost = healthPostRepository.findById((long) vaccineApplicationVO.getHealthPostId())
                .orElseThrow(() -> new RuntimeException("Posto de saúde cadastrado!"));
        Schedule schedule = scheduleRepository.findById((long) vaccineApplicationVO.getScheduleId())
                .orElseThrow(() -> new RuntimeException("Agenda cadastrada!"));

        return vaccineApplicationRepository.save(VaccineApplication
                .builder()
                .user(user)
                .ageGroup(ageGroup)
                .healthPost(healthPost)
                .schedule(schedule)
                .build());
    }
}
