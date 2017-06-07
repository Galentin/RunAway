package Game;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import static Game.Constant.*;
import static Game.Main.gameField;

public class Enemy extends ImageView {
    private Point2D velocity = new Point2D(0, 0);
    private double speed = ENEMY_INITIAL_SPEED;

    public Enemy(int i) {
        setImage(new Image("/food" + i + ".png"));
        setFitWidth(BLOCK_SIZE);
        setFitHeight(BLOCK_SIZE);
        gameField.getChildren().remove(this);
    }

    public void update() {
        setTranslateX(getTranslateX() + velocity.multiply(speed).getX());
        setTranslateY(getTranslateY() + velocity.multiply(speed).getY());
    }

    public void setVelocity(Point2D velocity) {
        this.velocity = velocity;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
