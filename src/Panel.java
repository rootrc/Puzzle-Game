import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
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

    // Draws everything
    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        // g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        // g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        
        // Draw screen based on gameState
        if (Game.getInstance().isTitle()) {
            Game.getInstance().title.paint(g2d);
        } else if (Game.getInstance().isRules()) {
            Game.getInstance().rules.paint(g2d);
        } else if (Game.getInstance().isCredits()) {
            Game.getInstance().credits.paint(g2d);
        } else if (Game.getInstance().isMenu()) {
            Game.getInstance().menu.paint(g2d);
        } else if (Game.getInstance().isLevel() && Game.getInstance().isLoaded()) {
            Game.getInstance().level.paint(g2d);
        }
    }

    // Controls keyboard input
    class TKeyAdapter extends KeyAdapter {
        // Chosses different ways to handle keyboard input based on gameState
        @Override
        public void keyPressed(KeyEvent e) {
            if (Game.getInstance().isRules()) {
                Game.getInstance().rules.keyPressed(e);
            } else if (Game.getInstance().isCredits()) {
                Game.getInstance().credits.keyPressed(e);
            } else if (Game.getInstance().isMenu()) {
                Game.getInstance().menu.keyPressed(e);
            } if (Game.getInstance().isLevel()) {
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

    // Controls mouse input
    class TMouseAdapter extends MouseAdapter {
        @Override
        // Chosses different ways to handle mouse input based on gameState
        public void mouseClicked(MouseEvent e) {
            if (Game.getInstance().isTitle()) {
                Game.getInstance().title.mouseClicked(e);
            } else if (Game.getInstance().isRules()) {
                Game.getInstance().rules.mouseClicked(e);
            } else if (Game.getInstance().isCredits()) {
                Game.getInstance().credits.mouseClicked(e);
            } else if (Game.getInstance().isMenu()) {
                Game.getInstance().menu.mouseClicked(e);
            } else if (Game.getInstance().isLevel()) {
                Game.getInstance().level.mouseClicked(e);
            }
        }
    }
}