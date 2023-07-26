package com.example.primerApi.controller;


import com.example.primerApi.model.Vacantes;
import com.example.primerApi.service.VacantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vacantes")
public class VacantesController {

    private VacantesService vacantesService = null;

    @Autowired
    public VacantesController(VacantesService vacanteservice) {
        this.vacantesService = vacanteservice;
    }

    @GetMapping("/{id}")
    public Optional<Vacantes> findVacanteById(@PathVariable("id") Long id){
        return vacantesService.findVacanteById(id);

    }

    @GetMapping("/{Nombre}")
    public Optional<Vacantes> findVacanteById(@PathVariable("nombre") String nombre){
        return vacantesService.findVacanteByNombre(nombre);

    }


    @GetMapping("/all")
    public List<Vacantes> findAllVacantes(){
        return vacantesService.findAllVacante();

    }

    @PostMapping("/add")
    public Vacantes addVacante(@RequestBody Vacantes vacantes) {
        return vacantesService.addVacante(vacantes);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteVacante(@PathVariable("id") Long id){
        vacantesService.deleteVacante(id);

    }

}