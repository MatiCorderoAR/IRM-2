package com.example.primerApi.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Candidato {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String tittle;
    private String gender;
    private String director;
    private String banner;

    public Candidato(String tittle, String gender, String director, String banner) {
        this.tittle = tittle;
        this.gender = gender;
        this.director = director;
        this.banner = banner;
    }
}

