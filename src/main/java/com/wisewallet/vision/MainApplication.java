package com.wisewallet.vision;

import com.wisewallet.controllers.LoginController;
import com.wisewallet.controllers.RegisterController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;

        // Definir a tela inicial (Login)
        showLoginPage();
    }

    // Metodo para mostrar a tela de login
    public void showLoginPage() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/login.fxml"));
        Scene loginScene = new Scene(loader.load());
        // Obtém o controlador do login
        LoginController loginController = loader.getController();

        // Passa a referência de MainApplication para o controlador
        loginController.setMainApp(this);

        primaryStage.setTitle("Login - WISEWALLET");
        primaryStage.setResizable(false);
        primaryStage.setScene(loginScene);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    // Metodo para mostrar a tela de registro
    public void showRegistrationPage() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/register.fxml"));
        Scene registrationScene = new Scene(loader.load());
        // Obtém o controlador do login
        RegisterController registerController = loader.getController();

        // Passa a referência de MainApplication para o controlador
        registerController.setMainApp(this);
        primaryStage.setTitle("Registro - WISEWALLET");
        primaryStage.setResizable(false);
        primaryStage.setScene(registrationScene);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    // Metodo para mostrar a tela do dashboard
    public void showDashboardPage() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/dashboard.fxml"));
        Scene dashboardScene = new Scene(loader.load());
        primaryStage.setTitle("Dashboard - WISEWALLET");
        primaryStage.setResizable(false);
        primaryStage.setScene(dashboardScene);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
