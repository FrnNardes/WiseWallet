/*import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private String css = this.getClass().getResource("Style.css").toExternalForm();

    public SceneController(){

    }
    public void loginButtonAction(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("a.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }
    
}*/
