package com.escola.application.mappers;

import com.escola.application.dto.ProfessorDTO;
import com.escola.domain.entities.Professor;
import org.springframework.stereotype.Component;

@Component
public class ProfessorMapper {
    
    public Professor toEntity(ProfessorDTO dto) {
        Professor professor = new Professor();
        professor.setId(dto.getId());
        professor.setNome(dto.getNome());
        professor.setDisciplina(dto.getDisciplina());
        professor.setEmail(dto.getEmail());
        return professor;
    }
    
    public ProfessorDTO toDTO(Professor entity) {
        ProfessorDTO dto = new ProfessorDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setDisciplina(entity.getDisciplina());
        dto.setEmail(entity.getEmail());
        return dto;
    }
} 