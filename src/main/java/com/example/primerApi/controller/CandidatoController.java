package com.example.primerApi.controller;

import com.example.primerApi.model.Candidato;
import com.example.primerApi.service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidatos")
public class CandidatoController {

    private final CandidatoService candidatoService;

    @Autowired
    public CandidatoController(CandidatoService candidatoService) {
        this.candidatoService = candidatoService;
    }

    @GetMapping("/{id}")
    public Optional<Candidato> findCandidatoById(@PathVariable("id")Long id){
        return candidatoService.findCandidatoById(id);
    }
    @GetMapping("/all")
    public List<Candidato> findAllCandidato() {
        return candidatoService.findAllCandidatos();
    }

    @PostMapping("/add")
    public Candidato addCandidato(@RequestBody Candidato candidato){
        return candidatoService.addCandidato(candidato);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCandidato(@PathVariable("id")Long id){
        candidatoService.deleteCandidato(id);
    }

    @PutMapping("/update/{id}")
    public Optional<Candidato> updateCandidato(@PathVariable("id")Long id, @RequestBody Candidato candidato) {
            return candidatoService.updateCandidato(candidato, id);
    }
}
