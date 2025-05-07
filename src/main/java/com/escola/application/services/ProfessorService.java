package com.escola.application.services;

import com.escola.application.dto.ProfessorDTO;
import com.escola.application.mappers.ProfessorMapper;
import com.escola.domain.entities.Professor;
import com.escola.domain.repositories.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfessorService {
    private final ProfessorRepository professorRepository;
    private final ProfessorMapper professorMapper;

    public ProfessorDTO criar(ProfessorDTO professorDTO) {
        Professor professor = professorMapper.toEntity(professorDTO);
        professor.setRegistro(generateRegistro()); // Gera o registro automaticamente
        Professor professorSalvo = professorRepository.save(professor);
        return professorMapper.toDTO(professorSalvo);
    }

    private String generateRegistro() {
        Long count = professorRepository.count(); // Conta o número de professores
        return "PROF" + String.format("%03d", count + 1); // Gera o registro no formato PROF001, PROF002, etc.
    }

    public List<ProfessorDTO> listarTodos() {
        return professorRepository.findAll()
                .stream()
                .map(professorMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ProfessorDTO buscarPorId(Long id) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));
        return professorMapper.toDTO(professor);
    }

    public ProfessorDTO atualizar(Long id, ProfessorDTO professorDTO) {
        if (!professorRepository.existsById(id)) {
            throw new RuntimeException("Professor não encontrado");
        }
        professorDTO.setId(id);
        Professor professor = professorMapper.toEntity(professorDTO);
        Professor professorAtualizado = professorRepository.save(professor);
        return professorMapper.toDTO(professorAtualizado);
    }

    public void deletar(Long id) {
        if (!professorRepository.existsById(id)) {
            throw new RuntimeException("Professor não encontrado");
        }
        professorRepository.deleteById(id);
    }
} 