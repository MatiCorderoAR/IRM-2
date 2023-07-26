package com.example.primerApi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String nombre;
    private String contraseña;
    private Date f_creacion;

    public Usuarios(String nombre, String contraseña, Date f_creacion) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.f_creacion = f_creacion;
    }
}
