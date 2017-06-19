package Game;

import Game.buttons.ExitButton;
import Game.buttons.MusicButton;
import Game.buttons.ResumeButton;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import static Game.GameField.timer;


public class PauseMenu extends Pane {

    public PauseMenu() {
        Label text = new Label("Pause");
        text.setFont(new Font("Cooper", 90));
        text.setTextFill(Color.valueOf("#fe017e"));
        text.setTranslateX(260);
        text.setTranslateY(30);
        ExitButton exit = new ExitButton(280, 300);
        ResumeButton resume = new ResumeButton(timer, 280, 200);
        MusicButton musicButton = new MusicButton(370, 450);
        setPrefSize(800, 600);
        setStyle("-fx-background-color: #ffffff");
        getChildren().addAll(text, exit, resume, musicButton);
    }
}
