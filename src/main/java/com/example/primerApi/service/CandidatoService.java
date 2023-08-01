package com.example.primerApi.service;

import com.example.primerApi.exception.CandidatoNotFoundException;
import com.example.primerApi.model.Candidato;
import com.example.primerApi.repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CandidatoService {

    private final CandidatoRepository candidatoRepository;

    @Autowired
    public CandidatoService(CandidatoRepository CandidatoRepository) {
        this.candidatoRepository = CandidatoRepository;
    }

    /* ------------------------------ FIND ----------------------------- */
    public Optional<Candidato> findCandidatoById(Long id) {
        return Optional.ofNullable(candidatoRepository.findById(id)
                .orElseThrow(() -> new CandidatoNotFoundException(id)));
    }
    public List<Candidato> findAllCandidatos(){
        return candidatoRepository.findAll();
    }
    /* ------------------------------ CREATE ----------------------------- */
    public Candidato addCandidato(Candidato candidato) {
        return candidatoRepository.save(candidato);
    }

    /* ------------------------------ DELETE ----------------------------- */
    public void deleteCandidato(Long id) {
        Optional<Candidato> deletedCandidato = candidatoRepository.findById(id);
        if(deletedCandidato.isEmpty()){
            System.out.println("La pelicula con el id: "+ id + " no existe");
        } else {
            candidatoRepository.deleteById(id);
            System.out.println("Pelicula borrada con exito!");
        }
    }
    /* ------------------------------ UPDATE ----------------------------- */
    public Optional<Candidato> updateCandidato(Candidato newCandidato, Long id) {
        Optional<Candidato> updatedCandidato = candidatoRepository.findById(id);
        if ((updatedCandidato.isEmpty())) throw new CandidatoNotFoundException(id);
        else {
            return updatedCandidato.map(candidato -> {
                candidato.setTittle(newCandidato.getTittle());
                candidato.setDirector(newCandidato.getDirector());
                candidato.setBanner(newCandidato.getBanner());
                candidato.setGender(newCandidato.getGender());
                return candidatoRepository.save(candidato);
            });
        }
    }
}
