package com.soraluz.model.bd;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "alumno")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdAlumno;

    @Column(name = "ApeAlumno")
    private String ApeAlumno;

    @Column(name = "NomAlumno")
    private String NomAlumno;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "IdEsp")
    private Especialidad especialidad;

    @Column(name = "Proce")
    private String Proce;
}

