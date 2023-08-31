import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

class LevelMenu {
    boolean [] starsCollected = new boolean [] {false, false, false};
    void paint (Graphics2D g2d) {
        g2d.setStroke(new BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("SansSerif", Font.PLAIN, 100));
        g2d.drawString("LEVELS", 332,100);
        g2d.setFont(new Font("SansSerif", Font.PLAIN, 72));
        g2d.setStroke(new BasicStroke(16f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
        g2d.setColor(Color.BLUE);
        g2d.drawLine(120, 340, 888, 340);
        g2d.setColor(Color.RED);
        g2d.drawLine(120, 468, 888, 468);
        g2d.setStroke(new BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
        for (int x = 0; x < 6; x ++) {
            for (int y = 0; y < 4; y ++) {
                g2d.setColor(new Color(255, 165, 0));
                g2d.fillRect(x * 128 + 140, y * 128 + 168, 88, 88);
                g2d.setColor(Color.BLACK);
                g2d.drawRect(x * 128 + 140, y * 128 + 168, 88, 88);
                String num = String.valueOf(1 + x + y * 6);
                FontMetrics metrics = g2d.getFontMetrics(g2d.getFont());
                if (10 <= Integer.valueOf(num) && Integer.valueOf(num) < 20) {
                    g2d.drawString(num, x * 128 + 140 + (88 - metrics.stringWidth(num)) / 2 - 2, y * 128 + 168 + (88 - metrics.getHeight()) / 2 + metrics.getAscent());
                } else if (Integer.valueOf(num) >= 20 ) {
                    g2d.drawString(num, x * 128 + 140 + (88 - metrics.stringWidth(num)) / 2 + 1, y * 128 + 168 + (88 - metrics.getHeight()) / 2 + metrics.getAscent());
                } else {
                    g2d.drawString(num, x * 128 + 140 + (88 - metrics.stringWidth(num)) / 2, y * 128 + 168 + (88 - metrics.getHeight()) / 2 + metrics.getAscent());
                }
            }
        }
        if (starsCollected[0]) {
            g2d.drawImage(Images.star, 724, 264, Game.panel);
        }
        if (starsCollected[1]) {
            g2d.drawImage(Images.star, 596, 408, Game.panel);
        }
        if (starsCollected[2]) {
            g2d.drawImage(Images.star, 468, 552, Game.panel);
        }
    }
    void mouseClicked(MouseEvent e) {
        if (Game.gameState == 0) {
            for (int x = 0; x < 6; x ++) {
                for (int y = 0; y < 4; y ++) {
                    if (x * 128 + 136 < e.getX() && e.getX() < x * 128 + 232 && y * 128 + 164 < e.getY() && e.getY() < y * 128 + 260) {
                        try {
                            Thread.sleep(50);
                        } catch (Exception exception) {}
                        Game.gameState = 6 * y + x + 1; 
                        Game.loadLevel();
                    }
                }
            }
        }
    }
}