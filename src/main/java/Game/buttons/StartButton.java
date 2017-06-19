package Game.buttons;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import static Game.Constant.*;
import static Game.Main.gameField;
import static Game.Main.keys;
import static Game.Main.stage;
import static Game.GameField.timer;
import static Game.InformationPanel.timeline;
import static Game.GameField.mediaPlayer;

public class StartButton extends Button {

    private boolean moved = false;


    public StartButton(double x, double y) {
        super(new Image("/start.png"),
                new Image("/start2.png"), x, y);
        setFitWidth(BUTTON_WIDTH);
        setFitHeight(BUTTON_HEIGHT);
        setOnMouseClicked(event -> {
            Scene scene = new Scene(gameField);
            scene.setOnKeyPressed(e -> keys.put(e.getCode(), true));
            scene.setOnKeyReleased(e -> keys.put(e.getCode(), false));
            stage.setScene(scene);
            timer.start();
            timeline.play();

            Media musicFile = new Media("file:///C:/Users/admin/IdeaProjects/RunAway/src/main/resources/music.mp3");
            mediaPlayer = new MediaPlayer(musicFile);
            mediaPlayer.setVolume(0.03);
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            mediaPlayer.play();
        });
    }
}
