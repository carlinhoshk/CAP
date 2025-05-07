package com.escola.application.mappers;

import com.escola.application.dto.PontosAlunoDTO;
import com.escola.domain.entities.PontosAluno;
import com.escola.domain.repositories.AlunoRepository;
import com.escola.domain.repositories.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class PontosAlunoMapper {
    private final AlunoRepository alunoRepository;
    private final ProfessorRepository professorRepository;
    
    public PontosAluno toEntity(PontosAlunoDTO dto) {
        PontosAluno pontos = new PontosAluno();
        pontos.setId(dto.getId());
        pontos.setAluno(alunoRepository.findById(dto.getAlunoId())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado")));
        pontos.setProfessor(professorRepository.findById(dto.getProfessorId())
                .orElseThrow(() -> new RuntimeException("Professor não encontrado")));
        pontos.setTipo(dto.getTipo());
        pontos.setPontos(dto.getPontos());
        pontos.setObservacao(dto.getObservacao());
        pontos.setDataRegistro(dto.getDataRegistro() != null ? 
                dto.getDataRegistro() : LocalDateTime.now());
        return pontos;
    }
    
    public PontosAlunoDTO toDTO(PontosAluno entity) {
        PontosAlunoDTO dto = new PontosAlunoDTO();
        dto.setId(entity.getId());
        dto.setAlunoId(entity.getAluno().getId());
        dto.setProfessorId(entity.getProfessor().getId());
        dto.setTipo(entity.getTipo());
        dto.setPontos(entity.getPontos());
        dto.setObservacao(entity.getObservacao());
        dto.setDataRegistro(entity.getDataRegistro());
        dto.setNomeAluno(entity.getAluno().getNome());
        dto.setNomeProfessor(entity.getProfessor().getNome());
        return dto;
    }
} 