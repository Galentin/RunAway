package Game;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;

import java.util.ArrayList;
import java.util.List;

import static Game.Constant.*;
import static Game.Enemy.addEnemy;
import Game.buttons.PauseButton;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import static Game.InformationPanel.timeline;

public class GameField extends Pane {

    public static AnimationTimer timer;
    private final InformationPanel informationPanel;
    private final PauseButton pauseButton;
    ImageView player = new ImageView(new Image("/player.png"));
    private double count = ENEMY_COUNT;
    private double speed = ENEMY_SPEED;
    private List<Enemy> enemies = new ArrayList<>();
    public static MediaPlayer mediaPlayer;


    public GameField() {
        setPrefSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        ImageView bg = new ImageView(new Image("/bg.jpg"));
        bg.setFitWidth(WINDOW_WIDTH);
        bg.setFitHeight(GAME_PANEL_HEIGHT);
        informationPanel = new InformationPanel();
        player.setFitWidth(BLOCK_SIZE);
        player.setFitHeight(BLOCK_SIZE);
        player.setTranslateX(GAMEFIELD_CENTER_X);
        player.setTranslateY(GAMEFIELD_CENTER_Y);
        pauseButton = new PauseButton(720, 540);



        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        };

        getChildren().addAll(bg, informationPanel, player, pauseButton);
    }

    public void update() {
        if (isPressed(KeyCode.W)) {
            movePlayerU(3);
        }
        if (isPressed(KeyCode.S)) {
            movePlayerD(3);
        }
        if (isPressed(KeyCode.A)) {
            movePlayerL(3);
        }
        if (isPressed(KeyCode.D)) {
            movePlayerR(3);
        }

        if (Math.random() < count) addEnemy(speed, this, enemies, player.getTranslateX(), player.getTranslateY());
        for (Enemy enemy : enemies) {
            collision(enemy);
            enemy.toFront();
        }
        informationPanel.toFront();
        pauseButton.toFront();
        enemies.forEach(Enemy::update);
        count += ENEMY_COUNT_INCREMENT;
        speed += ENEMY_SPEED_INCREMENT;
    }

    public void movePlayerD(int value) {
        if (player.getTranslateY() <= GAME_PANEL_HEIGHT - 40) {
            for (int i = 0; i < Math.abs(value); i++) {
                player.setTranslateY(player.getTranslateY() + 1);
            }
        }
    }

    public void movePlayerU(int value) {
        if (player.getTranslateY() >= 0) {
            for (int i = 0; i < Math.abs(value); i++) {
                player.setTranslateY(player.getTranslateY() - 1);
            }
        }
    }

    public void movePlayerL(int value) {
        if (player.getTranslateX() >= 0) {
            for (int i = 0; i < Math.abs(value); i++) {
                player.setTranslateX(player.getTranslateX() - 1);
            }
        }
    }

    public void movePlayerR(int value) {
        if (player.getTranslateX() <= WINDOW_WIDTH - 40) {
            for (int i = 0; i < Math.abs(value); i++) {
                player.setTranslateX(player.getTranslateX() + 1);
            }
        }
    }

    private void collision(Enemy enemy) {
        if (getChildren().contains(player) && player.getBoundsInParent().intersects(enemy.getBoundsInParent())) {
            timer.stop();
            timeline.stop();
            mediaPlayer.stop();
            Main.stage.setScene(new Scene(new GameOver(informationPanel.getScore()), WINDOW_WIDTH, WINDOW_HEIGHT));
        }
    }

    private boolean isPressed(KeyCode key) {
        return Main.keys.getOrDefault(key, false);
    }
}
