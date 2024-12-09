package com.wisewallet.modules;

import java.util.ArrayList;

public class Despesas {
    private String nomeDespesa;
    private double valor;
    private String descricao;

    private ArrayList<Despesas> despesas = new ArrayList<>();

    public Despesas(String nomeDespesa, double valor){
        this.nomeDespesa = nomeDespesa;
        this.valor = valor;
        despesas.add(this);
    }
    public Despesas(String nomeDespesa, double valor, String descricao){
        this.nomeDespesa = nomeDespesa;
        this.valor = valor;
        this.descricao = descricao;
        despesas.add(this);
    }
    public String getNomeDespesa(){
        return this.nomeDespesa;
    }
    public double getValor(){
        return this.valor;
    }
    public String getDescricao(){
        return this.descricao;
    }
    @Override
    public String toString() {
        return "Nome: " + nomeDespesa + ", Valor: " + valor + ", Descrição: " + descricao;
}

}
