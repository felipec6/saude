package com.operadora.saude.utils;

public enum EspecialidadeEnum {
    CLINICA_GERAL("1");

    private String descricao;

    EspecialidadeEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
