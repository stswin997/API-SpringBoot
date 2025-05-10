package com.example.demo.Controller;

import com.example.demo.Dto.CursoDTO;
import com.example.demo.Service.CursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private final CursoService service;

    public CursoController(CursoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> createCurso(@RequestBody CursoDTO cursoDTO) {
        service.saveCurso(cursoDTO);
        return ResponseEntity.ok("Curso agregado con éxito");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCurso(@PathVariable Long id, @RequestBody CursoDTO cursoDTO) {
        service.updateCurso(id, cursoDTO);
        return ResponseEntity.ok("Curso actualizado con éxito");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCurso(@PathVariable Long id) {
        service.deleteCurso(id);
        return ResponseEntity.ok("Curso eliminado con éxito");
    }

    @GetMapping
    public List<CursoDTO> getAllCursos() {
        return service.getAllCursos();
    }

    @GetMapping("/{id}")
    public CursoDTO getCursoById(@PathVariable Long id) {
        return service.getCursoById(id);
    }
}

