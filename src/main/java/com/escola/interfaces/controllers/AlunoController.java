package com.escola.interfaces.controllers;

import com.escola.application.dto.AlunoDTO;
import com.escola.application.services.AlunoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
@RequiredArgsConstructor
public class AlunoController {
    private final AlunoService alunoService;


    @PostMapping
    public ResponseEntity<AlunoDTO> criar(@Valid @RequestBody AlunoDTO alunoDTO) {
        return ResponseEntity.ok(alunoService.criar(alunoDTO));
    }

    @GetMapping
    public ResponseEntity<List<AlunoDTO>> listarTodos() {
        return ResponseEntity.ok(alunoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(alunoService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoDTO> atualizar(@PathVariable Long id, @Valid @RequestBody AlunoDTO alunoDTO) {
        return ResponseEntity.ok(alunoService.atualizar(id, alunoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        alunoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
} 