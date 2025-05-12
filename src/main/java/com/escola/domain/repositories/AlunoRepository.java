package com.escola.domain.repositories;

import com.escola.domain.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Optional<Aluno> findByUsername(String username);
    Optional<Aluno> findByEmail(String email);
} 