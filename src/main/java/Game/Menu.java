package Game;

import Game.buttons.ExitButton;
import Game.buttons.StartButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import static Game.Constant.*;

public class Menu extends Pane{
    public Menu () {
        ImageView bg = new ImageView(new Image("/main.png"));
        bg.setFitWidth(WINDOW_WIDTH);
        bg.setFitHeight(WINDOW_HEIGHT);
        StartButton start = new StartButton(80, 330);
        ExitButton exit = new ExitButton(490, 330);

        getChildren().addAll(bg, start, exit);
    }

}
