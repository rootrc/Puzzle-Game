import java.awt.event.MouseEvent;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;

class LevelMenu {
    boolean [] starsCollected = new boolean [] {false, false, false};
    void mouseClicked(MouseEvent e) {
        if (Game.gameState == 0) {
            for (int x = 0; x < 6; x ++) {
                for (int y = 0; y < 4; y ++) {
                    if (x * 128 + 136 < e.getX() && e.getX() < x * 128 + 232 && y * 144 + 132 < e.getY() && e.getY() < y * 144 + 228) {
                        try {
                            Thread.sleep(50);
                        } catch (Exception execption) {
        
                        }
                        Game.gameState = 1 + x + y * 6; 
                        Game.level = new Level();
                        LevelData.setUp();
                    }
                }
            }
        }
    }
    void paint (Graphics2D g2d) {
        g2d.setStroke(new BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("TimesRoman", Font.PLAIN, 100));
            g2d.drawString("Levels", 372,100);
            g2d.setFont(new Font("TimesRoman", Font.PLAIN, 72));
            for (int x = 0; x < 6; x ++) {
                for (int y = 0; y < 4; y ++) {
                    g2d.setColor(Color.BLUE);
                    g2d.fillRect(x * 128 + 140, y * 144 + 136, 88, 88);
                    g2d.setColor(Color.BLACK);
                    int levelNum = 1 + x + y * 6;
                    if (levelNum < 10) {
                        g2d.drawString(String.valueOf(1 + x + y * 6), x * 128 + 166, y * 144 + 202);
                    } else if (levelNum < 20){
                        g2d.drawString(String.valueOf(1 + x + y * 6), x * 128 + 146, y * 144 + 202);
                    } else {
                        g2d.drawString(String.valueOf(1 + x + y * 6), x * 128 + 150, y * 144 + 202);
                    }
                }
            }
            if (this.starsCollected[0]) {
                g2d.drawImage(Images.star, 724, 264, Game.panel);
            }
            if (this.starsCollected[1]) {
                g2d.drawImage(Images.star, 596, 408, Game.panel);
            }
            if (this.starsCollected[2]) {
                g2d.drawImage(Images.star, 468, 552, Game.panel);
            }
    }

}