import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.awt.Font;
import java.util.Queue;
import java.util.LinkedList;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.Image;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;

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
    
    ArrayList <ScreenLaser> screenLasers = new ArrayList <>();;
    Image image;
    int adjustX;
    int adjustY;
    void updatePower() {
        this.resetPower();
        this.checkWeightedButton();
        this.checkButtons();
        this.checkLasers();
        this.updateDoors();
    }
    Boolean hasPower () {
        return this.power != null;
    }
    void resetPower() {
        for (int j = 0; j < this.power.length; j++) {
            this.power [j] = false;
        }
    }
    void checkWeightedButton() {
        if (this.weightedButtons != null) {
            for (WeightedButton weightedButton: this.weightedButtons) {
                weightedButton.updatePower();
            }
        }
    }
    void checkButtons() {
        if (this.buttons != null) {
            for (Button button: this.buttons) {
                button.updatePower();
            }
        }
    }
    void updateDoors () {
        if (this.doors != null) {
            for (Door door: this.doors) {
                door.update();
            }
        }
    }
    void checkLasers () {
        if (this.transmitters != null) {
            Queue <Laser> lasers = new LinkedList<>();
            updateTransmitterLasers(lasers);
            updateConnecterLasers(lasers);
        }
    }
    void updateTransmitterLasers(Queue <Laser> lasers) {
        for (Transmitter transmitter: this.transmitters) {
            transmitter.newLaser();
            this.screenLasers.add(new ScreenLaser(transmitter.screenLocation, transmitter.laser.shootTransmitterLaser(lasers), transmitter.colour));
        }
    }
    void updateConnecterLasers(Queue <Laser> lasers) {
        while (!lasers.isEmpty()) {
            for (int i = 0; i < lasers.size(); i++) {
                Laser laser = lasers.poll();
                List <int[]> temp = laser.shootConnecterLaser(lasers);
                for (int j = 0; j < temp.size(); j++) {
                    this.screenLasers.add(new ScreenLaser(new int [] {laser.location[0] * 32 + 48, laser.location[1] * 32 + 48}, temp.get(j), laser.colour));
                }
            }
        }
    }
    void setGridTileValue (int [] location, int tileValue) {
         this.grid [location [1]][location [0]] = tileValue;
    }
    void setPowerValueOn(int powerNum) {
        this.power [powerNum] = true;
    }
    void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W) {
            if (this.player.location [0] * 32 + 32 == this.player.screenLocation [0]) {
                this.player.direction = 'w';
                this.player.moving = true;
            } else {
                this.player.nextDirection = 'w';
            }
        }
        if (key == KeyEvent.VK_A) {
            if (this.player.location [1] * 32 + 32 == this.player.screenLocation [1]) {
                this.player.direction = 'a';
                this.player.moving = true;
            } else {
                this.player.nextDirection = 'a';
            }
        }
        if (key == KeyEvent.VK_S) {
            if (this.player.location [0] * 32 + 32 == this.player.screenLocation [0]) {
                this.player.direction = 's';
                this.player.moving = true;
            } else {
                this.player.nextDirection = 's';
            }
        }
        if (key == KeyEvent.VK_D) {
            if (this.player.location [1] * 32 + 32 == this.player.screenLocation [1]) {
                this.player.direction = 'd';
                this.player.moving = true;     
            } else {
                this.player.nextDirection = 'd';
            }
        }
    }
    void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
            this.player.moving = false;
            if (this.player.nextDirection == 'w') {
                this.player.nextDirection = '_';
            }
        }
        if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
            this.player.moving = false;
            if (this.player.nextDirection == 'a') {
                this.player.nextDirection = '_';
            }
        }
        if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
            this.player.moving = false;
            if (this.player.nextDirection == 's') {
                this.player.nextDirection = '_';
            }            
        }
        if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
            this.player.moving = false;
            if (this.player.nextDirection == 'd') {
                this.player.nextDirection = '_';
            }
        }
    }
    void mouseClicked(MouseEvent e) {
        if (908 < e.getX() && e.getX() < 1004 && 8 < e.getY() && e.getY() < 104) {
            Game.gameState = 0; 
        }
        if (804 < e.getX() && e.getX() < 900 && 8 < e.getY() && e.getY() < 104) {
            Game.loaded = false;
            LevelData.setUp(); 
        }
    }
    void paint(Graphics2D g2d) {
        g2d.setStroke(new BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("TimesRoman", Font.BOLD, 100));
        g2d.drawString(Integer.toString(this.num), 24, 92);
        g2d.setFont(new Font("TimesRoman", Font.PLAIN, 64));
        if (this.num < 10) {
            g2d.drawString(this.name, 96, 84);
        } else {
            g2d.drawString(this.name, 152, 84);
        }
        g2d.drawRect(808, 12, 88, 88);
        g2d.drawImage(Images.restartIcon, 820, 24, Game.panel);
        g2d.drawRect(912, 12, 88, 88);
        g2d.drawImage(Images.menuIcon, 924, 24, Game.panel);
        g2d.drawImage(Game.level.image, Game.level.adjustX, Game.level.adjustY, Game.panel);
        for (WeightedButton weightedButton: Game.level.weightedButtons) {
            g2d.drawImage(weightedButton.image, weightedButton.screenLocation[0] + Game.level.adjustX, weightedButton.screenLocation[1] + Game.level.adjustY, Game.panel);
        }
        for (Button button: Game.level.buttons) {
            g2d.drawImage(button.image, button.screenLocation[0] + Game.level.adjustX, button.screenLocation[1] + Game.level.adjustY, Game.panel);
        }
        g2d.setStroke(new BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
        HashSet <List<Integer>> blueSet = new HashSet <>();
        HashSet <List<Integer>> redSet = new HashSet <>();
        for (ScreenLaser screenLaser: Game.level.screenLasers) {
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
        Game.level.screenLasers.clear();
        for (Receiver receiver: Game.level.receivers) {
            if (receiver.isOn) {
                receiver.image = Images.receiversOn[receiver.directionImage];
            } else {
                receiver.image = Images.receiversOff[receiver.directionImage];
            }
            g2d.drawImage(receiver.image, receiver.screenLocation[0] + Game.level.adjustX, receiver.screenLocation[1] + Game.level.adjustY, Game.panel);
            receiver.isOn = false;
        }
        g2d.drawImage(Game.level.player.image, Game.level.player.screenLocation[0] + Game.level.adjustX, Game.level.player.screenLocation[1] + Game.level.adjustY, Game.panel);
        for (Box box: Game.level.boxes) {
            g2d.drawImage(box.image, box.screenLocation[0] + Game.level.adjustX, box.screenLocation[1] + Game.level.adjustY, Game.panel);
        }
        for (Door door: Game.level.doors) {
            g2d.drawImage(door.image, door.screenLocation[0] + Game.level.adjustX, door.screenLocation[1] + Game.level.adjustY, Game.panel);
        }
    }
}