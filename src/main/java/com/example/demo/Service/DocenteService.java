package com.example.demo.Service;

import com.example.demo.Dto.DocenteDTO;

import java.util.List;

public interface DocenteService {

    DocenteDTO saveDocente(DocenteDTO docenteDTO);
    DocenteDTO updateDocente(Long id, DocenteDTO docenteDTO);
    void deleteDocente(Long id);
    List<DocenteDTO> getAllDocentes();
    DocenteDTO getDocenteById(Long id);
}

