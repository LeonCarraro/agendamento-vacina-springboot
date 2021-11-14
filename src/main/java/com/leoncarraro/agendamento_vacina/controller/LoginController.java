package com.leoncarraro.agendamento_vacina.controller;

import com.leoncarraro.agendamento_vacina.model.dto.LoginDTO;
import com.leoncarraro.agendamento_vacina.model.vo.LoginVO;
import com.leoncarraro.agendamento_vacina.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/login")
@AllArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    public ResponseEntity<LoginVO> login(@RequestBody LoginDTO loginDTO) {
        return ResponseEntity.ok(LoginVO.builder()
                .user(loginService.login(loginDTO))
                .build());
    }

}
