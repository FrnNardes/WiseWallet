package com.wisewallet.modules;

import java.util.ArrayList;

public class Account {
    private String user;
    private String password;
    private ArrayList<Despesas> despesas; 
    private ArrayList<Receitas> receitas;

    private static ArrayList<Account> accounts = new ArrayList<>();

    public Account(String user, String password) {
        this.user = user;
        this.password = password;
        this.despesas = new ArrayList<>();
        this.receitas = new ArrayList<>();
        accounts.add(this);
    }
    public Account(String user, String password, ArrayList<Despesas> despesas, ArrayList<Receitas> receitas) {
        this.user = user;
        this.password = password;
        this.despesas = despesas;
        this.receitas = receitas;
        accounts.add(this);
    }

    public String getUser() {
        return this.user;
    }

    public String getPassword() {
        return this.password;
    }

    public ArrayList<Despesas> getDespesas() {
        return this.despesas;
    }
    public ArrayList<Receitas> getReceitas() {
        return this.receitas;
    }

    public static ArrayList<Account> getAccounts() {
        return accounts;
    }


    public void addDespesa(Despesas despesa) {
        this.despesas.add(despesa);
    }

    public void removeDespesa(Despesas despesa) {
        this.despesas.remove(despesa);
    }


    public static void addAccount(Account account) {
        accounts.add(account);
    }


    public static Account findAccount(String user, String password) {
        for (Account acc : accounts) {
            if (acc.getUser().equals(user) && acc.getPassword().equals(password)) {
                return acc;
            }
        }
        return null;
    }
}
