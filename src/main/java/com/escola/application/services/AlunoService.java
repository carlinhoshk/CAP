package com.escola.application.services;

import com.escola.application.dto.AlunoDTO;
import com.escola.application.mappers.AlunoMapper;
import com.escola.domain.entities.Aluno;
import com.escola.domain.repositories.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlunoService {
    private final AlunoRepository alunoRepository;
    private final AlunoMapper alunoMapper;

    public AlunoDTO criar(AlunoDTO alunoDTO) {
        Aluno aluno = alunoMapper.toEntity(alunoDTO);
        aluno.setMatricula(generateMatricula());
        Aluno alunoSalvo = alunoRepository.save(aluno);
        return alunoMapper.toDTO(alunoSalvo);
    }

    private String generateMatricula() {
        Long count = alunoRepository.count();
        return "ALU" + String.format("%03d", count + 1);
    }

    public List<AlunoDTO> listarTodos() {
        return alunoRepository.findAll()
                .stream()
                .map(alunoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public AlunoDTO buscarPorId(Long id) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        return alunoMapper.toDTO(aluno);
    }

    public AlunoDTO atualizar(Long id, AlunoDTO alunoDTO) {
        if (!alunoRepository.existsById(id)) {
            throw new RuntimeException("Aluno não encontrado");
        }
        alunoDTO.setId(id);
        Aluno aluno = alunoMapper.toEntity(alunoDTO);
        Aluno alunoAtualizado = alunoRepository.save(aluno);
        return alunoMapper.toDTO(alunoAtualizado);
    }

    public void deletar(Long id) {
        if (!alunoRepository.existsById(id)) {
            throw new RuntimeException("Aluno não encontrado");
        }
        alunoRepository.deleteById(id);
    }
} 