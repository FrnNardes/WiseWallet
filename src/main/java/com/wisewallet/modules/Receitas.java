package com.wisewallet.modules;

public class Receitas {
    private String nomeReceita;
    private double valor;
    private String descricao;

    public Receitas(String nomeReceita, double valor, String descricao) {
        this.nomeReceita = nomeReceita;
        this.valor = valor;
        this.descricao = descricao;
    }

    public String getNomeReceita() {
        return nomeReceita;
    }

    public double getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }
}
