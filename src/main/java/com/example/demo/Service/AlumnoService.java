package com.example.demo.Service;


import com.example.demo.Dto.AlumnoDTO;

import java.util.List;

public interface AlumnoService {
    List<AlumnoDTO> getAllAlumnos();
    AlumnoDTO getAlumnoById(Integer id);
    AlumnoDTO saveAlumno(AlumnoDTO alumnoDTO);
    AlumnoDTO updateAlumno(Integer id, AlumnoDTO alumnoDTO);
    void deleteAlumno(Integer id);
}
