package Game;

public class Constant {
    public static final double WINDOW_WIDTH = 800;
    public static final double WINDOW_HEIGHT = 600;

    public static final double BUTTON_WIDTH = 240;
    public static final double BUTTON_HEIGHT = 120;

    public static final double INFORMATION_PANEL_WIDTH = 800;
    public static final double INFORMATION_PANEL_HEIGHT = 80;

    public static final double GAME_PANEL_HEIGHT = WINDOW_HEIGHT - INFORMATION_PANEL_HEIGHT;

    public static final double BLOCK_SIZE = 40;

    public static final double ENEMY_SPEED = 3.1;
    public static final double ENEMY_SPEED_INCREMENT = 0.0001;
    public static final double ENEMY_COUNT = 0.02;
    public static final double ENEMY_COUNT_INCREMENT = 0.000001;

    public static final double GAMEFIELD_CENTER_X = WINDOW_WIDTH / 2 - BLOCK_SIZE/2;
    public static final double GAMEFIELD_CENTER_Y = GAME_PANEL_HEIGHT / 2 - BLOCK_SIZE/2;

}
