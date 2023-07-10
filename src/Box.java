class Box extends Object {
    int tileValue;
    char direction;
    final int speed = 4;
    Box (int [] location) {
        super(location);
        tileValue = getTileValue(location);
        switch (tileValue) {
            case 5:
                image = Images.box;
                break;
            case 6:
                image = Images.connecterWhite;
                break;
            case 7:
                image = Images.connecterBlue;
                break;
            case 8:
                image = Images.connecterRed;
                break;
        }
    }
    void movement() {
        gridMove();
        if (isMove()) {
            location = movementLocation(direction);
            Game.level.setGridTileValue(location, tileValue);
        }
        if (screenEqualsGridLocationX() && screenEqualsGridLocationY()) {
            Game.level.player.box = null;
            direction = '_';
        }
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
    int [] movementLocation (char direction) {
        int [] tempLocation = location.clone();
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
    boolean isPushable (char direction) {
        int temp = getTileValue(movementLocation(direction));
        return !(isWall(temp) || isBox(temp));
    }
    boolean screenEqualsGridLocationX () {
        return getScreenLocationX() == screenLocation [0];
    }
    boolean screenEqualsGridLocationY () {
        return getScreenLocationY() == screenLocation [1];
    }
}
