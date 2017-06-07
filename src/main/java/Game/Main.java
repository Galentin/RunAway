package Game;

import javafx.application.Application;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.util.HashMap;

public class Main extends Application {

    public static Stage stage;
    public static GameField gameField;
    public static HashMap<KeyCode, Boolean> keys = new HashMap<>();

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        gameField = new GameField();
        stage.setScene(new Scene(new Menu()));
        stage.setResizable(false);
        stage.sizeToScene();
        stage.setTitle("RunAway");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
