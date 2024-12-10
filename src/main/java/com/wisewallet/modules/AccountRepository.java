package com.wisewallet.modules;

import com.wisewallet.modules.Account;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository {
    private static final String ARQUIVO_USUARIOS = "src/main/resources/database/usuarios.txt";

    public static List<Account> carregarContas() {
        List<Account> contas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_USUARIOS))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                contas.add(Account.fromString(linha));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contas;
    }

    public static Account buscarConta(String usuario, String senha) {
        List<Account> contas = carregarContas();

        // Percorre a lista de usuários e verifica se o nome de usuário e a senha batem
        for (Account c : contas) {
            if (c.getUsuario().equals(usuario) && c.getSenha().equals(senha)) {
                return c; // Retorna o usuário se encontrado
            }
        }
        return null; // Retorna null se não encontrar o usuário com a senha correta
    }

    public static void salvarContas(List<Account> contas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_USUARIOS))) {
            for (Account conta : contas) {
                writer.write(conta.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
