package com.escola.interfaces.controllers;

import com.escola.application.dto.PontosAlunoDTO;
import com.escola.application.services.PontosAlunoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pontos")
@RequiredArgsConstructor
public class PontosAlunoController {
    private final PontosAlunoService pontosAlunoService;

    @PostMapping
    @PreAuthorize("hasRole('PROFESSOR')")
    public ResponseEntity<PontosAlunoDTO> registrarPontos(@Valid @RequestBody PontosAlunoDTO pontosAlunoDTO) {
        return ResponseEntity.ok(pontosAlunoService.registrarPontos(pontosAlunoDTO));
    }

    @GetMapping("/aluno/{alunoId}")
    @PreAuthorize("hasAnyRole('PROFESSOR', 'ALUNO')")
    public ResponseEntity<List<PontosAlunoDTO>> listarPontosPorAluno(@PathVariable Long alunoId) {
        return ResponseEntity.ok(pontosAlunoService.listarPontosPorAluno(alunoId));
    }

    @GetMapping("/professor/{professorId}")
    @PreAuthorize("hasRole('PROFESSOR')")
    public ResponseEntity<List<PontosAlunoDTO>> listarPontosPorProfessor(@PathVariable Long professorId) {
        return ResponseEntity.ok(pontosAlunoService.listarPontosPorProfessor(professorId));
    }
} 