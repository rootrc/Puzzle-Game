import javax.swing.*;
import java.awt.*;
import java.util.Deque;
import java.util.LinkedList;
public class Game {
    private static Game instance = null;
    JFrame frame = new JFrame();
    Panel panel = new Panel();
    LevelMenu menu = new LevelMenu();
    Level level = new Level();
    LevelFactory levelFactory = new LevelFactory();
    Deque<Level> stack = new LinkedList<>();
    int gameState = 0;
    boolean loaded = false;

    private Game() {
        frame.setTitle("Game");
        frame.setBackground(Color.black);
        frame.setSize(1024, 768); /*1004 728*/
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);
    }
    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }
    public static void main(String[] args) {
        Game.getInstance();
    }
    boolean isMenu() {
        return gameState == 0;
    }
    boolean isLevel() {
        return (1 <= gameState && gameState <= 24);
    }

    boolean isLoaded() {
        return loaded;
    }

    void loadLevel() {
        loaded = false;
        levelFactory.setUp();
    }
}