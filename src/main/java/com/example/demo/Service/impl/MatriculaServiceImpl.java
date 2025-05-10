package com.example.demo.Service.impl;

import com.example.demo.Dto.MatriculaDTO;
import com.example.demo.Mapper.MatriculaMapper;
import com.example.demo.Model.Matricula;
import com.example.demo.Repository.MatriculaRepository;
import com.example.demo.Service.MatriculaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatriculaServiceImpl implements MatriculaService {

    private final MatriculaRepository repository;
    private final MatriculaMapper mapper;

    public MatriculaServiceImpl(MatriculaRepository repository, MatriculaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public MatriculaDTO saveMatricula(MatriculaDTO dto) {
        Matricula matricula = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(matricula));
    }

    @Override
    public MatriculaDTO updateMatricula(Long id, MatriculaDTO dto) {
        Matricula matricula = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matrícula no encontrada"));
        matricula.setIdAlumno(dto.getIdAlumno());
        matricula.setIdProgramacion(dto.getIdProgramacion());
        matricula.setFechaMatricula(dto.getFechaMatricula());
        return mapper.toDTO(repository.save(matricula));
    }

    @Override
    public void deleteMatricula(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<MatriculaDTO> getAllMatriculas() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MatriculaDTO getMatriculaById(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Matrícula no encontrada"));
    }
}

