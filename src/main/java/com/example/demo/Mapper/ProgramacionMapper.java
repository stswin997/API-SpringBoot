package com.example.demo.Mapper;

import com.example.demo.Dto.ProgramacionDTO;
import com.example.demo.Model.Programacion;
import com.example.demo.Model.Curso;
import com.example.demo.Model.Docente;
import org.springframework.stereotype.Component;

@Component
public class ProgramacionMapper {

    public ProgramacionDTO toDTO(Programacion programacion) {
        ProgramacionDTO dto = new ProgramacionDTO();
        dto.setIdProgramacion(programacion.getIdProgramacion());
        dto.setIdCurso(programacion.getCurso().getIdCurso());
        dto.setIdDocente(programacion.getDocente().getIdDocente());
        dto.setFechaInicio(programacion.getFechaInicio());
        dto.setFechaFin(programacion.getFechaFin());
        return dto;
    }

    public Programacion toEntity(ProgramacionDTO dto, Curso curso, Docente docente) {
        Programacion programacion = new Programacion();
        programacion.setIdProgramacion(dto.getIdProgramacion());
        programacion.setCurso(curso);
        programacion.setDocente(docente);
        programacion.setFechaInicio(dto.getFechaInicio());
        programacion.setFechaFin(dto.getFechaFin());
        return programacion;
    }
}

