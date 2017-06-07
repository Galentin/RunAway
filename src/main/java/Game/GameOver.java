package Game;

import Game.buttons.ExitButton;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import static Game.Constant.*;

public class GameOver extends Pane {
    private Label score;

    public GameOver(Integer i) {
        ImageView bg = new ImageView(new Image("/gameover.png"));
        bg.setFitWidth(WINDOW_WIDTH);
        bg.setFitHeight(WINDOW_HEIGHT);
        score(i);
        ExitButton exit = new ExitButton(280, 330);
        getChildren().addAll(bg, exit, score);
    }

    private void score(Integer i) {
        score = new Label("Score : " + i);
        score.setFont(new Font("Cooper",50));
        score.setTextFill(Color.valueOf("fe017e"));
        score.setTranslateX(250);
        score.setTranslateY(200);
    }
}
