import javax.swing.*;
import java.awt.*;
import java.util.Deque;
import java.util.LinkedList;

public class Game {
    static JFrame frame = new JFrame();
    static Panel panel = new Panel();
    static LevelMenu menu = new LevelMenu();
    static Level level = new Level();
    static Deque<Level> stack = new LinkedList<>();
    static int gameState = 0;
    static boolean loaded = false;

    public static void main(String[] args) {
        frame.setTitle("Game");
        frame.setBackground(Color.black);
        frame.setSize(1024, 768); /*1004 728*/
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);
    }

    static boolean isMenu() {
        return Game.gameState == 0;
    }

    static boolean isLevel() {
        return (1 <= Game.gameState && Game.gameState <= 24);
    }

    static boolean isLoaded() {
        return Game.loaded;
    }

    static void loadLevel() {
        Game.loaded = false;
        LevelFactory.setUp();
    }
} 

