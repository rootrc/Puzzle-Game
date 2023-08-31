import java.util.Arrays;

class Player extends Box {
    final int tileValue = 3;
    char direction;
    char nextDirection;
    boolean moving = false;
    boolean win = false;
    Box box;
    Player(int [] location) {
        super(location);
        this.image = Images.player;
    }
    void movement() {
        if (box != null) {
            push();
        }
        if ((canMove() && moving) || !(screenEqualsGridLocationX () && screenEqualsGridLocationY ())) {
            gridMove();
        } else if (nextDirection != '_'){
            direction = nextDirection;
            nextDirection = '_';
            moving = true;
        }
        if (isMove() && canMove()) {
            int temp = getTileValue(movementLocation());
            if (isWin(temp)) {
                win = true;
            } else if (isStar(temp)) {
                Game.level.star.collected = true;
                switch (Game.level.num) {
                    case 11:
                        Game.menu.starsCollected[0] = true;
                        break;
                    case 16:
                        Game.menu.starsCollected[1] = true;
                        break;
                    case 21:
                        Game.menu.starsCollected[2] = true;
                        break;
                }
                try {
                    Thread.sleep(200);
                } catch (Exception exception) {}   
            } else if (isBox(temp)) {
                for (Box box: Game.level.boxes) {
                    if (Arrays.equals(box.location, movementLocation())) {
                        box.direction = direction;
                        this.box = box;
                        break;
                    }
                }
            }
            move();
        }
        if (win) {
            if ((screenEqualsGridLocationX () && screenEqualsGridLocationY ())) {
                try {
                    Thread.sleep(100);
                } catch (Exception exception) {}
                Game.level.win = true;
            }
        }
    }
    boolean canMove() {
        int temp = getTileValue(movementLocation());
        if (isWall(temp)) {
            return false;
        } else if (isBox(temp)){
            temp = getTileValue(boxMovementLocation());
            return !(isWall(temp) || isBox(temp));
        }
        return true;
    }
    boolean isMove() {
        switch (direction) {
            case 'w':
                return getScreenLocationY() - 16 >= screenLocation [1];
            case 'a':
                return getScreenLocationX() - 16 >= screenLocation [0];
            case 's':
                return getScreenLocationY() + 16 <= screenLocation [1];
            case 'd':
                return getScreenLocationX() + 16 <= screenLocation [0];                
        }
        return false;
    }
    void gridMove() {
        switch (direction) {
            case 'w':
                screenLocation [1] -= speed;
                break;
            case 'a':
                screenLocation [0] -= speed;
                break;
            case 's':      
                screenLocation [1] += speed;
                break;
            case 'd':
                screenLocation [0] += speed;       
                break;
        }
    }
    void move () {
        Game.level.setGridTileValue(location, 0);
        updateLocation();
        Game.level.setGridTileValue(location, tileValue);
    }
    void push () {
        box.movement();
    }
    int [] movementLocation () {
        int [] tempLocation = location.clone();
        switch (direction) {
            case 'w':
                tempLocation[1] --;
                break;
            case 'a':
                tempLocation[0] --;
                break;                
            case 's':
                tempLocation[1] ++;
                break;
            case 'd':
                tempLocation[0] ++;
                break;
        }
        return new int [] {tempLocation [0], tempLocation [1]}; 
    }
    int [] boxMovementLocation () {
        int [] tempLocation = location.clone();
        switch (direction) {
            case 'w':
                tempLocation[1] -= 2;
                break;
            case 'a':
                tempLocation[0] -= 2;
                break;                
            case 's':
                tempLocation[1] += 2;
                break;
            case 'd':
                tempLocation[0] += 2;
                break;
        }
        return new int [] {tempLocation [0], tempLocation [1]}; 
    }
    void updateLocation() {
        location = movementLocation();
    }
}