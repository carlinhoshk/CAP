package com.escola.application.services;

import com.escola.application.dto.PontosAlunoDTO;
import com.escola.application.mappers.PontosAlunoMapper;
import com.escola.domain.entities.PontosAluno;
import com.escola.domain.repositories.PontosAlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PontosAlunoService {
    private final PontosAlunoRepository pontosAlunoRepository;
    private final PontosAlunoMapper pontosAlunoMapper;

    public PontosAlunoDTO registrarPontos(PontosAlunoDTO pontosAlunoDTO) {
        PontosAluno pontos = pontosAlunoMapper.toEntity(pontosAlunoDTO);
        PontosAluno pontosSalvos = pontosAlunoRepository.save(pontos);
        return pontosAlunoMapper.toDTO(pontosSalvos);
    }

    public List<PontosAlunoDTO> listarPontosPorAluno(Long alunoId) {
        return pontosAlunoRepository.findByAlunoId(alunoId)
                .stream()
                .map(pontosAlunoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<PontosAlunoDTO> listarPontosPorProfessor(Long professorId) {
        return pontosAlunoRepository.findByProfessorId(professorId)
                .stream()
                .map(pontosAlunoMapper::toDTO)
                .collect(Collectors.toList());
    }
} 