package Game.buttons;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

class Button extends ImageView {
    private Image regular;
    private Image entered;

    Button(Image r, Image e, double x, double y) {
        regular = r;
        entered = e;
        setTranslateX(x);
        setTranslateY(y);
        setImage(regular);
        setOnMouseEntered(event -> setImage(entered));
        setOnMouseExited(event -> setImage(regular));
    }
}
