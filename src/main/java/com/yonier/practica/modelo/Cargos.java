package com.yonier.practica.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "ocupacion")
public class Cargos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @NotBlank
    private String nombre;

    public Cargos() {
    }

    public Cargos(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
