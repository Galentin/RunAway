package Game;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;


import static Game.Constant.*;

public class InformationPanel extends Pane {
    private Label score;
    private Font font = new Font("Cooper", 50);
    private Color color = Color.valueOf("#fe017e");
    private Integer i = 0;
    public static Timeline timeline = new Timeline();

    public InformationPanel() {
        ImageView bg = new ImageView(new Image("/inf.png"));
        setPrefSize(INFORMATION_PANEL_WIDTH, INFORMATION_PANEL_HEIGHT);
        bg.setTranslateX(0);
        bg.setTranslateY(GAME_PANEL_HEIGHT);
        score();
        getChildren().addAll(bg, score);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(500), event -> {
            i++;
            score.setText("Score : " + i);
        });
        timeline.getKeyFrames().addAll(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);

    }

    private void score() {
        score = new Label("Score: ");
        score.setFont(font);
        score.setTextFill(color);
        score.setTranslateX(250);
        score.setTranslateY(525);
    }

    public Integer getScore() {
        return i;
    }

}
