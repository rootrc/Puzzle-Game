import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

class Credits {
    void paint(Graphics2D g2d) {
        g2d.setStroke(new BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("SansSerif", Font.PLAIN, 100));
        g2d.drawString("CREDITS", 300, 110);

        g2d.setFont(new Font("SansSerif", Font.PLAIN, 64));
        g2d.drawRect(912, 12, 88, 88);
        g2d.drawImage(Images.returnIcon, 924, 24, Game.getInstance().panel);
        g2d.setFont(new Font("SansSerif", Font.PLAIN, 35));
        String str = """
            This is my ICS3Ufinal, 2023-2024, teacher Ms. Wong

            Programmer: Ian Wang
            Graphics: Ian Wang
            Inspiration: The Talos Principle
            Play Testers: Aayan Karmali, Daniel Pu, George Zhu,\nIsabella Si, Nicholas Ng, and Zachary Grosman
            Special Thanks: Daniel Pu, docs.oracle.com, Ms. Wong
            My favourite levels: Levels 11, 18, 22, 23, 24
            """;
        int y = 150;
        FontMetrics metrics = g2d.getFontMetrics();
        for (String line : str.split("\n")) {
            g2d.drawString(line, 50, y += metrics.getHeight());
        }
    }

    void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_BACK_SPACE) {
            Game.getInstance().setGameState(-1);
        }
    }
    
    void mouseClicked(MouseEvent e) {
        if (908 < e.getX() && e.getX() < 1004 && 8 < e.getY() && e.getY() < 104) {
            Game.getInstance().setGameState(-1);
        }
    }
}
