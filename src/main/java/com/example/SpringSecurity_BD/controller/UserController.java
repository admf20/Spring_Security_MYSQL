package com.example.SpringSecurity_BD.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableMethodSecurity(jsr250Enabled = true) // habilita @RolesAllowed
//@EnableMethodSecurity(securedEnabled = true) habilita @secured
//@EnableMethodSecurity(prePostEnabled = true) habilita @PreAuthorize

@RestController
public class UserController {

    @GetMapping("/home")
    public String home(){
        return "Hola, estás autenticado!";
    }

    @GetMapping("/admin")
    public String admin(){
        return "Pagina solo para adminstrador";
    }

    @GetMapping("/public")
    public String homePublic(){
        return "Vista para cualquier usuario sin loguiarse";
    }

    @RolesAllowed("USER")
    @GetMapping("/user")
    public String usuarioBasico(){
        return "Pagina protejida pero con la anotacion de @RolesAllowed";
    }
}
