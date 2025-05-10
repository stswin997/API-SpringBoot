package com.example.demo.Controller;

import com.example.demo.Dto.DocenteDTO;
import com.example.demo.Service.DocenteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/docentes")
public class DocenteController {

    private final DocenteService docenteService;

    public DocenteController(DocenteService docenteService) {
        this.docenteService = docenteService;
    }

    @PostMapping
    public ResponseEntity<String> crearDocente(@RequestBody DocenteDTO docenteDTO) {
        docenteService.saveDocente(docenteDTO);
        return ResponseEntity.ok("Docente creado con éxito");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarDocente(@PathVariable Long id, @RequestBody DocenteDTO docenteDTO) {
        docenteService.updateDocente(id, docenteDTO);
        return ResponseEntity.ok("Docente actualizado con éxito");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarDocente(@PathVariable Long id) {
        docenteService.deleteDocente(id);
        return ResponseEntity.ok("Docente eliminado con éxito");
    }

    @GetMapping
    public List<DocenteDTO> obtenerTodosLosDocentes() {
        return docenteService.getAllDocentes();
    }

    @GetMapping("/{id}")
    public DocenteDTO obtenerDocentePorId(@PathVariable Long id) {
        return docenteService.getDocenteById(id);
    }
}

