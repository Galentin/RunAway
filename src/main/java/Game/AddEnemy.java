package Game;

import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;

import java.util.List;
import java.util.Random;

import static Game.Constant.*;

public class AddEnemy {

    static public void addEnemy(final double speed, final Pane root, final List<Enemy> enemies, double xhead, double yhead) {
        final Enemy enemy = randomEnemy();
        final double radius = (Math.sqrt(Math.pow(WINDOW_WIDTH, 2) + Math.pow(GAME_PANEL_HEIGHT, 2))) / 2;
        final double x = WINDOW_WIDTH / 2 - radius + Math.random() * 2 * radius;
        final double y = Math.pow(-1, new Random().nextInt(2) + 1) *
                Math.sqrt(Math.pow(radius, 2) - Math.pow((x - WINDOW_WIDTH / 2), 2)) + GAME_PANEL_HEIGHT / 2;
        enemies.add(enemy);
        enemy.setTranslateX(x);
        enemy.setTranslateY(y);
        enemy.setSpeed(speed);

        enemy.setVelocity(new Point2D(xhead - x , yhead - y).normalize());
        root.getChildren().add(enemy);
    }

    static private Enemy randomEnemy() {
        if (Math.random() < 0.2) return new Enemy(1);
        else if (Math.random() < 0.4) return new Enemy(2);
        else if (Math.random() < 0.6)return new Enemy(3);
        else if (Math.random() < 0.8)return new Enemy(4);
        else return new Enemy(5);
    }
}
