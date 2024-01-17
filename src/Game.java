import javax.swing.*;
import java.awt.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

public class Game {
    final private int delay = 20;
    private static Game instance;
    JFrame frame;
    Panel panel;
    Title title;
    LevelMenu menu;
    Level level;
    LevelFactory levelFactory;
    Deque<Level> stack = new LinkedList<>();
    int gameState = -1;
    boolean loaded = false;

    private Game() {
        frame = new JFrame();
        panel = new Panel();
        title = new Title();
        menu = new LevelMenu();
        level = new Level();
        levelFactory = new LevelFactory();
        frame.setTitle("Game");
        frame.setBackground(Color.black);
        frame.setSize(1024, 768); /* 1004 728 */
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);
        Timer timer = new Timer();
        TimerTask timertask = new TimerTask() {
            public void run() {
                if (isLevel() && isLoaded()) {
                    level.process();
                }
                panel.repaint();
            }
        };
        timer.schedule(timertask, 0, delay);
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public static void main(String[] args) {
        Game.instance = new Game();
        // Game.getInstance();
    }

    boolean isTitle() {
        return gameState == -1;
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
        try {
            Thread.sleep(50);
        } catch (Exception ignored) {
        }
        loaded = false;
        levelFactory.setUp();
    }
    void setGameState(int gameState) {
        try {
            Thread.sleep(50);
        } catch (Exception ignored) {
        }
        this.gameState = gameState;
    }
}