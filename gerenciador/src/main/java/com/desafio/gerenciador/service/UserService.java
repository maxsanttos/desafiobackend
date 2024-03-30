package com.desafio.gerenciador.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.desafio.gerenciador.domain.repository.UserRepository;
import com.desafio.gerenciador.domain.users.User;

@Service
public class UserService {
    
    private final UserRepository userRepository;
 
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
 
    public User getLoggedInUser(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails){
            String login = ((UserDetails) principal).getUsername();
            // Consultar o repositorio de usuarios para obter o objeto user com base no login
            return  userRepository.findUserByLogin(login);
 
        }
        return null;
    }
}
