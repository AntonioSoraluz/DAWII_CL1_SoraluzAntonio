package com.soraluz.model.request;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class AlumnoRequest {
    private Integer idalumno;
    private String apealumno;
    private String nomalumno;
    private Integer idesp;
    private String proce;
}
