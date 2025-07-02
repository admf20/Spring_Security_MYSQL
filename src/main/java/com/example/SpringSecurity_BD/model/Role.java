package com.example.SpringSecurity_BD.model;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Una advertencia, cuando se guarda en la bd debe ser con el complemento
     * de "ROLE + el tipo de usuario" ya que security al hacer la validacion de userdetailservices
     * el lo busca asi, si no se pone en la bd entonces se concatena en el "getAuthorities"
     * **/
    private String name;

    public Role(){}

    public Role(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
