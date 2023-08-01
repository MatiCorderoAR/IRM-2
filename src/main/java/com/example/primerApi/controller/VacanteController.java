package com.example.primerApi.controller;

import com.example.primerApi.model.Vacante;
import com.example.primerApi.service.VacanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vacantes")
public class VacanteController {

    private final VacanteService vacanteService;

    @Autowired
    public VacanteController(VacanteService vacanteService) {
        this.vacanteService = vacanteService;
    }

    @GetMapping("/{id}")
    public Optional<Vacante> findVacanteById(@PathVariable("id")Long id){
        return vacanteService.findVacanteById(id);
    }
    @GetMapping("/all")
    public List<Vacante> findAllVacantes() {
        return vacanteService.findAllVacantes();
    }

    @PostMapping("/addVacante")
    public Vacante addVacante(@RequestBody Vacante vacante){
        return vacanteService.addVacante(vacante);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteVacante(@PathVariable("id")Long id){
        vacanteService.deleteVacante(id);
    }

    @PutMapping("/update/{id}")
    public Optional<Vacante> updateVacante(@PathVariable("id")Long id, @RequestBody Vacante vacante) {
            return vacanteService.updateVacante(vacante, id);
    }
}
