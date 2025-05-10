package com.example.demo.Mapper;

import com.example.demo.Dto.UsuarioDTO;
import com.example.demo.Model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public UsuarioDTO toDTO(Usuario entity) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setIdUsuario(entity.getIdUsuario());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setRol(entity.getRol());
        return dto;
    }

    public Usuario toEntity(UsuarioDTO dto) {
        Usuario entity = new Usuario();
        entity.setIdUsuario(dto.getIdUsuario());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setRol(dto.getRol());
        return entity;
    }
}

