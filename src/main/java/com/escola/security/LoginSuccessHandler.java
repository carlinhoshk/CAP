package com.escola.security;

import com.escola.application.services.PresencaService;
import com.escola.domain.entities.Aluno;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoginSuccessHandler {
    private final PresencaService presencaService;

    @EventListener
    public void onAuthenticationSuccess(AuthenticationSuccessEvent event) {
        if (event.getAuthentication().getPrincipal() instanceof Aluno) {
            presencaService.registrarPresenca((Aluno) event.getAuthentication().getPrincipal());
        }
    }
} 