package com.example.demo.Mapper;

import com.example.demo.Dto.AlumnoDTO;
import com.example.demo.Model.Alumno;
import org.springframework.stereotype.Component;

@Component
public class AlumnoMapper {
    public AlumnoDTO toDTO(Alumno alumno) {
        AlumnoDTO dto = new AlumnoDTO();
        dto.setIdAlumno(alumno.getIdAlumno());
        dto.setDni(alumno.getDni());
        dto.setNombre(alumno.getNombre());
        dto.setApellido(alumno.getApellido());
        dto.setTelefono(alumno.getTelefono());
        dto.setCorreoElectronico(alumno.getCorreoElectronico());
        return dto;
    }

    public Alumno toEntity(AlumnoDTO dto) {
        Alumno alumno = new Alumno();
        alumno.setIdAlumno(dto.getIdAlumno());
        alumno.setDni(dto.getDni());
        alumno.setNombre(dto.getNombre());
        alumno.setApellido(dto.getApellido());
        alumno.setTelefono(dto.getTelefono());
        alumno.setCorreoElectronico(dto.getCorreoElectronico());
        return alumno;
    }
}