package Game.buttons;

import Game.PauseMenu;
import javafx.scene.image.Image;

import static Game.Main.gameField;
import static Game.GameField.timer;
import static Game.InformationPanel.timeline;
import static Game.Constant.*;

public class PauseButton extends Button {
    public PauseButton(double x, double y) {
        super(new Image("/pause.png"),
                new Image("/pause1.png"), x, y);
        setFitWidth(BLOCK_SIZE);
        setFitHeight(BLOCK_SIZE);
        setOnMouseClicked(event -> {
            timer.stop();
            timeline.stop();
            gameField.getChildren().add(new PauseMenu());
        });
    }
}
