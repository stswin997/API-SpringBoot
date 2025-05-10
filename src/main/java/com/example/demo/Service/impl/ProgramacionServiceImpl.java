package com.example.demo.Service.impl;

import com.example.demo.Dto.ProgramacionDTO;
import com.example.demo.Mapper.ProgramacionMapper;
import com.example.demo.Model.Programacion;
import com.example.demo.Model.Curso;
import com.example.demo.Model.Docente;
import com.example.demo.Repository.ProgramacionRepository;
import com.example.demo.Repository.CursoRepository;
import com.example.demo.Repository.DocenteRepository;
import com.example.demo.Service.ProgramacionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProgramacionServiceImpl implements ProgramacionService {

    private final ProgramacionRepository repository;
    private final CursoRepository cursoRepository;
    private final DocenteRepository docenteRepository;
    private final ProgramacionMapper mapper;

    public ProgramacionServiceImpl(
            ProgramacionRepository repository,
            CursoRepository cursoRepository,
            DocenteRepository docenteRepository,
            ProgramacionMapper mapper
    ) {
        this.repository = repository;
        this.cursoRepository = cursoRepository;
        this.docenteRepository = docenteRepository;
        this.mapper = mapper;
    }

    @Override
    public ProgramacionDTO saveProgramacion(ProgramacionDTO dto) {
        Curso curso = cursoRepository.findById(dto.getIdCurso()).orElseThrow(() -> new RuntimeException("Curso no encontrado"));
        Docente docente = docenteRepository.findById(dto.getIdDocente()).orElseThrow(() -> new RuntimeException("Docente no encontrado"));
        Programacion programacion = mapper.toEntity(dto, curso, docente);
        return mapper.toDTO(repository.save(programacion));
    }

    @Override
    public ProgramacionDTO updateProgramacion(Long id, ProgramacionDTO dto) {
        Programacion programacion = repository.findById(id).orElseThrow(() -> new RuntimeException("Programación no encontrada"));
        Curso curso = cursoRepository.findById(dto.getIdCurso()).orElseThrow(() -> new RuntimeException("Curso no encontrado"));
        Docente docente = docenteRepository.findById(dto.getIdDocente()).orElseThrow(() -> new RuntimeException("Docente no encontrado"));

        programacion.setCurso(curso);
        programacion.setDocente(docente);
        programacion.setFechaInicio(dto.getFechaInicio());
        programacion.setFechaFin(dto.getFechaFin());

        return mapper.toDTO(repository.save(programacion));
    }

    @Override
    public void deleteProgramacion(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<ProgramacionDTO> getAllProgramaciones() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProgramacionDTO getProgramacionById(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Programación no encontrada"));
    }
}

