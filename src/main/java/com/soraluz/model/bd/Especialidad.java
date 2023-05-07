package com.soraluz.model.bd;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name = "especialidad")
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdEsp;

    @Column(name = "NomEsp")
    private String NomEsp;

    @Column(name = "Costo")
    private Double Costo;

    @JsonManagedReference
    @OneToMany(mappedBy = "especialidad",
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Alumno> listaAlumno = new ArrayList<>();
}
