package com.example.primerApi.repository;

import com.example.primerApi.model.Vacante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacanteRepository extends JpaRepository <Vacante, Long> {
}
