package com.example.demo.Service.impl;

import com.example.demo.Dto.UsuarioDTO;
import com.example.demo.Mapper.UsuarioMapper;
import com.example.demo.Model.Usuario;
import com.example.demo.Repository.UsuarioRepository;
import com.example.demo.Service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;

    public UsuarioServiceImpl(UsuarioRepository repository, UsuarioMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public UsuarioDTO saveUsuario(UsuarioDTO dto) {
        Usuario usuario = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(usuario));
    }

    @Override
    public UsuarioDTO updateUsuario(Long id, UsuarioDTO dto) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuario.setUsername(dto.getUsername());
        usuario.setPassword(dto.getPassword());
        usuario.setRol(dto.getRol());
        return mapper.toDTO(repository.save(usuario));
    }

    @Override
    public void deleteUsuario(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<UsuarioDTO> getAllUsuarios() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioDTO getUsuarioById(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
}

