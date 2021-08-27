package com.yonier.practica.service;

import com.yonier.practica.modelo.User;
import com.yonier.practica.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<User> list(){
        return usuarioRepository.findAll();
    }

    public Optional<User> getOne(int id){
        return usuarioRepository.findById(id);
    }
    public Optional<User> getByNombre (String nombre){
        return usuarioRepository.findByNombre(nombre);
    }

    public void save(User usuario){
        usuarioRepository.save(usuario);
    }

    public void delete(int id){
        usuarioRepository.deleteById(id);
    }

    public boolean existsById (int id){
        return usuarioRepository.existsById(id);
    }

    public boolean existByNombre (String nombre){
        return usuarioRepository.existsByNombre(nombre);
    }
}
