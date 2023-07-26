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
public class Vacantes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String empresa;
    private String vacante;
    private String seniority;
    private Integer c_vacantes;
    private Integer rate;
    private String estado;
    private Date f_comienzo;
    private Date f_cierre;

    public Vacantes(String empresa, String vacante, String seniority, Integer c_vacantes, Integer rate, String estado, Date f_comienzo, Date f_cierre) {
        this.empresa = empresa;
        this.vacante = vacante;
        this.seniority = seniority;
        this.c_vacantes = c_vacantes;
        this.rate = rate;
        this.estado = estado;
        this.f_comienzo = f_comienzo;
        this.f_cierre = f_cierre;
    }
}
