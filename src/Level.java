import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Level {
    int num;
    String name;

    int [][] grid;
    Player player;
    Box [] boxes;
    boolean [] power;
    Button [] buttons;
    WeightedButton [] weightedButtons; 
    Transmitter [] transmitters;
    Receiver [] receivers;
    Door [] doors;
    Star star;
    boolean win;

    ArrayList <ScreenLaser> screenLasers = new ArrayList <>();;
    Image image;
    int adjustX;
    int adjustY;
    void paint(Graphics2D g2d) {
        if (!win) {
            g2d.setStroke(new BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("SansSerif", Font.BOLD, 100));
            g2d.drawString(Integer.toString(num), 24, 92);
            g2d.setFont(new Font("SansSerif", Font.PLAIN, 64));
            if (num < 10) {
                g2d.drawString(name, 96, 84);
            } else {
                g2d.drawString(name, 152, 84);
            }
            g2d.drawRect(808, 12, 88, 88);
            g2d.drawImage(Images.restartIcon, 820, 24, Game.panel);
            g2d.drawRect(912, 12, 88, 88);
            g2d.drawImage(Images.menuIcon, 924, 24, Game.panel);
            g2d.drawImage(image, adjustX, adjustY, Game.panel);
            for (WeightedButton weightedButton: weightedButtons) {
                weightedButton.draw(g2d);
            }
            for (Button button: buttons) {
                button.draw(g2d);
            }
            if (star != null) {
                if (!star.collected) {
                    star.draw(g2d);
                }
            }
            g2d.setStroke(new BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
            HashSet <List<Integer>> blueSet = new HashSet <>();
            HashSet <List<Integer>> redSet = new HashSet <>();
            for (ScreenLaser screenLaser: screenLasers) {
                if (screenLaser.colour == 'B') {
                    if (redSet.contains(screenLaser.startAndEnd) || redSet.contains(screenLaser.endAndStart)) {
                        g2d.setColor(Color.MAGENTA);
                    } else {
                        g2d.setColor(Color.BLUE);
                    }
                    blueSet.add(screenLaser.startAndEnd);
                    blueSet.add(screenLaser.endAndStart);
                } else if (screenLaser.colour == 'R') {
                    if (blueSet.contains(screenLaser.startAndEnd) || blueSet.contains(screenLaser.endAndStart)) {
                        g2d.setColor(Color.MAGENTA);
                    } else {
                        g2d.setColor(Color.RED);
                    }
                    redSet.add(screenLaser.startAndEnd);
                    redSet.add(screenLaser.endAndStart);
                }
                g2d.draw(screenLaser.line);
            }
            screenLasers.clear();
            for (Receiver receiver: receivers) {
                if (receiver.isOn) {
                    receiver.image = Images.receiversOn[receiver.directionImage];
                } else {
                    receiver.image = Images.receiversOff[receiver.directionImage];
                }
                receiver.draw(g2d);
                receiver.isOn = false;
            }
            player.draw(g2d);
            for (Box box: boxes) {
                box.draw(g2d);
            }
            for (Door door: doors) {
                door.draw(g2d);
            }
        } else {
            screenLasers.clear();
            g2d.setStroke(new BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("TimesRoman", Font.BOLD, 100));
            g2d.drawRect(296, 512, 88, 88);
            g2d.drawImage(Images.menuIcon, 308, 524, Game.panel);
            g2d.drawRect(460, 512, 88, 88);
            g2d.drawImage(Images.restartIcon, 472, 524, Game.panel);
            if (num != 24) {
                g2d.drawRect(624, 512, 88, 88);
                g2d.drawImage(Images.nextIcon, 636, 524, Game.panel);
            }
        }
    }
    void process() {
        if (!win) {
            player.movement();
            updatePower();
        }
    }
    void updatePower() {
        resetPower();
        checkWeightedButton();
        checkButtons();
        checkLasers();
        updateDoors();
    }
    void resetPower() {
        power = new boolean[power.length];
    }
    void checkWeightedButton() {
        for (WeightedButton weightedButton: weightedButtons) {
            weightedButton.updatePower();
        }
    }
    void checkButtons() {
        for (Button button: buttons) {
            button.updatePower();
        }
    }
    void updateDoors () {
        for (Door door: doors) {
            door.update();
        }
    }
    void checkLasers () {
        Queue <Laser> lasers = new LinkedList<>();
        updateTransmitterLasers(lasers);
        updateConnecterLasers(lasers);
    }
    void updateTransmitterLasers(Queue <Laser> lasers) {
        for (Transmitter transmitter: transmitters) {
            transmitter.newLaser();
            screenLasers.add(new ScreenLaser(transmitter.screenLocation, transmitter.laser.shootTransmitterLaser(lasers), transmitter.colour));
        }
    }
    void updateConnecterLasers(Queue <Laser> lasers) {
        while (!lasers.isEmpty()) {
            for (int i = 0; i < lasers.size(); i++) {
                Laser laser = lasers.poll();
                List <int[]> temp = laser.shootConnecterLaser(lasers);
                for (int j = 0; j < temp.size(); j++) {
                    screenLasers.add(new ScreenLaser(new int [] {laser.location[0] * 32 + 48, laser.location[1] * 32 + 48}, temp.get(j), laser.colour));
                }
            }
        }
    }
    void keyPressed(KeyEvent e) {
        if (!win) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
                if (player.location [0] * 32 + 32 == player.screenLocation [0]) {
                    player.direction = 'w';
                    player.moving = true;
                } else {
                    player.nextDirection = 'w';
                }
            }
            if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
                if (player.location [1] * 32 + 32 == player.screenLocation [1]) {
                    player.direction = 'a';
                    player.moving = true;
                } else {
                    player.nextDirection = 'a';
                }
            }
            if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
                if (player.location [0] * 32 + 32 == player.screenLocation [0]) {
                    player.direction = 's';
                    player.moving = true;
                } else {
                    player.nextDirection = 's';
                }
            }
            if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
                if (player.location [1] * 32 + 32 == player.screenLocation [1]) {
                    player.direction = 'd';
                    player.moving = true;     
                } else {
                    player.nextDirection = 'd';
                }
            }
        }
    }
    void keyReleased(KeyEvent e) {
        if (!win) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
                player.moving = false;
                if (player.nextDirection == 'w') {
                    player.nextDirection = '_';
                }
            }
            if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
                player.moving = false;
                if (player.nextDirection == 'a') {
                    player.nextDirection = '_';
                }
            }
            if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
                player.moving = false;
                if (player.nextDirection == 's') {
                    player.nextDirection = '_';
                }            
            }
            if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
                player.moving = false;
                if (player.nextDirection == 'd') {
                    player.nextDirection = '_';
                }
            }
        }
    }
    void mouseClicked(MouseEvent e) {
        if (!win) {
            if (908 < e.getX() && e.getX() < 1004 && 8 < e.getY() && e.getY() < 104) {
                try {
                    Thread.sleep(50);
                } catch (Exception execption) {

                }
                Game.gameState = 0; 
            } else if (804 < e.getX() && e.getX() < 900 && 8 < e.getY() && e.getY() < 104) {
                Game.loaded = false;
                try {
                    Thread.sleep(50);
                } catch (Exception execption) {

                }
                Game.loadLevel();
            }
        } else {
            if (292 < e.getX() && e.getX() < 388 && 520 < e.getY() && e.getY() < 616) {
                try {
                    Thread.sleep(50);
                } catch (Exception execption) {

                }
                Game.gameState = 0; 
            } else if (456 < e.getX() && e.getX() < 552 && 520 < e.getY() && e.getY() < 616) {
                try {
                    Thread.sleep(50);
                } catch (Exception execption) {

                }
                Game.loadLevel();
            } else if (num != 24 && 620 < e.getX() && e.getX() < 716 && 520 < e.getY() && e.getY() < 616) {
                try {
                    Thread.sleep(50);
                } catch (Exception execption) {

                }
                Game.gameState ++;
                Game.loadLevel();
            }
        }
    }
    void setGridTileValue (int [] location, int tileValue) {
        grid [location [1]][location [0]] = tileValue;
    }
    void setPowerValueOn(int powerNum) {
        power [powerNum] = true;
    }
}