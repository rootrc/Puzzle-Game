import java.util.Arrays;
import java.awt.Image;

class Player extends Object {
    final int tileValue = 3;
    final Image image = Images.player;;
    char direction;
    char nextDirection;
    Box box;

    final int speed = 4;
    boolean moving = false;
    int [] screenLocation;
    Player(int [] location) {
        super(location);
        this.screenLocation = new int [] {this.location[0] * 32 + 32, this.location[1] * 32 + 32};
    }
    void update(int [] newLocation) {
        this.location = newLocation;
    }
    void movement() {
        if (this.box != null) {
            this.push();
        }
        if ((this.canMove() && this.moving) || (this.location [0] * 32 + 32 != this.screenLocation [0] || this.location [1] * 32 + 32 != this.screenLocation [1])) {
            gridMove();
        } else if (this.nextDirection != '_'){
            this.direction = this.nextDirection;
            this.nextDirection = '_';
            this.moving = true;
        }

        if (this.isMove() && this.canMove()) {
            int temp = getTileValue(this.movementLocation());
            if (isWin(temp)) {
                if (Game.gameState < 23) {
                Game.gameState ++;
                Game.loaded = false;
                LevelData.setUp();
                } else {
                    Game.gameState = 0; 
                }
            } else if (isBox(temp)) {
                    for (Box box: Game.level.boxes) {
                        if (Arrays.equals(box.location, this.movementLocation())) {
                            box.direction = this.direction;
                            this.box = box;
                            this.move();
                            break;
                        }
                    }
            } else {
                this.move();
            }
        }   
    }
    boolean canMove() {
        int temp = getTileValue(this.movementLocation());
        if (isWall(temp)) {
            return false;
        } else if (isBox(temp)){
            temp = getTileValue(this.boxMovementLocation());
            return !(isWall(temp) || isBox(temp));
        }
        return true;
    }
    boolean isMove() {
        switch (this.direction) {
            case 'w':
                return this.location [1] * 32 + 32 - 16 >= this.screenLocation [1];
            case 'a':
                return this.location [0] * 32 + 32 - 16 >= this.screenLocation [0];
            case 's':
                return this.location [1] * 32 + 32 + 16 <= this.screenLocation [1];
            case 'd':
                return this.location [0] * 32 + 32 + 16 <= this.screenLocation [0];                
        }
        return false;
    }
    void gridMove() {
        switch (this.direction) {
            case 'w':
                this.screenLocation [1] -= speed;
                break;
            case 'a':
                this.screenLocation [0] -= speed;
                break;
            case 's':      
                this.screenLocation [1] += speed;
                break;
            case 'd':
                this.screenLocation [0] += speed;       
                break;

        }
    }
    void move () {
        Game.level.setGridTileValue(this.location, 0);
        this.update(this.movementLocation());
        Game.level.setGridTileValue(this.location, this.tileValue);
    }
    void push () {
        this.box.movement();
    }
    int [] movementLocation () {
        int [] tempLocation = this.location.clone();
        switch (this.direction) {
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
        int [] tempLocation = this.location.clone();
        switch (this.direction) {
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
    static Boolean isWin (int tileValue) {
        return tileValue == 4;
    }
}