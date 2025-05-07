package com.escola.application.mappers;

import com.escola.application.dto.AlunoDTO;
import com.escola.domain.entities.Aluno;
import org.springframework.stereotype.Component;

@Component
public class AlunoMapper {
    
    public Aluno toEntity(AlunoDTO dto) {
        Aluno aluno = new Aluno();
        aluno.setId(dto.getId());
        aluno.setNome(dto.getNome());
        aluno.setEmail(dto.getEmail());
        aluno.setIdade(dto.getIdade());
        return aluno;
    }
    
    public AlunoDTO toDTO(Aluno entity) {
        AlunoDTO dto = new AlunoDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setEmail(entity.getEmail());
        dto.setIdade(entity.getIdade());
        return dto;
    }
} 