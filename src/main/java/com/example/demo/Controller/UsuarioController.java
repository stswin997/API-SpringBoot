package com.example.demo.Controller;

import com.example.demo.Dto.UsuarioDTO;
import com.example.demo.Service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody UsuarioDTO dto) {
        service.saveUsuario(dto);
        return ResponseEntity.ok("Usuario creado exitosamente");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody UsuarioDTO dto) {
        service.updateUsuario(id, dto);
        return ResponseEntity.ok("Usuario actualizado exitosamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.deleteUsuario(id);
        return ResponseEntity.ok("Usuario eliminado exitosamente");
    }

    @GetMapping
    public List<UsuarioDTO> getAll() {
        return service.getAllUsuarios();
    }

    @GetMapping("/{id}")
    public UsuarioDTO getById(@PathVariable Long id) {
        return service.getUsuarioById(id);
    }
}

