package com.wisewallet.controllers;

import com.sun.tools.javac.Main;
import com.wisewallet.vision.MainApplication;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LoginController extends BaseController{

    @FXML
    private Button cancelButton;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorMessage;

    @FXML
    private Hyperlink registerLink;

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

    public void cancelButtonAction(){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void registerLinkAction(){
        try {
            mainApp.showRegistrationPage();  // Chama o metodo da MainApplication para abrir a página de registro
        } catch (Exception e) {
            e.printStackTrace();  // Lida com exceções, caso ocorram
        }
    }
}
