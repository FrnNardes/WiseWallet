package com.wisewallet.controllers;

import com.wisewallet.modules.Account;
import com.wisewallet.modules.AccountRepository;
import com.wisewallet.vision.MainApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.util.List;

public class RegisterController extends BaseController{

    @FXML
    private TextField nameField;

    @FXML
    private TextField lastnameField;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private Button cancelButton;

    @FXML
    private Button registerButton;

    @FXML
    private Label registerErrorLabel;

    public void registerButtonAction() {
        if(nameField.getText().isEmpty() || lastnameField.getText().isEmpty() || usernameField.getText().isEmpty() || passwordField.getText().isEmpty() || confirmPasswordField.getText().isEmpty()) {
            registerErrorLabel.setVisible(true);
        } else {
            registerErrorLabel.setVisible(false);
            List<Account> contas = AccountRepository.carregarContas();

            // Criar um novo usuário
            Account novaConta = new Account(nameField.getText(), lastnameField.getText(), usernameField.getText(), passwordField.getText());
            contas.add(novaConta);
            AccountRepository.salvarContas(contas);
            cancelButtonAction();
        }
    }

    public void cancelButtonAction(){
        try {
            mainApp.showLoginPage();  // Chama o metodo da MainApplication para abrir a página de login
        } catch (Exception e) {
            e.printStackTrace();  // Lida com exceções, caso ocorram
        }
    }
}
