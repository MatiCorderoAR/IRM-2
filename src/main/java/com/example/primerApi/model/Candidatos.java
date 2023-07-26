package com.example.primerApi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Candidatos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String nombre;
    private String apellido;
    private String cliente;
    private String perfil;
    private String seniority;
    private Integer rate;
    private String estado;
    private String contratado;
    private String reclutadora;

    public Candidatos(String nombre, String apellido, String cliente, String perfil, String seniority, Integer rate, String estado, String contratado, String reclutadora) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cliente = cliente;
        this.perfil = perfil;
        this.seniority = seniority;
        this.rate = rate;
        this.estado = estado;
        this.contratado = contratado;
        this.reclutadora = reclutadora;
    }
}

