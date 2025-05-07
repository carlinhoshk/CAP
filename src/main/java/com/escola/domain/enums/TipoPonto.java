package com.escola.domain.enums;

public enum TipoPonto {
    PRESENCA(1),
    PARTICIPACAO(2),
    PERGUNTA(3);
    
    private final int valor;
    
    TipoPonto(int valor) {
        this.valor = valor;
    }
    
    public int getValor() {
        return valor;
    }
}

