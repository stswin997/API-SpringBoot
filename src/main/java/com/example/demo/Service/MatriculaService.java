package com.example.demo.Service;

import com.example.demo.Dto.MatriculaDTO;

import java.util.List;

public interface MatriculaService {
    MatriculaDTO saveMatricula(MatriculaDTO dto);
    MatriculaDTO updateMatricula(Long id, MatriculaDTO dto);
    void deleteMatricula(Long id);
    List<MatriculaDTO> getAllMatriculas();
    MatriculaDTO getMatriculaById(Long id);
}

