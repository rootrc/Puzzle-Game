import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

class Panel extends JPanel implements ActionListener {

    Timer timer;
    final int DELAY = 20;
    Panel() {
        super();
        addKeyListener(new TKeyAdapter());
        addMouseListener(new TMouseAdapter());
        setBackground(Color.white);
	    setFocusable(true);
        timer = new Timer(DELAY, this);
        timer.start();
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
        Toolkit.getDefaultToolkit().sync();
    }
    void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        if (Game.gameState == 0) {
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
        }
        if (isLevel() && Game.loaded) {
            Game.level.paint(g2d);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (isLevel() && Game.loaded) {
            Game.level.player.movement();
            if (Game.level.hasPower()) {
                Game.level.updatePower();
            }
        }
        repaint();
    }
    Boolean isLevel() {
        return (1 <= Game.gameState && Game.gameState<= 24);
    }
    class TKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (isLevel()) {
                Game.level.keyPressed(e);
            }
        }
        @Override
        public void keyReleased(KeyEvent e) {
            if (isLevel()) {
                Game.level.keyReleased(e);
            }
        }
    }
    class TMouseAdapter extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (Game.gameState == 0) {
                LevelMenu.mouseClicked(e);
            }
            else if (isLevel()) {
                Game.level.mouseClicked(e);
            }
        }
    }
}