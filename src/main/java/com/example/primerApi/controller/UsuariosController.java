package com.example.primerApi.controller;

import com.example.primerApi.model.Candidatos;
import com.example.primerApi.service.CandidatosService;
import com.example.primerApi.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    private UsuariosService usuarioService = null;

    @Autowired
    public UsuariosController(UsuariosService usuarioservice) {
        this.usuariosService = usuarioservice;
    }

    @GetMapping("/{id}")
    public Optional<Usuarios> findUsuarioById(@PathVariable("id") Long id){
        return usuarioService.findUsuarioById(id);

    }


    @GetMapping("/all")
    public List<Usuarios> findAllMovies(){
        return usuarioService.findAllMovies();

    }

    @PostMapping("/add")
    public Usuarios addUsuario(@RequestBody Usuarios usuario) {
        return usuariosService.addUsuario(usuarios);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUsuario(@PathVariable("id") Long id){
        usuariosService.deleteUsuario(id);

    }

}