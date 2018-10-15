import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.input.KeyEvent;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Darstellung als fxml-Datei
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view.fxml"));
        Parent root = loader.load();

        // der zugehörige Controller wird geladen
        Controller controller = loader.getController();

        // Fenster erstellen und anzeigen
        Scene scene = new Scene(root);

        scene.setOnKeyPressed((KeyEvent ke) -> {
                controller.gedrueckt(ke);
            });
        /*
        scene.setOnKeyReleased((KeyEvent ke) -> {
        controller.losgelassen(ke);
        });
         */
        //scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("SNAKE");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void steuerungEinrichten(){

    }
}