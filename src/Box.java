class Box extends GameObject {
    final int SPEED = 4;
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
            Game.getInstance().level.setGridTileValue(location, tileValue);
        }
        if (screenEqualsGridLocationX() && screenEqualsGridLocationY()) {
            Game.getInstance().level.player.box = null;
            direction = '_';
        }
    }

    private void gridMove() {
        switch (direction) {
            case 'w' -> screenLocation[1] -= SPEED;
            case 'a' -> screenLocation[0] -= SPEED;
            case 's' -> screenLocation[1] += SPEED;
            case 'd' -> screenLocation[0] += SPEED;
        }
    }

    private boolean isMove() {
        return switch (direction) {
            case 'w' -> getScreenLocationY() - 16 >= screenLocation[1];
            case 'a' -> getScreenLocationX() - 16 >= screenLocation[0];
            case 's' -> getScreenLocationY() + 16 <= screenLocation[1];
            case 'd' -> getScreenLocationX() + 16 <= screenLocation[0];
            default -> false;
        };
    }

    private int[] movementLocation(char direction) {
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
