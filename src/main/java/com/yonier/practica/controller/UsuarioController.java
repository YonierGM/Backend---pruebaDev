package com.yonier.practica.controller;

import com.yonier.practica.modelo.Cargos;
import com.yonier.practica.modelo.User;
import com.yonier.practica.service.CargosService;
import com.yonier.practica.service.UsuarioService;
import com.yonier.practica.userAlert.CargoVal;
import com.yonier.practica.userAlert.UsuarioVal;
import org.apache.commons.lang3.StringUtils;
import com.yonier.practica.userAlert.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users-data")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/lista")
    public ResponseEntity<List<User>> list(){
        List<User> list = usuarioService.list();
        return  new ResponseEntity(list, HttpStatus.OK);
    }

    @Autowired
    CargosService cargosService;

    @GetMapping("/lista-cargos")
    public ResponseEntity<List<Cargos>> listCargos(){
        List<Cargos> list = cargosService.list();
        return  new ResponseEntity(list, HttpStatus.OK);
    }

    @RequestMapping("/create-cargo")
    public ResponseEntity<?> createCargo(@RequestBody CargoVal cargoVal){
        if (StringUtils.isAllBlank(cargoVal.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);

        Cargos cargo = new Cargos(cargoVal.getNombre());
        cargosService.save(cargo);

        return new ResponseEntity(new Mensaje("Cargo creado"), HttpStatus.OK);
    }


    @GetMapping("/detailId/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") int id){
        if (!usuarioService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        User usuario = usuarioService.getOne(id).get();
        return new ResponseEntity(usuario, HttpStatus.OK);
    }

    @GetMapping("/detailNombre/{nombre}")
    public ResponseEntity<User> getByNombre(@PathVariable("nombre") String nombre){
        if (!usuarioService.existByNombre(nombre))
            return new ResponseEntity(new Mensaje("No existe ese nombre"), HttpStatus.NOT_FOUND);
        User user = usuarioService.getByNombre(nombre).get();
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @RequestMapping("/create")
    public ResponseEntity<?> create(@RequestBody UsuarioVal usuarioVal){
        if (StringUtils.isAllBlank(usuarioVal.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);

        if (StringUtils.isAllBlank(usuarioVal.getApellido()))
            return new ResponseEntity(new Mensaje("El apellido es obligatorio"), HttpStatus.BAD_REQUEST);

        if (StringUtils.isAllBlank(usuarioVal.getDocumento()))
            return new ResponseEntity(new Mensaje("El documento es obligatorio"), HttpStatus.BAD_REQUEST);

        if (StringUtils.isAllBlank(usuarioVal.getEmail()))
            return new ResponseEntity(new Mensaje("El email es obligatorio"), HttpStatus.BAD_REQUEST);

        if (StringUtils.isAllBlank(usuarioVal.getOcupacion()))
            return new ResponseEntity(new Mensaje("La ocupacion es obligatoria"), HttpStatus.BAD_REQUEST);


        User user = new User(usuarioVal.getNombre(),usuarioVal.getApellido(),usuarioVal.getEmail(),usuarioVal.getDocumento(),usuarioVal.getOcupacion());
        usuarioService.save(user);

        return new ResponseEntity(new Mensaje("Usuario creado"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody UsuarioVal usuarioVal){
        if (!usuarioService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);

        if (StringUtils.isAllBlank(usuarioVal.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);

        if (StringUtils.isAllBlank(usuarioVal.getApellido()))
            return new ResponseEntity(new Mensaje("El apellido es obligatorio"), HttpStatus.BAD_REQUEST);

        if (StringUtils.isAllBlank(usuarioVal.getDocumento()))
            return new ResponseEntity(new Mensaje("El documento es obligatorio"), HttpStatus.BAD_REQUEST);

        if (StringUtils.isAllBlank(usuarioVal.getEmail()))
            return new ResponseEntity(new Mensaje("El email es obligatorio"), HttpStatus.BAD_REQUEST);

        User usuario = usuarioService.getOne(id).get();
        usuario.setNombre(usuarioVal.getNombre());
        usuario.setNombre(usuarioVal.getApellido());
        usuario.setNombre(usuarioVal.getDocumento());
        usuario.setNombre(usuarioVal.getEmail());
        usuario.setOcupacion(usuarioVal.getOcupacion());

        usuarioService.save(usuario);

        return new ResponseEntity(new Mensaje("Usuario actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if (!usuarioService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        usuarioService.delete(id);
        return new ResponseEntity(new Mensaje("Usuario eliminado"), HttpStatus.OK);
    }
}
