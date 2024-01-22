import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

class Rules {
    void paint(Graphics2D g2d) {
        g2d.setStroke(new BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("SansSerif", Font.PLAIN, 100));
        g2d.drawString("RULES", 330, 110);
        
        g2d.setFont(new Font("SansSerif", Font.PLAIN, 64));
        g2d.drawRect(912, 12, 88, 88);
        g2d.drawImage(Images.returnIcon, 924, 24, Game.getInstance().panel);
        g2d.setFont(new Font("SansSerif", Font.PLAIN, 30));
        String str = """
                Use WASD or arrow keys to move around.
                During a level, you can undo move(U), restart(R), return(Backspace),
                or look at hints(H). Please do not immediately look at hints.
                To win a level, stand on the WIN tile., which is usually blocked.
                You may push Boxes and Connecters, but not more than one at a time.
                Both may be used to activate buttons and prevent doors from closing.
                Transmitters shoot red or blue Lasers, which can be used by Connecters.
                Red ones transmit red, blue transmit blue, and purple transmit both.
                Connecters transmit in ALL eight ordinal and cardinal directions,
                However, there will only be a visual feedback if there is something
                the Laser is able to hit, such as another connecter or a Receiver
                Buttons and Receivers activate Wires, and all connected Doors
                In later levels, there is Glass in which Lasers can pass through
                Every 6th level is a much harder level, feel free to skip them
                HAVE FUN!""";
        int y = 135;
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
