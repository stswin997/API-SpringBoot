package com.example.demo.Service;

import com.example.demo.Dto.ProgramacionDTO;
import java.util.List;

public interface ProgramacionService {
    ProgramacionDTO saveProgramacion(ProgramacionDTO dto);
    ProgramacionDTO updateProgramacion(Long id, ProgramacionDTO dto);
    void deleteProgramacion(Long id);
    List<ProgramacionDTO> getAllProgramaciones();
    ProgramacionDTO getProgramacionById(Long id);
}

