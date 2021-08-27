package com.yonier.practica.repository;

import com.yonier.practica.modelo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<User, Integer> {
    Optional<User> findByNombre (String nombre);
    boolean existsByNombre (String nombre);

}
