package com.example.demo.Controller;

import com.example.demo.Dto.MatriculaDTO;
import com.example.demo.Service.MatriculaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {

    private final MatriculaService service;

    public MatriculaController(MatriculaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody MatriculaDTO dto) {
        service.saveMatricula(dto);
        return ResponseEntity.ok("Matrícula creada exitosamente");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody MatriculaDTO dto) {
        service.updateMatricula(id, dto);
        return ResponseEntity.ok("Matrícula actualizada exitosamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.deleteMatricula(id);
        return ResponseEntity.ok("Matrícula eliminada exitosamente");
    }

    @GetMapping
    public List<MatriculaDTO> getAll() {
        return service.getAllMatriculas();
    }

    @GetMapping("/{id}")
    public MatriculaDTO getById(@PathVariable Long id) {
        return service.getMatriculaById(id);
    }
}

