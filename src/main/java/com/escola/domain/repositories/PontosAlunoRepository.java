package com.escola.domain.repositories;

import com.escola.domain.entities.PontosAluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PontosAlunoRepository extends JpaRepository<PontosAluno, Long> {
    List<PontosAluno> findByAlunoId(Long alunoId);
    List<PontosAluno> findByProfessorId(Long professorId);
} 