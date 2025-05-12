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
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Tenta encontrar um professor
        var professor = professorRepository.findByEmail(email);
        if (professor.isPresent()) {
            return professor.get();
        }
        
        // Se não encontrou professor, tenta encontrar um aluno
        return alunoRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado: " + email));
    }
} 