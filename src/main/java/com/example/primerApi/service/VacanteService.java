package com.example.primerApi.service;

import com.example.primerApi.exception.CandidatoNotFoundException;
import com.example.primerApi.model.Vacante;
import com.example.primerApi.repository.VacanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VacanteService {

    private final VacanteRepository IRMRepository;

    @Autowired
    public VacanteService(VacanteRepository IRMRepository) {
        this.IRMRepository = IRMRepository;
    }

    /* ------------------------------ FIND ----------------------------- */
    public List<Vacante> findAllVacantes(){
        return IRMRepository.findAll();
    }
    public Optional<Vacante> findVacanteById(Long id) {
        return Optional.ofNullable(IRMRepository.findById(id)
                .orElseThrow(() -> new CandidatoNotFoundException(id)));
    }
    /* ------------------------------ CREATE ----------------------------- */
    public Vacante addVacante(Vacante vacante) {
        return IRMRepository.save(vacante);
    }
    /* ------------------------------ DELETE ----------------------------- */
    public void deleteVacante(Long id) {
        Optional<Vacante> deletedVacante = IRMRepository.findById(id);
        if(deletedVacante.isEmpty()){
            System.out.println("La pelicula con el id: "+ id + " no existe");
        } else {
            IRMRepository.deleteById(id);
            System.out.println("Pelicula borrada con exito!");
        }
    }
    /* ------------------------------ UPDATE ----------------------------- */
    public Optional<Vacante> updateVacante(Vacante newVacante, Long id) {
        Optional<Vacante> updatedVacante = IRMRepository.findById(id);
        if ((updatedVacante.isEmpty())) throw new CandidatoNotFoundException(id);
        else {
            return updatedVacante.map(vacante -> {
                vacante.setTittle(newVacante.getTittle());
                vacante.setDirector(newVacante.getDirector());
                vacante.setBanner(newVacante.getBanner());
                vacante.setGender(newVacante.getGender());
                return IRMRepository.save(vacante);
            });
        }
    }
}
