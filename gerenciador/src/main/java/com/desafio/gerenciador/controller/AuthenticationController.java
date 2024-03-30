package com.desafio.gerenciador.controller;


import java.util.List;
import java.util.stream.Collectors;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.desafio.gerenciador.config.TokenService;
import com.desafio.gerenciador.domain.repository.UserRepository;
import com.desafio.gerenciador.domain.users.User;
import com.desafio.gerenciador.domain.users.dto.AuthenticationDTO;
import com.desafio.gerenciador.domain.users.dto.LoginResponseDTO;
import com.desafio.gerenciador.domain.users.dto.ResgisterDTO;
import com.desafio.gerenciador.domain.users.dto.UserInfoDTO;




@RestController
@RequestMapping("auth")
public class AuthenticationController {
   
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());


        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid ResgisterDTO data){
        if (this.repository.findByLogin(data.login()) != null) {
            return ResponseEntity.badRequest().build();
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.login(), encryptedPassword, data.role());

        this.repository.save(newUser);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserInfoDTO>> getAllUsers() {
        List<User> users = repository.findAll();
        List<UserInfoDTO> userInfos = users.stream()
                .map(user -> new UserInfoDTO(user.getUser_id(), user.getLogin(), user.getRole()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(userInfos);
    }
}
