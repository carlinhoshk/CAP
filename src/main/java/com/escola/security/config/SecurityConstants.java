package com.escola.security.config;

public class SecurityConstants {
    //public static final String AUTH_PATH = "/h2-console/**";
    public static final String AUTH_PATH = "/api/auth/**";
    public static final String PONTOS_PATH = "/api/pontos/**";
    public static final String ALUNOS_PATH = "/api/alunos/**";
    public static final String PROFESSORES_PATH = "/api/professores/**";
    
    public static final String ROLE_PROFESSOR = "PROFESSOR";
    public static final String ROLE_ALUNO = "ALUNO";
    
    private SecurityConstants() {


    }
} 