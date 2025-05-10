package com.example.demo.Service.impl;

import com.example.demo.Dto.DocenteDTO;
import com.example.demo.Mapper.DocenteMapper;
import com.example.demo.Model.Docente;
import com.example.demo.Repository.DocenteRepository;
import com.example.demo.Service.DocenteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocenteServiceImpl implements DocenteService {

    private final DocenteRepository repository;
    private final DocenteMapper mapper;

    public DocenteServiceImpl(DocenteRepository repository, DocenteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public DocenteDTO saveDocente(DocenteDTO docenteDTO) {
        Docente docente = mapper.toEntity(docenteDTO);
        return mapper.toDTO(repository.save(docente));
    }

    @Override
    public DocenteDTO updateDocente(Long id, DocenteDTO docenteDTO) {
        Docente docente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Docente no encontrado"));
        docente.setNombre(docenteDTO.getNombre());
        docente.setApellido(docenteDTO.getApellido());
        docente.setEspecialidad(docenteDTO.getEspecialidad());
        docente.setCorreoElectronico(docenteDTO.getCorreoElectronico());
        return mapper.toDTO(repository.save(docente));
    }

    @Override
    public void deleteDocente(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<DocenteDTO> getAllDocentes() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DocenteDTO getDocenteById(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Docente no encontrado"));
    }
}

