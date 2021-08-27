package com.yonier.practica.userAlert;

import javax.validation.constraints.NotBlank;

public class UsuarioVal {
    @NotBlank
    private String nombre;
    private String apellido;
    private String email;
    private String documento;
    private String ocupacion;

    public UsuarioVal() {
    }

    public UsuarioVal(String nombre, String apellido, String email, String documento, String ocupacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.documento = documento;
        this.ocupacion = ocupacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }
}
