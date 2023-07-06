import java.awt.Image;

class Box extends Object {
    int tileValue;
    Image image;
    char direction;
    int [] screenLocation;
    final int speed = 4;
    Box (int [] location) {
        super(location);
        this.tileValue = getTileValue(location);
        this.screenLocation = new int [] {this.location[0] * 32 + 32, this.location[1] * 32 + 32};
        switch (this.tileValue) {
            case 5:
                this.image = Images.box;
                break;
            case 6:
                this.image = Images.connecterWhite;
                break;
            case 7:
                this.image = Images.connecterBlue;
                break;
            case 8:
                this.image = Images.connecterRed;
                break;
        }
    }
    void movement() {
        gridMove();
        if (isMove()) {
            this.location = this.movementLocation(this.direction);
            Game.level.setGridTileValue(this.location, this.tileValue);
        }
        if (this.location [0] * 32 + 32 == this.screenLocation [0] && this.location [1] * 32 + 32 == this.screenLocation [1]) {
            Game.level.player.box = null;
            this.direction = '_';
        }
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
                this.screenLocation [1] -= this.speed;
                break;
            case 'a':
                this.screenLocation [0] -= this.speed;
                break;
            case 's':      
                this.screenLocation [1] += this.speed;
                break;
            case 'd':
                this.screenLocation [0] += this.speed;       
                break;

        }
    }
    int [] movementLocation (char direction) {
        int [] tempLocation = this.location.clone();
        switch (direction) {
            case 'w':
                tempLocation[1] -= 1;
                break;
            case 'd':
                tempLocation[0] += 1;
                break;
            case 's':
                tempLocation[1] += 1;
                break;
            case 'a':
                tempLocation[0] -= 1;
                break;
        }
        return new int [] {tempLocation [0], tempLocation [1]}; 
    }
    Boolean isPushable (char direction) {
        int temp = getTileValue(movementLocation(direction));
        return !(isWall(temp) || isBox(temp));
    }
}
