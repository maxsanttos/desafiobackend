package com.desafio.gerenciador.domain.users.dto;

import com.desafio.gerenciador.domain.users.UserRole;

public record ResgisterDTO(String login, String password, UserRole role) {
    
}
