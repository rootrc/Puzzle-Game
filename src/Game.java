import java.awt.Color;
import javax.swing.JFrame;

public class Game {  
    static JFrame frame;
    static Panel panel;
    static int gameState = 0;
    static Level level;
    static LevelMenu menu;
    static boolean loaded = false;
    public static void main(String[] args) {  
        frame = new JFrame ();
        frame.setTitle("Game");
        frame.setBackground(Color.black);
        frame.setSize(1024, 768); /*1004 728*/
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu = new LevelMenu();
        panel = new Panel();
        frame.add(panel);
        frame.setVisible(true);

    }
    static boolean isMenu() {
        return Game.gameState == 0;
    }
    static boolean isLevel() {
        return (1 <= Game.gameState && Game.gameState <= 24);
    }
} 

