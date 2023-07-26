package com.example.primerApi.repository;

import com.example.primerApi.model.Candidatos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRMRepository extends JpaRepository <Candidatos, Long>{
}


