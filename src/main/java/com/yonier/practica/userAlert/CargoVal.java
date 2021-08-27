package com.yonier.practica.userAlert;

import javax.validation.constraints.NotBlank;

public class CargoVal {
    @NotBlank
    private String nombre;

    public CargoVal() {
    }

    public CargoVal(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
