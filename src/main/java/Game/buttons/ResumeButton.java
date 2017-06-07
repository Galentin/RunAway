package Game.buttons;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;

import static Game.Constant.*;
import static Game.Main.gameField;
import static Game.InformationPanel.timeline;

public class ResumeButton extends Button{
    public ResumeButton(AnimationTimer timer, double x, double y) {
        super(new Image("/go.png"),
                new Image("/go2.png"),x, y);
        setFitWidth(BUTTON_WIDTH);
        setFitHeight(BUTTON_HEIGHT);
        setOnMouseClicked(event -> {
            timer.start();
            timeline.play();
            gameField.getChildren().remove(gameField.getChildren().size() - 1);
        });
    }
}
