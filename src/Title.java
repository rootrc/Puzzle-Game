import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

class Title {
    void paint(Graphics2D g2d) {
        g2d.setStroke(new BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("SansSerif", Font.PLAIN, 100));
        g2d.drawString("GAME", 350, 100);
        g2d.setStroke(new BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
        g2d.drawRect(400, 500, 200, 100);
        g2d.setFont(new Font("SansSerif", Font.PLAIN, 72));
        g2d.drawString("PLAY", 408, 578);

    }
    void mouseClicked(MouseEvent e) {
        if (396 < e.getX() && e.getX() < 604 && 496 < e.getY() && e.getY() < 604) {
            Game.getInstance().setGameState(0);
        }   
    }
}
