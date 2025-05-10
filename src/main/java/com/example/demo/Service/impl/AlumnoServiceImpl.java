package com.example.demo.Service.impl;


import com.example.demo.Dto.AlumnoDTO;
import com.example.demo.Mapper.AlumnoMapper;
import com.example.demo.Model.Alumno;
import com.example.demo.Repository.AlumnoRepository;
import com.example.demo.Service.AlumnoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository repository;
    private final AlumnoMapper mapper;

    public AlumnoServiceImpl(AlumnoRepository repository, AlumnoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<AlumnoDTO> getAllAlumnos() {
        return repository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public AlumnoDTO getAlumnoById(Integer id) {
        Alumno alumno = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));
        return mapper.toDTO(alumno);
    }

    @Override
    public AlumnoDTO saveAlumno(AlumnoDTO alumnoDTO) {
        Alumno alumno = mapper.toEntity(alumnoDTO);
        return mapper.toDTO(repository.save(alumno));
    }

    @Override
    public AlumnoDTO updateAlumno(Integer id, AlumnoDTO alumnoDTO) {
        Alumno alumno = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));
        alumno.setDni(alumnoDTO.getDni());
        alumno.setNombre(alumnoDTO.getNombre());
        alumno.setApellido(alumnoDTO.getApellido());
        alumno.setTelefono(alumnoDTO.getTelefono());
        alumno.setCorreoElectronico(alumnoDTO.getCorreoElectronico());
        return mapper.toDTO(repository.save(alumno));
    }

    @Override
    public void deleteAlumno(Integer id) {
        repository.deleteById(id);
    }
}

