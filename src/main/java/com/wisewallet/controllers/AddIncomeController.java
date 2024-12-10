package com.wisewallet.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class AddIncomeController extends BaseController {

    @FXML
    private TextField incomeValue;

    private DashboardController dashboardController;

    public void setDashboardController(DashboardController dashboardController) {
        this.dashboardController = dashboardController;
    }

    public void addIncome(KeyEvent event) {
        if (event.getCode().toString().equals("ENTER")){
            dashboardController.updateIncomeLabel(incomeValue.getText());
            Stage stage = (Stage) incomeValue.getScene().getWindow();
            stage.close();
        }
    }
}
