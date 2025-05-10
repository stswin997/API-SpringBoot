package com.example.demo.Controller;

import com.example.demo.Dto.AlumnoDTO;
import com.example.demo.Service.AlumnoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
@CrossOrigin(origins = "*")
@Tag(name = "Alumnos", description = "Operaciones relacionadas con los alumnos")
public class AlumnoController {

    private final AlumnoService service;

    public AlumnoController(AlumnoService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Obtener todos los alumnos")
    public List<AlumnoDTO> getAllAlumnos() {
        return service.getAllAlumnos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un alumno por ID")
    public AlumnoDTO getAlumnoById(@PathVariable Integer id) {
        return service.getAlumnoById(id);
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo alumno")
    public ResponseEntity<String> createAlumno(@RequestBody AlumnoDTO alumnoDTO) {
        service.saveAlumno(alumnoDTO);
        return ResponseEntity.ok("Alumno agregado con éxito");
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un alumno existente")
    public ResponseEntity<String> updateAlumno(@PathVariable Integer id, @RequestBody AlumnoDTO alumnoDTO) {
        service.updateAlumno(id, alumnoDTO);
        return ResponseEntity.ok("Alumno actualizado con éxito");
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un alumno por ID")
    public ResponseEntity<String> deleteAlumno(@PathVariable Integer id) {
        service.deleteAlumno(id);
        return ResponseEntity.ok("Alumno eliminado con éxito");
    }
}

