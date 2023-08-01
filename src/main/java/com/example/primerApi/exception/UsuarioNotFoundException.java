package com.example.primerApi.exception;

public class UsuarioNotFoundException extends RuntimeException{

    public UsuarioNotFoundException(Long id){
        super("could not find movie with id: " + id);
    }
}
