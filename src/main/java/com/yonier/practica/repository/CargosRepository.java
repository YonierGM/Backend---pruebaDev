package com.yonier.practica.repository;

import com.yonier.practica.modelo.Cargos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CargosRepository extends JpaRepository<Cargos, Integer> {

    Optional<Cargos> findByNombre (String nombre);
    boolean existsByNombre (String nombre);

}
