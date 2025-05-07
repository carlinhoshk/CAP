package com.escola.application.dto;

import com.escola.domain.enums.TipoPonto;
import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import java.time.LocalDateTime;

@Data
public class PontosAlunoDTO {
    private Long id;
    
    @NotNull(message = "ID do aluno é obrigatório")
    private Long alunoId;
    
    @NotNull(message = "ID do professor é obrigatório")
    private Long professorId;
    
    @NotNull(message = "Tipo de ponto é obrigatório")
    private TipoPonto tipo;
    
    @NotNull(message = "Quantidade de pontos é obrigatória")
    @Min(value = 1, message = "Quantidade de pontos deve ser maior que zero")
    private Integer pontos;
    
    private String observacao;
    private LocalDateTime dataRegistro;
    
    // Campos adicionais para exibição
    private String nomeAluno;
    private String nomeProfessor;
} 