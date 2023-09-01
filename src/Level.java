import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Queue;
import java.util.*;

class Level {
    int num;
    String name;

    int[][] grid;
    Player player;
    Box[] boxes;
    Wire[] power;
    Button[] buttons;
    WeightedButton[] weightedButtons;
    Transmitter[] transmitters;
    Receiver[] receivers;
    Door[] doors;
    Star star;
    ArrayList<ScreenLaser> screenLasers = new ArrayList<>();
    boolean win;

    Image image;
    int adjustX;
    int adjustY;

    void paint(Graphics2D g2d) {
        if (win) {
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
            return;
        }
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
        for (Wire wire : power) {
            if (wire.isPowered) {
                wire.draw(g2d);
            }
        }
        for (WeightedButton weightedButton : weightedButtons) {
            weightedButton.draw(g2d);
        }
        for (Button button : buttons) {
            button.draw(g2d);
        }
        if (star != null) {
            if (!star.collected) {
                star.draw(g2d);
            }
        }
        g2d.setStroke(new BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
        HashSet<List<Integer>> blueSet = new HashSet<>();
        HashSet<List<Integer>> redSet = new HashSet<>();
        for (ScreenLaser screenLaser : screenLasers) {
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
        for (Receiver receiver : receivers) {
            if (receiver.isOn) {
                receiver.image = Images.receiversOn[receiver.directionImage];
            } else {
                receiver.image = Images.receiversOff[receiver.directionImage];
            }
            receiver.draw(g2d);
            receiver.isOn = false;
        }
        player.draw(g2d);
        for (Box box : boxes) {
            box.draw(g2d);
        }
        for (Door door : doors) {
            door.draw(g2d);
        }
    }

    void process() {
        if (win) {
            return;
        }
        int[] oldLocation = player.location.clone();
        player.movement();
        updatePower();
        if (oldLocation[0] != player.location[0] || oldLocation[1] != player.location[1]) {
            Level copy = this.copy();
            Game.stack.addLast(copy.copy());
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
        for (Wire wire : power) {
            wire.isPowered = false;
        }
    }

    void checkWeightedButton() {
        for (WeightedButton weightedButton : weightedButtons) {
            weightedButton.updatePower();
        }
    }

    void checkButtons() {
        for (Button button : buttons) {
            button.updatePower();
        }
    }

    void updateDoors() {
        for (Door door : doors) {
            door.update();
        }
    }

    void checkLasers() {
        Queue<Laser> lasers = new LinkedList<>();
        updateTransmitterLasers(lasers);
        updateConnectorLasers(lasers);
    }

    void updateTransmitterLasers(Queue<Laser> lasers) {
        for (Transmitter transmitter : transmitters) {
            transmitter.newLaser();
            screenLasers.add(new ScreenLaser(transmitter.screenLocation, transmitter.laser.shootTransmitterLaser(lasers), transmitter.colour));
        }
    }

    void updateConnectorLasers(Queue<Laser> lasers) {
        while (!lasers.isEmpty()) {
            for (int i = 0; i < lasers.size(); i++) {
                Laser laser = lasers.poll();
                List<int[]> temp = laser.shootConnecterLaser(lasers);
                for (int[] ints : temp) {
                    screenLasers.add(new ScreenLaser(new int[]{laser.location[0] * 32 + 48, laser.location[1] * 32 + 48}, ints, laser.colour));
                }
            }
        }
    }

    void keyPressed(KeyEvent e) {
        if (win) {
            return;
        }
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
            if (player.location[0] * 32 + 32 == player.screenLocation[0]) {
                player.direction = 'w';
                player.moving = true;
            } else {
                player.nextDirection = 'w';
            }
        }
        if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
            if (player.location[1] * 32 + 32 == player.screenLocation[1]) {
                player.direction = 'a';
                player.moving = true;
            } else {
                player.nextDirection = 'a';
            }
        }
        if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
            if (player.location[0] * 32 + 32 == player.screenLocation[0]) {
                player.direction = 's';
                player.moving = true;
            } else {
                player.nextDirection = 's';
            }
        }
        if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
            if (player.location[1] * 32 + 32 == player.screenLocation[1]) {
                player.direction = 'd';
                player.moving = true;
            } else {
                player.nextDirection = 'd';
            }
        }
        if (key == KeyEvent.VK_BACK_SPACE) {
            undoMove();
        }
    }

    void keyReleased(KeyEvent e) {
        if (win) {
            return;
        }
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

    void mouseClicked(MouseEvent e) {
        if (win) {
            if (292 < e.getX() && e.getX() < 388 && 520 < e.getY() && e.getY() < 616) {
                try {
                    Thread.sleep(50);
                } catch (Exception ignored) {
                }
                Game.gameState = 0;
            } else if (456 < e.getX() && e.getX() < 552 && 520 < e.getY() && e.getY() < 616) {
                try {
                    Thread.sleep(50);
                } catch (Exception ignored) {
                }
                Game.loadLevel();
            } else if (num != 24 && 620 < e.getX() && e.getX() < 716 && 520 < e.getY() && e.getY() < 616) {
                try {
                    Thread.sleep(50);
                } catch (Exception ignored) {
                }
                Game.gameState++;
                Game.loadLevel();
            }
        } else {
            if (908 < e.getX() && e.getX() < 1004 && 8 < e.getY() && e.getY() < 104) {
                try {
                    Thread.sleep(50);
                } catch (Exception ignored) {
                }
                Game.gameState = 0;
            } else if (804 < e.getX() && e.getX() < 900 && 8 < e.getY() && e.getY() < 104) {
                Game.loaded = false;
                try {
                    Thread.sleep(50);
                } catch (Exception ignored) {
                }
                Game.loadLevel();
            }
        }
    }

    void undoMove() {
        if (Game.stack.size() < 2) {
            return;
        }
        Game.stack.pollLast();
        assert Game.stack.peekLast() != null;
        Level copy = Game.stack.peekLast().copy();
        if (copy.player.box != null) {
            for (Box box : copy.boxes) {
                if (Arrays.equals(box.location, copy.player.box.location)) {
                    switch (copy.player.box.direction) {
                        case 'w' -> {
                            box.location[1]--;
                            box.screenLocation[1] -= 32;
                        }
                        case 'a' -> {
                            box.location[0]--;
                            box.screenLocation[0] -= 32;
                        }
                        case 's' -> {
                            box.location[1]++;
                            box.screenLocation[1] += 32;
                        }
                        case 'd' -> {
                            box.location[0]++;
                            box.screenLocation[0] += 32;
                        }
                    }
                    copy.grid[box.location[1]][box.location[0]] = copy.player.box.tileValue;
                }
            }
        }
        Game.level = copy;
    }

    Level copy() {
        Level copy = new Level();
        copy.num = num;
        copy.name = name;
        copy.grid = new int[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            copy.grid[i] = grid[i].clone();
        }
        copy.player = new Player(player.location.clone());
        if (player.box != null) {
            copy.player.box = new Box(player.box.location.clone());
            copy.player.box.tileValue = player.box.tileValue;
            copy.player.box.direction = player.box.direction;
        }
        copy.boxes = new Box[boxes.length];
        for (int i = 0; i < boxes.length; i++) {
            copy.boxes[i] = new Box(boxes[i].location.clone());
            copy.boxes[i].tileValue = boxes[i].tileValue;
            copy.boxes[i].image = boxes[i].image;
        }
        copy.power = power;
        copy.buttons = buttons;
        copy.weightedButtons = new WeightedButton[weightedButtons.length];
        for (int i = 0; i < weightedButtons.length; i++) {
            copy.weightedButtons[i] = new WeightedButton(weightedButtons[i].location, weightedButtons[i].powerValue);
            copy.weightedButtons[i].isPressed = weightedButtons[i].isPressed;
            copy.weightedButtons[i].image = weightedButtons[i].image;
        }
        copy.transmitters = transmitters;
        copy.receivers = receivers;
        copy.doors = doors;
        copy.star = star;
        copy.win = win;
        copy.image = image;
        copy.adjustX = adjustX;
        copy.adjustY = adjustY;
        return copy;
    }

    void setGridTileValue(int[] location, int tileValue) {
        grid[location[1]][location[0]] = tileValue;
    }

    void setPowerValueOn(int powerNum) {
        power[powerNum].isPowered = true;
    }
}