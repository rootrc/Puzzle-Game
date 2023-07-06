import java.awt.Color;
import javax.swing.*;

public class Game {  
    static Level level;
    static Panel panel;
    static JFrame frame;
    static int gameState = 0;
    static boolean loaded = false;
    public static void main(String[] args) {  
        frame = new JFrame ();
        frame.setTitle("Game");
        frame.setBackground(Color.black);
        frame.setSize(1024, 768); /*1004 728*/
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new Panel();
        frame.add(panel);
        frame.setVisible(true);
    }

} 

