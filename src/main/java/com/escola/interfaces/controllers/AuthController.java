package com.escola.interfaces.controllers;

import com.escola.application.dto.AuthenticationRequest;
import com.escola.application.dto.AuthenticationResponse;
import com.escola.security.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import com.escola.application.exceptions.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import java.util.List;
import java.util.stream.Collectors;
import com.escola.domain.entities.Professor;
import com.escola.domain.entities.Aluno;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );
            UserDetails user = userDetailsService.loadUserByUsername(request.getEmail());
            String jwtToken = jwtService.generateToken(user);

            List<String> roles = user.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());

            String nome = "";
            if (user instanceof Professor) {
                nome = ((Professor) user).getNome();
            } else if (user instanceof Aluno) {
                nome = ((Aluno) user).getNome();
            }

            return ResponseEntity.ok(AuthenticationResponse.builder()
                    .token(jwtToken)
                    .email(user.getUsername())
                    .roles(roles)
                    .nome(nome)
                    .build());
        } catch (BadCredentialsException e) {
            throw new AuthenticationException("Credenciais inválidas");
        } catch (Exception e) {
            throw new AuthenticationException("Ocorreu um erro inesperado");
        }
    }
} 