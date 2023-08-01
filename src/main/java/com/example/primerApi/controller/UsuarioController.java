package com.example.primerApi.controller;

import com.example.primerApi.model.Usuario;
import com.example.primerApi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/{id}")
    public Optional<Usuario> findUsuarioById(@PathVariable("id")Long id){
        return usuarioService.findUsuarioById(id);
    }
    @GetMapping("/all")
    public List<Usuario> findAllUsuarios() {
        return usuarioService.findAllUsuarios();
    }

    @PostMapping("/register")
    public Usuario addUsuario(@RequestBody Usuario usuario){
        return usuarioService.addUsuario(usuario);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUsuario(@PathVariable("id")Long id){
        usuarioService.deleteUsuario(id);
    }

    @PutMapping("/update/{id}")
    public Optional<Usuario> updateUsuario(@PathVariable("id")Long id, @RequestBody Usuario usuario) {
            return usuarioService.updateUsuario(usuario, id);
    }
}
