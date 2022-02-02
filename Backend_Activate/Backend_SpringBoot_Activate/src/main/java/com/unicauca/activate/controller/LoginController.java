/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.activate.controller;


import com.unicauca.activate.model.User;
import com.unicauca.activate.service.UserService;
import com.unicauca.activate.utilities.JWTUtilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activate")
public class LoginController {

    @Autowired
    private UserService UserService;
    @Autowired
    private JWTUtilities jwtUtil;

    //Crear Usuario
    @PostMapping("login")
    public String  login(@RequestBody User user){
        System.out.println("Desde JS"+ " " + user.getEmail());
        User usuarioLogueado = UserService.verificarCredenciales(user);
        if (usuarioLogueado != null) {
            String tokenJwt = jwtUtil.create(String.valueOf(usuarioLogueado.getId()), usuarioLogueado.getEmail());

            String usuario_inicio_sesion = "{\"Usuario\":\""+usuarioLogueado.getName()+"\", \"Token\":\""+tokenJwt+"\"}";


            return usuario_inicio_sesion;
        }
        return "FAIL";    
    }
    
}