package com.soraluz.model.request;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class AlumnoRequest {
    private Integer IdAlumno;
    private String ApeAlumno;
    private String NomAlumno;
    private Integer IdEsp;
    private String Proce;
}
