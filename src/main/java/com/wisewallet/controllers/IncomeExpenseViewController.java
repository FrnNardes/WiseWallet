package com.wisewallet.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import com.wisewallet.vision.MainApplication;

public class IncomeExpenseViewController extends BaseController {

    @FXML
    private Label incomeLabel;

    private DashboardController dashboardController;

    public void setDashboardController(DashboardController dashboardController) {
        this.dashboardController = dashboardController;
    }

    @FXML
    public void dashboardButtonAction() {
        try {
            // Carrega a página do Dashboard
            FXMLLoader loader = mainApp.showDashboardPage();
            // Obtém o controlador do Dashboard
            DashboardController dashboardController = loader.getController();
            // Passa a instância de MainApplication para o DashboardController
            dashboardController.setMainApp(mainApp); // Passando o MainApplication correto

            // Verifica se o incomeLabel foi inicializado
            if (incomeLabel != null) {
                // Fecha a janela atual
                Stage stage = (Stage) incomeLabel.getScene().getWindow();
                stage.close();
            } else {
                System.out.println("Erro: incomeLabel não está inicializado.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
