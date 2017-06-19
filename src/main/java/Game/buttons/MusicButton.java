package Game.buttons;

import javafx.scene.image.Image;

import static Game.Constant.*;
import static Game.GameField.mediaPlayer;

public class MusicButton extends Button {
    public MusicButton(double x, double y) {
        super(new Image("/speaker.png"),
                new Image("/speaker2.png"), x, y);
        setFitWidth(BLOCK_SIZE * 2);
        setFitHeight(BLOCK_SIZE * 2);
        setOnMouseClicked(event -> {
            mediaPlayer.stop();
        });

    }
}
