package com.maatech.user.rest;

import com.maatech.config.security.TokenService;
import com.maatech.user.entity.UserRole;
import com.maatech.user.entity.dto.AuthenticationDTO;
import com.maatech.user.entity.dto.LoginResponseDTO;
import com.maatech.user.entity.dto.RegisterDTO;
import com.maatech.user.entity.User;
import com.maatech.user.entity.dto.UserRequestDTO;
import com.maatech.user.mapper.UserMapper;
import com.maatech.user.repository.UserRepository;
import com.maatech.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationRest {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.getEmail(), data.getPassword());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToke((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDTO data){
        if(this.repository.findByEmail(data.getEmail()) != null){
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.getPassword());
        UserRequestDTO newUser = new UserRequestDTO(data.getName(), data.getEmail(), encryptedPassword, UserRole.USER);

        return userService.createUser(newUser);
    }
}
