package com.escola.domain.entities;

import com.escola.domain.enums.TipoPonto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PontosAluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;
    
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;
    
    @Enumerated(EnumType.STRING)
    private TipoPonto tipo;
    
    private Integer pontos;
    
    private LocalDateTime dataRegistro;
    
    private String observacao;
} 