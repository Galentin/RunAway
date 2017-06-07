package Game.buttons;

import javafx.scene.image.Image;

import static Game.Constant.*;

public class ExitButton  extends Button {
    public ExitButton(double x, double y) {
        super(new Image("/exit.png"),
                new Image("/exit2.png"), x, y);
        setFitWidth(BUTTON_WIDTH);
        setFitHeight(BUTTON_HEIGHT);
        setOnMouseClicked(event -> System.exit(0));
    }
}
