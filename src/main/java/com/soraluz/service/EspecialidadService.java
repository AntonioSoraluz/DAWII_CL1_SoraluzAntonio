package com.soraluz.service;

import com.soraluz.model.bd.Especialidad;
import com.soraluz.repository.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadService {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    public List<Especialidad> listarEspecialidades() {return especialidadRepository.findAll();}

    public void registrarEspecialidad(Especialidad especialidad) {especialidadRepository.save(especialidad);}

    public void eliminarEspecialidad(Especialidad especialidad) {especialidadRepository.deleteById(especialidad.getIdesp());}

}
