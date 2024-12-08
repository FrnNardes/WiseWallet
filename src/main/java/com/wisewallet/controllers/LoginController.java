package com.wisewallet.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class LoginController {

    @FXML
    private Button cancelButton;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorMessage;

    @FXML
    private void loginButtonAction(){
        String username = usernameField.getText();
        String password = passwordField.getText();

        if(username.equals("admin") && password.equals("1234")){
            errorMessage.setVisible(false);
            System.out.println("Login bem-sucedido!");
        } else {
            // Login falhou
            errorMessage.setVisible(true);
        }
    }

    public void cancelButtonAction(ActionEvent event){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
