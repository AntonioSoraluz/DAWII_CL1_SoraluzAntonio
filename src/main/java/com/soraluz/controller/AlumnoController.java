package com.soraluz.controller;

import com.soraluz.model.bd.Alumno;
import com.soraluz.model.bd.Especialidad;
import com.soraluz.model.request.AlumnoRequest;
import com.soraluz.model.response.ResultadoResponse;
import com.soraluz.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Alumno")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping("/frmMantAlumno")
    public String frmMantAlumno(Model model){
        model.addAttribute("listaAlumnos",
                alumnoService.listarAlumnos());
        return "Alumno/frmMantAlumno";
    }
    @PostMapping("/registrarAlumno")
    @ResponseBody
    public ResultadoResponse registrarAlumno(@RequestBody
                                             AlumnoRequest alumnoRequest){
        String mensaje = "Alumno registrado correctamente";
        Boolean respuesta = true;
        try{
            Alumno objAlumno = new Alumno();
            if(alumnoRequest.getIdAlumno() > 0){
                objAlumno.setIdAlumno(alumnoRequest.getIdAlumno());
            }
            objAlumno.setApeAlumno(alumnoRequest.getApeAlumno());
            objAlumno.setNomAlumno(alumnoRequest.getNomAlumno());
            objAlumno.setProce(alumnoRequest.getProce());
            Especialidad objEspecialidad = new Especialidad();
            objEspecialidad.setIdEsp(alumnoRequest.getIdEsp());
            objAlumno.setEspecialidad(objEspecialidad);
            alumnoService.registrarAlumno(objAlumno);
        }catch (Exception ex){
            mensaje = "Alumno no registrado";
            respuesta = false;
        }
        return ResultadoResponse.builder()
                .mensaje(mensaje)
                .respuesta(respuesta).build();
    }

    @DeleteMapping("/eliminarAlumno")
    @ResponseBody
    public ResultadoResponse eliminarAlumno(@RequestBody
                                          AlumnoRequest alumnoRequest){
        String mensaje = "Alumno eliminado correctamente";
        Boolean respuesta = true;
        try{
            alumnoService.eliminarAlumno(alumnoRequest.getIdAlumno());
        }catch (Exception ex){
            mensaje = "Alumno no eliminado";
            respuesta = false;
        }
        return ResultadoResponse.builder()
                .mensaje(mensaje).respuesta(respuesta).build();
    }

    @GetMapping("/listarAlumnos")
    @ResponseBody
    public List<Alumno> listarAlumnos(){
        return alumnoService.listarAlumnos();
    }
}
