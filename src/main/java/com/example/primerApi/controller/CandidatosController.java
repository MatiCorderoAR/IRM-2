package com.example.primerApi.controller;

import com.example.primerApi.model.Candidatos;
import com.example.primerApi.service.CandidatosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidatos")
public class CandidatosController {

    private CandidatosService candidatosService = null;

    @Autowired
    public CandidatosController(CandidatosService candidatoservice) {
        this.candidatosService = candidatoservice;
    }

    @GetMapping("/{id}")
    public Optional<Candidatos> findCandidatoById(@PathVariable("id") Long id){
        return candidatosService.findCandidatoById(id);

    }


    @GetMapping("/all")
    public List<Candidatos> findAllCandidatos(){
        return candidatosService.findAllCandidatos();

    }

    @PostMapping("/add")
    public Candidatos addCandidato(@RequestBody Candidatos candidatos) {
        return candidatosService.addCandidato(candidatos);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCandidato(@PathVariable("id") Long id){
        candidatosService.deleteCandidato(id);

    }

}