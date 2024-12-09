module WiseWallet {

    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.wisewallet.controllers to javafx.fxml;  // Permite acesso a esse pacote para o FXMLLoader
    exports com.wisewallet;
}