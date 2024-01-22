import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

class LevelMenu {
    boolean[] starsCollected = new boolean[] { false, false, false };

    void paint(Graphics2D g2d) {
        g2d.setStroke(new BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("SansSerif", Font.PLAIN, 64));
        g2d.drawRect(912, 12, 88, 88);
        g2d.drawImage(Images.returnIcon, 924, 24, Game.getInstance().panel);
        g2d.setFont(new Font("SansSerif", Font.PLAIN, 100));
        g2d.drawString("LEVELS", 332, 140);
        g2d.setFont(new Font("SansSerif", Font.PLAIN, 72));
        g2d.setStroke(new BasicStroke(16f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
        g2d.setColor(Color.BLUE);
        g2d.drawLine(120, 390, 888, 390);
        g2d.setColor(Color.RED);
        g2d.drawLine(120, 518, 888, 518);
        g2d.setStroke(new BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 4; y++) {
                g2d.setColor(new Color(255, 165, 0));
                g2d.fillRect(x * 128 + 140, y * 128 + 218, 88, 88);
                g2d.setColor(Color.BLACK);
                g2d.drawRect(x * 128 + 140, y * 128 + 218, 88, 88);
                String num = String.valueOf(1 + x + y * 6);
                FontMetrics metrics = g2d.getFontMetrics();
                if (10 <= Integer.parseInt(num) && Integer.parseInt(num) < 20) {
                    g2d.drawString(num, x * 128 + 140 + (88 - metrics.stringWidth(num)) / 2 - 2,
                            y * 128 + 218 + (88 - metrics.getHeight()) / 2 + metrics.getAscent());
                } else if (Integer.parseInt(num) >= 20) {
                    g2d.drawString(num, x * 128 + 140 + (88 - metrics.stringWidth(num)) / 2 + 1,
                            y * 128 + 218 + (88 - metrics.getHeight()) / 2 + metrics.getAscent());
                } else {
                    g2d.drawString(num, x * 128 + 140 + (88 - metrics.stringWidth(num)) / 2,
                            y * 128 + 218 + (88 - metrics.getHeight()) / 2 + metrics.getAscent());
                }
            }
        }
        if (starsCollected[0]) {
            g2d.drawImage(Images.star, 728, 326, Game.getInstance().panel);
        }
        if (starsCollected[1]) {
            g2d.drawImage(Images.star, 600, 454, Game.getInstance().panel);
        }
        if (starsCollected[2]) {
            g2d.drawImage(Images.star, 472, 582, Game.getInstance().panel);
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
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 4; y++) {
                if (x * 128 + 136 < e.getX() && e.getX() < x * 128 + 232 && y * 128 + 214 < e.getY()
                        && e.getY() < y * 128 + 310) {
                    Game.getInstance().setGameState(6 * y + x + 1);
                    Game.getInstance().loadLevel();
                }
            }
        }
    }
}