package com.leoncarraro.agendamento_vacina.model.vo;

import com.leoncarraro.agendamento_vacina.model.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoginVO {

    private User user;

}
