package com.example.demo.Mapper;


import com.example.demo.Dto.CursoDTO;
import com.example.demo.Model.Curso;
import org.springframework.stereotype.Component;



@Component
public class CursoMapper {

    public CursoDTO toDTO(Curso curso) {
        CursoDTO dto = new CursoDTO();
        dto.setIdCurso(curso.getIdCurso());
        dto.setNombreCurso(curso.getNombreCurso());
        dto.setPrecio(curso.getPrecio());
        return dto;
    }

    public Curso toEntity(CursoDTO dto) {
        Curso curso = new Curso();
        curso.setIdCurso(dto.getIdCurso());
        curso.setNombreCurso(dto.getNombreCurso());
        curso.setPrecio(dto.getPrecio());
        return curso;
    }
}

