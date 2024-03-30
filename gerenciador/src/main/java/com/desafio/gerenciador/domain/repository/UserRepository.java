package com.desafio.gerenciador.domain.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.desafio.gerenciador.domain.users.User;

public interface UserRepository extends JpaRepository<User, Long>{
    UserDetails findByLogin(String login);
    
    User findUserByLogin(String login);
    
}
