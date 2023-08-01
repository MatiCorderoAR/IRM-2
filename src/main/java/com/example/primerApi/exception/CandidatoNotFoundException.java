package com.example.primerApi.exception;

public class CandidatoNotFoundException extends RuntimeException{

    public CandidatoNotFoundException(Long id){
        super("could not find movie with id: " + id);
    }
}
