package com.desafio.gerenciador.domain.users.dto;

import com.desafio.gerenciador.domain.users.UserRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfoDTO {
    private Long user_id;
    private String login;
    private UserRole role;
}
