package com.leoncarraro.agendamento_vacina.service;

import com.leoncarraro.agendamento_vacina.exception.LoginException;
import com.leoncarraro.agendamento_vacina.exception.UserNotFoundException;
import com.leoncarraro.agendamento_vacina.model.dto.LoginDTO;
import com.leoncarraro.agendamento_vacina.model.entity.User;
import com.leoncarraro.agendamento_vacina.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    public void login(LoginDTO loginDTO) {
        validateAccount(loginDTO);
    }

    private void validateAccount(LoginDTO loginDTO) {
        User user = userRepository.findByCpf(loginDTO.getCpf())
                .orElseThrow(() -> new UserNotFoundException("CPF não cadastrado!"));

        if (!user.getPassword().equals(loginDTO.getPassword())) {
            throw new LoginException("CPF ou senha inválido!");
        }
    }

}
