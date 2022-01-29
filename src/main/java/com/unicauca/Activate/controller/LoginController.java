package com.unicauca.Activate.controller;

import com.unicauca.Activate.entity.User;
import com.unicauca.Activate.service.UserService;
import com.unicauca.Activate.utils.JWTUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private UserService UserService;
    @Autowired
    private JWTUtil jwtUtil;

    //Crear Usuario
    @PostMapping
    public String  login(@RequestBody User user){
        User usuarioLogueado = UserService.verificarCredenciales(user);
        if (usuarioLogueado != null) {
            String tokenJwt = jwtUtil.create(String.valueOf(usuarioLogueado.getId()), usuarioLogueado.getEmail());
            return tokenJwt;
        }
        return "FAIL";
         
    }
    
}
