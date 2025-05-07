package com.escola.security.service;

import com.escola.domain.repositories.AlunoRepository;
import com.escola.domain.repositories.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    
    private final ProfessorRepository professorRepository;
    private final AlunoRepository alunoRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Tenta encontrar um professor
        var professor = professorRepository.findByUsername(username);
        if (professor.isPresent()) {
            return professor.get();
        }
        
        // Se não encontrou professor, tenta encontrar um aluno
        return alunoRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));
    }
} 