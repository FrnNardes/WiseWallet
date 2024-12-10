package com.wisewallet.controllers;

import com.wisewallet.modules.Account;
import com.wisewallet.modules.AccountRepository;
import com.wisewallet.modules.UserSession;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LoginController extends BaseController {

    @FXML
    private Button cancelButton;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorMessage;

    @FXML
    private void loginButtonAction() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (verificarLogin(username, password)) {
            errorMessage.setVisible(false);

            // Armazena o nome do usuário na sessão
            Account acc = AccountRepository.buscarConta(username, password);
            UserSession.getInstance().setCurrentUser(acc);

            try {
                mainApp.showDashboardPage();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // Login falhou
            errorMessage.setVisible(true);
        }
    }

    public void cancelButtonAction() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void registerLinkAction() {
        try {
            mainApp.showRegistrationPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean verificarLogin(String username, String password) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("src/main/resources/database/usuarios.txt"));

            for (String line : lines) {
                Account account = Account.fromString(line);

                if (account != null && account.getUsuario().equals(username) && account.getSenha().equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
