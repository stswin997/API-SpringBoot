package com.example.demo.Mapper;


import com.example.demo.Dto.DocenteDTO;
import com.example.demo.Model.Docente;
import org.springframework.stereotype.Component;

@Component
public class DocenteMapper {

    public DocenteDTO toDTO(Docente docente) {
        DocenteDTO dto = new DocenteDTO();
        dto.setIdDocente(docente.getIdDocente());
        dto.setNombre(docente.getNombre());
        dto.setApellido(docente.getApellido());
        dto.setEspecialidad(docente.getEspecialidad());
        dto.setCorreoElectronico(docente.getCorreoElectronico());
        return dto;
    }

    public Docente toEntity(DocenteDTO dto) {
        Docente docente = new Docente();
        docente.setIdDocente(dto.getIdDocente());
        docente.setNombre(dto.getNombre());
        docente.setApellido(dto.getApellido());
        docente.setEspecialidad(dto.getEspecialidad());
        docente.setCorreoElectronico(dto.getCorreoElectronico());
        return docente;
    }
}
