package com.example.primerApi.repository;

import com.example.primerApi.model.Usuario;
import com.example.primerApi.model.Vacante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository <Usuario, Long> {
}
