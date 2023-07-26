package com.example.primerApi.service;

import com.example.primerApi.model.Candidatos;
import com.example.primerApi.repository.IRMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VacantesService {

    private final IRMRepository IRMRepository;

    @Autowired
    public VacantesService(IRMRepository IRMRepository) {this.IRMRepository = IRMRepository;
    }
    /* ----------------------------- FIND ----------------------------- */
    public List<Candidatos> findAllMovies(){return IRMRepository.findAll();

    }
    public Optional<Candidatos> findMovieById(Long id) {
        return IRMRepository.findById(id);
    }



    /* ----------------------------- CREATE ----------------------------- */


    public Candidatos addMovie(Candidatos candidatos) {
        return IRMRepository.save(candidatos);
    }


    /* ----------------------------- MODIFY ----------------------------- */


    /* ----------------------------- DELETE ----------------------------- */
    public void deleteMovie(Long id) {
        Optional<Candidatos> deletedMovie = IRMRepository.findById(id);
        if(deletedMovie.isEmpty()){
            System.out.println("La pelicula con el Id: " + id + "No existe" );

        }else {
            IRMRepository.deleteById(id);
        }
    }





}
