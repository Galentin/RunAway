package Game;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.List;
import java.util.Random;

import static Game.Constant.*;
import static Game.Main.gameField;

public class Enemy extends ImageView {

    private Point2D velocity = new Point2D(0, 0);
    private double speed = ENEMY_SPEED;

    public Enemy(int i) {
        setImage(new Image("/food" + i + ".png"));
        setFitWidth(BLOCK_SIZE);
        setFitHeight(BLOCK_SIZE);
        gameField.getChildren().remove(this);
    }

    static public void addEnemy(final double speed, final Pane root, final List<Enemy> enemies, double xhead, double yhead) {
        final Enemy enemy = randomEnemy();
        final double radius = (Math.sqrt(Math.pow(WINDOW_WIDTH, 2) + Math.pow(GAME_PANEL_HEIGHT, 2))) / 2;
        final double x = WINDOW_WIDTH / 2 - radius + Math.random() * 2 * radius;
        final double y = Math.pow(-1, new Random().nextInt(2)) *
                Math.sqrt(Math.pow(radius, 2) - Math.pow((x - WINDOW_WIDTH / 2), 2)) + GAME_PANEL_HEIGHT / 2;
        enemies.add(enemy);
        enemy.setTranslateX(x);
        enemy.setTranslateY(y);
        enemy.setSpeed(speed);

        enemy.setVelocity(new Point2D(xhead - x , yhead - y).normalize());
        root.getChildren().add(enemy);
    }


    public void update() {
        setTranslateX(getTranslateX() + velocity.multiply(speed).getX());
        setTranslateY(getTranslateY() + velocity.multiply(speed).getY());
    }

    static private Enemy randomEnemy() {
        if (Math.random() < 0.2) return new Enemy(1);
        else if (Math.random() < 0.4) return new Enemy(2);
        else if (Math.random() < 0.6) return new Enemy(3);
        else if (Math.random() < 0.8) return new Enemy(4);
        else return new Enemy(5);
    }

    public void setVelocity(Point2D velocity) {
        this.velocity = velocity;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
