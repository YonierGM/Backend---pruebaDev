package com.yonier.practica.service;

import com.yonier.practica.modelo.Cargos;
import com.yonier.practica.modelo.User;
import com.yonier.practica.repository.CargosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CargosService {

    @Autowired
    CargosRepository cargosRepository;

    public List<Cargos> list(){
        return cargosRepository.findAll();
    }

    public Optional<Cargos> getOne(int id){
        return cargosRepository.findById(id);
    }
    public Optional<Cargos> getByNombre (String nombre){
        return cargosRepository.findByNombre(nombre);
    }

    public void save(Cargos cargos){
        cargosRepository.save(cargos);
    }

    public void delete(int id){
        cargosRepository.deleteById(id);
    }

    public boolean existsById (int id){
        return cargosRepository.existsById(id);
    }

    public boolean existByNombre (String nombre){
        return cargosRepository.existsByNombre(nombre);
    }

}
