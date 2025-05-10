package com.example.demo.Service.impl;

import com.example.demo.Dto.CursoDTO;
import com.example.demo.Mapper.CursoMapper;
import com.example.demo.Model.Curso;
import com.example.demo.Repository.CursoRepository;
import com.example.demo.Service.CursoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoServiceImpl implements CursoService {

    private final CursoRepository repository;
    private final CursoMapper mapper;

    public CursoServiceImpl(CursoRepository repository, CursoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public CursoDTO saveCurso(CursoDTO cursoDTO) {
        Curso curso = mapper.toEntity(cursoDTO);
        return mapper.toDTO(repository.save(curso));
    }

    @Override
    public CursoDTO updateCurso(Long idCurso, CursoDTO cursoDTO) {
        Curso curso = repository.findById(idCurso)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
        curso.setNombreCurso(cursoDTO.getNombreCurso());
        curso.setPrecio(cursoDTO.getPrecio());
        return mapper.toDTO(repository.save(curso));
    }

    @Override
    public void deleteCurso(Long idCurso) {
        repository.deleteById(idCurso);
    }

    @Override
    public List<CursoDTO> getAllCursos() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CursoDTO getCursoById(Long idCurso) {
        return repository.findById(idCurso)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
    }
}


