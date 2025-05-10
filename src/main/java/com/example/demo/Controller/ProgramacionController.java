package com.example.demo.Controller;

import com.example.demo.Dto.ProgramacionDTO;
import com.example.demo.Service.ProgramacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programaciones")
public class ProgramacionController {

    private final ProgramacionService service;

    public ProgramacionController(ProgramacionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody ProgramacionDTO dto) {
        service.saveProgramacion(dto);
        return ResponseEntity.ok("Programación creada con éxito");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody ProgramacionDTO dto) {
        service.updateProgramacion(id, dto);
        return ResponseEntity.ok("Programación actualizada con éxito");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.deleteProgramacion(id);
        return ResponseEntity.ok("Programación eliminada con éxito");
    }

    @GetMapping
    public List<ProgramacionDTO> getAll() {
        return service.getAllProgramaciones();
    }

    @GetMapping("/{id}")
    public ProgramacionDTO getById(@PathVariable Long id) {
        return service.getProgramacionById(id);
    }
}

