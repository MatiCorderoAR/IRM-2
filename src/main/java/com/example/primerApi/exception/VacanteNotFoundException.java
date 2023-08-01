package com.example.primerApi.exception;

public class VacanteNotFoundException extends RuntimeException{

    public VacanteNotFoundException(Long id){
        super("could not find movie with id: " + id);
    }
}
