package com.maatech.user.rest;

import com.maatech.user.entity.AuthenticationDTO;
import com.maatech.user.entity.RegisterDTO;
import com.maatech.user.entity.User;
import com.maatech.user.entity.UserRequestDTO;
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

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.getEmail(), data.getPassword());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDTO data){
        if(this.repository.findByEmail(data.getEmail()) != null){
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.getPassword());
        UserRequestDTO newUser = new UserRequestDTO(data.getName(), data.getEmail(), encryptedPassword, data.getRole());

        userService.createUser(newUser);

        return ResponseEntity.ok().build();
    }
}
