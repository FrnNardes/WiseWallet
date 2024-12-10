package com.wisewallet.vision;

import com.wisewallet.controllers.*;
import com.wisewallet.modules.Account;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {

    private Stage primaryStage;
    private Stage secondaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.secondaryStage = new Stage();

        showLoginPage();
    }

    public void showLoginPage() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/login.fxml"));
        Scene loginScene = new Scene(loader.load());

        LoginController loginController = loader.getController();
        loginController.setMainApp(this);

        primaryStage.setTitle("Login - WISEWALLET");
        primaryStage.setResizable(false);
        primaryStage.setScene(loginScene);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    public void showRegistrationPage() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/register.fxml"));
        Scene registrationScene = new Scene(loader.load());

        RegisterController registerController = loader.getController();
        registerController.setMainApp(this);

        primaryStage.setTitle("Registro - WISEWALLET");
        primaryStage.setResizable(false);
        primaryStage.setScene(registrationScene);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    // Metodo para mostrar a tela do dashboard
    public FXMLLoader showDashboardPage() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/dashboard.fxml"));
        Scene dashboardScene = new Scene(loader.load());

        DashboardController dashboardController = loader.getController();
        dashboardController.setMainApp(this);

        primaryStage.setTitle("Dashboard - WISEWALLET");
        primaryStage.setResizable(false);
        primaryStage.setScene(dashboardScene);
        primaryStage.centerOnScreen();
        primaryStage.show();

        return loader;
    }

    public FXMLLoader showAddIncomePage() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/addIncome.fxml"));
        Scene addIncomeScene = new Scene(loader.load());

        secondaryStage.setTitle("Add Income - WISEWALLET");
        secondaryStage.setResizable(false);
        secondaryStage.setScene(addIncomeScene);
        secondaryStage.centerOnScreen();
        secondaryStage.show();

        return loader;
    }

    public FXMLLoader showAddExpensePage() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/addExpense.fxml"));
        Scene addIncomeScene = new Scene(loader.load());

        secondaryStage.setTitle("Add Expense - WISEWALLET");
        secondaryStage.setResizable(false);
        secondaryStage.setScene(addIncomeScene);
        secondaryStage.centerOnScreen();
        secondaryStage.show();

        return loader;
    }

    public FXMLLoader showIncomeExpenseView() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/incomeExpensesView.fxml"));
        Scene addIncomeScene = new Scene(loader.load());

        IncomeExpenseViewController incomeExpenseViewController = loader.getController();
        incomeExpenseViewController.setMainApp(this);

        secondaryStage.setTitle("Income/Expense - WISEWALLET");
        secondaryStage.setResizable(false);
        secondaryStage.setScene(addIncomeScene);
        secondaryStage.centerOnScreen();
        secondaryStage.show();

        return loader;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
