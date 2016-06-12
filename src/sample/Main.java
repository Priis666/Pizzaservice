package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent view = fxmlLoader.load();

        // pass reference primaryStage to loginController
        Controller controller = fxmlLoader.<Controller>getController();
        controller.setStage(primaryStage);

        // start first scene
        primaryStage.setTitle("Lieferando 2.0");
        primaryStage.setScene(new Scene(view));
        primaryStage.show();

        /* Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Lieferando 2.0");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();*/
    }

}