package com.wisewallet.modules;

import com.wisewallet.modules.Account;

public class UserSession {
    private static UserSession instance;
    private Account currentUser;

    // Construtor privado para evitar instância direta
    private UserSession() {}

    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }

    public void setCurrentUser(Account user) {
        this.currentUser = user;
    }

    public Account getCurrentUser() {
        return currentUser;
    }

    public void clearSession() {
        currentUser = null;
    }
}