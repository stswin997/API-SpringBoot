package com.example.demo.Service;

import com.example.demo.Dto.CursoDTO;
import java.util.List;

public interface CursoService {
    CursoDTO saveCurso(CursoDTO CursoDTO);
    CursoDTO updateCurso(Long id, CursoDTO CursoDTO);
    void deleteCurso(Long id);
    List<CursoDTO> getAllCursos();
    CursoDTO getCursoById(Long id);
}
