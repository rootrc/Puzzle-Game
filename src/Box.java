class Box extends GameObject {
    final int speed = 4;
    int tileValue;
    char direction;

    Box(int[] location) {
        super(location);
        tileValue = getTileValue(location);
        switch (tileValue) {
            case 5 -> image = Images.box;
            case 6 -> image = Images.connecterWhite;
            case 7 -> image = Images.connecterBlue;
            case 8 -> image = Images.connecterRed;
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
            case 'w' -> screenLocation[1] -= speed;
            case 'a' -> screenLocation[0] -= speed;
            case 's' -> screenLocation[1] += speed;
            case 'd' -> screenLocation[0] += speed;
        }
    }

    boolean isMove() {
        return switch (direction) {
            case 'w' -> getScreenLocationY() - 16 >= screenLocation[1];
            case 'a' -> getScreenLocationX() - 16 >= screenLocation[0];
            case 's' -> getScreenLocationY() + 16 <= screenLocation[1];
            case 'd' -> getScreenLocationX() + 16 <= screenLocation[0];
            default -> false;
        };
    }

    int[] movementLocation(char direction) {
        int[] tempLocation = location.clone();
        switch (direction) {
            case 'w' -> tempLocation[1] -= 1;
            case 'd' -> tempLocation[0] += 1;
            case 's' -> tempLocation[1] += 1;
            case 'a' -> tempLocation[0] -= 1;
        }
        return new int[]{tempLocation[0], tempLocation[1]};
    }

    boolean isPushable(char direction) {
        int temp = getTileValue(movementLocation(direction));
        return !(isWall(temp) || isBox(temp));
    }

    boolean screenEqualsGridLocationX() {
        return getScreenLocationX() == screenLocation[0];
    }

    boolean screenEqualsGridLocationY() {
        return getScreenLocationY() == screenLocation[1];
    }
}
