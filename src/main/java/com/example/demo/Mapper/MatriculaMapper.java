package com.example.demo.Mapper;

import com.example.demo.Dto.MatriculaDTO;
import com.example.demo.Model.Matricula;
import org.springframework.stereotype.Component;

@Component
public class MatriculaMapper {

    public MatriculaDTO toDTO(Matricula entity) {
        MatriculaDTO dto = new MatriculaDTO();
        dto.setIdMatricula(entity.getIdMatricula());
        dto.setIdAlumno(entity.getIdAlumno());
        dto.setIdProgramacion(entity.getIdProgramacion());
        dto.setFechaMatricula(entity.getFechaMatricula());
        return dto;
    }

    public Matricula toEntity(MatriculaDTO dto) {
        Matricula entity = new Matricula();
        entity.setIdMatricula(dto.getIdMatricula());
        entity.setIdAlumno(dto.getIdAlumno());
        entity.setIdProgramacion(dto.getIdProgramacion());
        entity.setFechaMatricula(dto.getFechaMatricula());
        return entity;
    }
}

