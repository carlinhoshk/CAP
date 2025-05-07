package com.escola.application.services;

import com.escola.application.dto.PontosAlunoDTO;
import com.escola.domain.entities.Aluno;
import com.escola.domain.enums.TipoPonto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PresencaService {
    private final PontosAlunoService pontosAlunoService;
    private static final Long SISTEMA_PROFESSOR_ID = 1L; // ID do professor do sistema

    public void registrarPresenca(Aluno aluno) {
        PontosAlunoDTO pontosDTO = new PontosAlunoDTO();
        pontosDTO.setAlunoId(aluno.getId());
        pontosDTO.setProfessorId(SISTEMA_PROFESSOR_ID);
        pontosDTO.setTipo(TipoPonto.PRESENCA);
        pontosDTO.setPontos(1);
        pontosDTO.setObservacao("Presença registrada via login");
        
        pontosAlunoService.registrarPontos(pontosDTO);
    }
} 