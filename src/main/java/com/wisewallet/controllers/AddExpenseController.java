package com.wisewallet.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


public class AddExpenseController extends BaseController{

    @FXML
    private TextField expenseValue;

    private DashboardController dashboardController;

    public void setDashboardController(DashboardController dashboardController) {
        this.dashboardController = dashboardController;
    }

    public void addExpense(KeyEvent event) {
        if (event.getCode().toString().equals("ENTER")){
            dashboardController.updateExpenseLabel(expenseValue.getText());
            Stage stage = (Stage) expenseValue.getScene().getWindow();
            stage.close();
        }
    }
}
