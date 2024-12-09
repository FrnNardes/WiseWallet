module WiseWallet {

    exports com.wisewallet;  // Add this line to export the package

    
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.wisewallet.controllers to javafx.fxml;  // Permite acesso a esse pacote para o FXMLLoader
    exports com.wisewallet.vision;
    opens com.wisewallet.modules to javafx.fxml;
    
}