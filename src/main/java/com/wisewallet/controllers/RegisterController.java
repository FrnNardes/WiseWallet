package com.wisewallet.controllers;

import com.wisewallet.vision.MainApplication;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

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

    public void cancelButtonAction(){
        try {
            mainApp.showLoginPage();  // Chama o metodo da MainApplication para abrir a página de login
        } catch (Exception e) {
            e.printStackTrace();  // Lida com exceções, caso ocorram
        }
    }
}
