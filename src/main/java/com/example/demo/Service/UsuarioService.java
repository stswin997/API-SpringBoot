package com.example.demo.Service;

import com.example.demo.Dto.UsuarioDTO;

import java.util.List;

public interface UsuarioService {
    UsuarioDTO saveUsuario(UsuarioDTO dto);
    UsuarioDTO updateUsuario(Long id, UsuarioDTO dto);
    void deleteUsuario(Long id);
    List<UsuarioDTO> getAllUsuarios();
    UsuarioDTO getUsuarioById(Long id);
}

