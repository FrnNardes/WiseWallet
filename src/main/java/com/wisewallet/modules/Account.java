package com.wisewallet.modules;
import java.time.LocalDate;
import java.io.*;
import java.util.*;

public class Account {
    private static final String ARQUIVO_TRANSACOES = "src/main/resources/database/transacoes.txt";
    String nome;
    String sobrenome;
    String usuario;
    String senha;
    List<Double> entradas;
    List<Double> saidas;

    public Account(String nome, String sobrenome, String usuario, String senha) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.usuario = usuario;
        this.senha = senha;
        this.entradas = new ArrayList<>();
        this.saidas = new ArrayList<>();
        carregarTransacoes();
    }

    private void carregarTransacoes() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_TRANSACOES))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split("\\|");
                if (partes[0].equals(this.usuario)) {
                    // Carrega entradas
                    String[] entradasArray = partes[1].split(":")[1].split(",");
                    for (String e : entradasArray) {
                        this.entradas.add(Double.parseDouble(e));
                    }
                    // Carrega saídas
                    String[] saidasArray = partes[2].split(":")[1].split(",");
                    for (String s : saidasArray) {
                        this.saidas.add(Double.parseDouble(s));
                    }
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void adicionarEntrada(double valor) {
        entradas.add(valor);
        salvarTransacoes();
    }

    public void removerEntrada(double valor) {
        entradas.remove(valor);
        salvarTransacoes();
    }

    public void adicionarSaida(double valor) {
        saidas.add(valor);
        salvarTransacoes();
    }

    public void removerSaida(double valor) {
        saidas.remove(valor);
        salvarTransacoes();
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    private void salvarTransacoes() {
        List<String> linhas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_TRANSACOES))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                // Atualiza a linha do usuário se encontrado
                if (linha.startsWith(usuario + "|")) {
                    linhas.add(this.usuario + "|Entradas:" + entradasToString() + "|Saidas:" + saidasToString());
                } else {
                    linhas.add(linha);
                }
            }

            // Caso o usuário não tenha transações, adiciona uma nova linha
            if (linhas.stream().noneMatch(l -> l.startsWith(usuario + "|"))) {
                linhas.add(this.usuario + "|Entradas:" + entradasToString() + "|Saidas:" + saidasToString());
            }

            // Salva as mudanças de volta ao arquivo
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_TRANSACOES))) {
                for (String linhaAtualizada : linhas) {
                    writer.write(linhaAtualizada);
                    writer.newLine();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private String entradasToString() {
        return String.join(",", entradas.stream().map(String::valueOf).toArray(String[]::new));
    }

    private String saidasToString() {
        return String.join(",", saidas.stream().map(String::valueOf).toArray(String[]::new));
    }

    @Override
    public String toString() {
        return nome + ":" + sobrenome + ":" + usuario + ":" + senha;
    }

    public static Account fromString(String line) {
        String[] parts = line.split(":");
        if (parts.length == 4) {
            String firstName = parts[0].trim();
            String lastName = parts[1].trim();
            String username = parts[2].trim();
            String password = parts[3].trim();
            return new Account(firstName, lastName, username, password);
        }
        return null;  // Retorna null se a linha não tiver o formato esperado
    }
}