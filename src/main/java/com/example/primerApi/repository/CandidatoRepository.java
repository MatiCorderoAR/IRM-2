package com.example.primerApi.repository;

import com.example.primerApi.model.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatoRepository extends JpaRepository <Candidato, Long> {
}
