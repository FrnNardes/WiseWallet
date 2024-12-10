package com.wisewallet.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import com.wisewallet.modules.UserSession;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class DashboardController extends BaseController {

    @FXML
    private Label usernameLabel;

    @FXML
    private Label totalLabel;

    @FXML
    private Label incomeLabel;

    @FXML
    private Label expenseLabel;

    @FXML
    private PieChart pieChart;

    @FXML
    private BarChart<String, Number> barChart;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    private LocalDate currentDate = LocalDate.now();

    // Inicialização da Dashboard
    @FXML
    public void initialize() {
        String username = UserSession.getInstance().getCurrentUser().getNome();
        if (username != null) {
            usernameLabel.setText("Olá " + username + ", seja bem-vindo(a)!");
        } else {
            usernameLabel.setText("Olá, visitante!");
        }
        xAxis.setLabel("Mês Atual");
        yAxis.setLabel("Valor (R$)");

        updateBarChart();
        updatePieChart();
        updateTotalLabel();
    }

    // Atualiza o gráfico de barras com base no mês atual
    private void updateBarChart() {
        barChart.getData().clear();
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Progresso Mensal");

        // Adiciona os valores dos últimos 5 meses + o mês atual
        for (int i = 5; i >= 0; i--) {
            LocalDate monthDate = currentDate.minusMonths(i);
            String monthName = monthDate.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault());
            double income = i == 0 ? parseLabelValue(incomeLabel) : 0;
            double expense = i == 0 ? parseLabelValue(expenseLabel) : 0;
            double netDifference = income - expense;

            XYChart.Data<String, Number> data = new XYChart.Data<>(capitalize(monthName), netDifference);
            series.getData().add(data);
        }
        barChart.getData().add(series);
        // Aplica as cores nas barras após o gráfico ser renderizado
        Platform.runLater(() -> {
            for (XYChart.Data<String, Number> data : series.getData()) {
                // Definindo a cor da barra
                double netDifference = (double) data.getYValue();
                if (netDifference >= 0) {
                    data.getNode().setStyle("-fx-bar-fill: orange;"); // Cor para valores positivos
                } else {
                    data.getNode().setStyle("-fx-bar-fill: red;"); // Cor para valores negativos
                }
            }
        });
    }

    // Atualiza o gráfico de pizza com entradas e saídas
    private void updatePieChart() {
        double incomeValue = parseLabelValue(incomeLabel);
        double expenseValue = parseLabelValue(expenseLabel);

        pieChart.getData().clear();

        PieChart.Data incomeData = new PieChart.Data("Entrada", incomeValue);
        PieChart.Data expenseData = new PieChart.Data("Saída", expenseValue);

        pieChart.getData().addAll(incomeData, expenseData);

        incomeData.getNode().setStyle("-fx-pie-color: #00d600;");
        expenseData.getNode().setStyle("-fx-pie-color: red;");
    }

    // Atualiza o valor total (Entradas - Saídas)
    private void updateTotalLabel() {
        double total = parseLabelValue(incomeLabel) - parseLabelValue(expenseLabel);
        totalLabel.setText(String.format("%.2f", total));
    }

    // Adiciona página de entradas
    public void addIncomePage() {
        try {
            FXMLLoader loader = mainApp.showAddIncomePage();
            AddIncomeController addIncomeController = loader.getController();
            addIncomeController.setDashboardController(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Adiciona página de despesas
    public void addExpensePage() {
        try {
            FXMLLoader loader = mainApp.showAddExpensePage();
            AddExpenseController addExpenseController = loader.getController();
            addExpenseController.setDashboardController(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void incomeExpenseViewButtonAction() {
        try{
            FXMLLoader loader = mainApp.showIncomeExpenseView();
            IncomeExpenseViewController ieController = loader.getController();
            ieController.setDashboardController(this);
            Stage stage = (Stage) incomeLabel.getScene().getWindow();
            stage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Atualiza os valores de entradas
    public void updateIncomeLabel(String income) {
        double value = updateLabelValue(incomeLabel, income);
        UserSession.getInstance().getCurrentUser().adicionarEntrada(value);
    }

    // Atualiza os valores de despesas
    public void updateExpenseLabel(String expense) {
        double value = updateLabelValue(expenseLabel, expense);
        UserSession.getInstance().getCurrentUser().adicionarSaida(value);
    }

    // Metodo auxiliar para atualizar valores de Labels
    private double updateLabelValue(Label label, String value) {
        double currentValue = parseLabelValue(label);
        double newValue = currentValue + Double.parseDouble(value);
        label.setText(String.format("%.2f", newValue));
        refreshDashboard();
        return newValue;
    }

    // Atualiza toda a Dashboard
    private void refreshDashboard() {
        updatePieChart();
        updateBarChart();
        updateTotalLabel();
    }

    // Metodo auxiliar para converter o texto de um Label em Double
    private double parseLabelValue(Label label) {
        return Double.parseDouble(label.getText().replace(",", "."));
    }

    // Metodo auxiliar para capitalizar strings
    private String capitalize(String text) {
        return text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();
    }
}