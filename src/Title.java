import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

class Title {
    void paint(Graphics2D g2d) {
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fillRect(0, 0, 1200, 1000);
        g2d.setFont(new Font("SansSerif", Font.PLAIN, 120));
        g2d.setStroke(new BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
        g2d.setColor(Color.BLACK);
        g2d.drawString("PUZZLE GAME", 80, 148);
        g2d.setFont(new Font("SansSerif", Font.PLAIN, 80));
        FontMetrics metrics = g2d.getFontMetrics();
        g2d.drawRect(252, 225, 500, 120);
        g2d.setColor(Color.GREEN);
        g2d.fillRect(256, 229, 492, 112);
        g2d.setColor(Color.BLACK);
        g2d.drawString("PLAY", 502 - metrics.stringWidth("PLAY") / 2, 225 + 87);
        g2d.drawRect(252, 400, 500, 120);
        g2d.setColor(Color.ORANGE);
        g2d.fillRect(256, 404, 492, 112);
        g2d.setColor(Color.BLACK);
        g2d.drawString("RULES", 502 - metrics.stringWidth("RULES") / 2, 400 + 87);
        g2d.drawRect(252, 575, 500, 120);
        g2d.setColor(Color.WHITE);
        g2d.fillRect(256, 579, 492, 112);
        g2d.setColor(Color.BLACK);
        g2d.drawString("CREDITS", 502 - metrics.stringWidth("CREDITS") / 2, 575 + 87);
        g2d.setStroke(new BasicStroke(24f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
        g2d.drawLine(12, 0, 12, 1000);
        g2d.drawLine(998, 0, 998, 1000);
    }
    void mouseClicked(MouseEvent e) {
        if (248 < e.getX() && e.getX() < 756 && 221 < e.getY() && e.getY() < 349) {
            Game.getInstance().setGameState(0);
        }
        if (248 < e.getX() && e.getX() < 756 && 396 < e.getY() && e.getY() < 524) {
            Game.getInstance().setGameState(-2);
        }
        if (248 < e.getX() && e.getX() < 756 && 571 < e.getY() && e.getY() < 699) {
            Game.getInstance().setGameState(-3);
        }
    }
}
