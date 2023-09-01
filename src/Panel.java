import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Panel extends JPanel implements ActionListener {
    Timer timer;

    Panel() {
        super();
        addKeyListener(new TKeyAdapter());
        addMouseListener(new TMouseAdapter());
        setBackground(Color.white);
        setFocusable(true);
        timer = new Timer(20, this);
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
        if (Game.isMenu()) {
            Game.menu.paint(g2d);
        }
        if (Game.isLevel() && Game.isLoaded()) {
            Game.level.paint(g2d);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (Game.isLevel() && Game.isLoaded()) {
            Game.level.process();
        }
        repaint();
    }

    static class TKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (Game.isLevel()) {
                Game.level.keyPressed(e);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (Game.isLevel()) {
                Game.level.keyReleased(e);
            }
        }
    }

    static class TMouseAdapter extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (Game.isMenu()) {
                Game.menu.mouseClicked(e);
            } else if (Game.isLevel()) {
                Game.level.mouseClicked(e);
            }
        }
    }
}