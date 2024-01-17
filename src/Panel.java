import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

class Panel extends JPanel {
    Panel() {
        super();
        addKeyListener(new TKeyAdapter());
        addMouseListener(new TMouseAdapter());
        setBackground(Color.white);
        setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
        Toolkit.getDefaultToolkit().sync();
    }

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        // g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        // g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        if (Game.getInstance().isTitle()) {
            Game.getInstance().title.paint(g2d);
        } if (Game.getInstance().isMenu()) {
            Game.getInstance().menu.paint(g2d);
        } else if (Game.getInstance().isLevel() && Game.getInstance().isLoaded()) {
            Game.getInstance().level.paint(g2d);
        }
    }

    class TKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (Game.getInstance().isLevel()) {
                Game.getInstance().level.keyPressed(e);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (Game.getInstance().isLevel()) {
                Game.getInstance().level.keyReleased(e);
            }
        }
    }

    class TMouseAdapter extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (Game.getInstance().isTitle()) {
                Game.getInstance().title.mouseClicked(e);
            } else if (Game.getInstance().isMenu()) {
                Game.getInstance().menu.mouseClicked(e);
            } else if (Game.getInstance().isLevel()) {
                Game.getInstance().level.mouseClicked(e);
            }
        }
    }
}