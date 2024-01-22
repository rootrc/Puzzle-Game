import java.util.Arrays;

class Player extends Box {
    final int tileValue = 3;
    char direction;
    char nextDirection;
    boolean moving = false;
    boolean win = false;
    Box box;

    Player(int[] location) {
        super(location);
        this.image = Images.player;
    }

    // moves player
    void movement() {
        // if player has a box, push it
        if (box != null) {
            push();
        }
        if ((canMove() && moving) || !(screenEqualsGridLocationX() && screenEqualsGridLocationY())) {
            screenMove();
        // for better movement control
        } else if (nextDirection != '_') {
            direction = nextDirection;
            nextDirection = '_';
            moving = true;
        }
        if (isMoving() && canMove()) {
            int temp = getTileValue(movementLocation());
            // if next location is win tile, win
            if (isWin(temp)) {
                win = true;
            // if next locatino is a star, collect it
            } else if (isStar(temp)) {
                Game.getInstance().level.star.collected = true;
                switch (Game.getInstance().level.num) {
                    case 11 -> Game.getInstance().menu.starsCollected[0] = true;
                    case 16 -> Game.getInstance().menu.starsCollected[1] = true;
                    case 21 -> Game.getInstance().menu.starsCollected[2] = true;
                }
                try {
                    Thread.sleep(200);
                } catch (Exception ignored) {
                }
            // if next location is a box, it's set to be the player's
            } else if (isBox(temp)) {
                for (Box box : Game.getInstance().level.boxes) {
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
            if ((screenEqualsGridLocationX() && screenEqualsGridLocationY())) {
                try {
                    Thread.sleep(100);
                } catch (Exception ignored) {
                }
                Game.getInstance().level.win = true;
            }
        }
    }

    // checks if player can move
    private boolean canMove() {
        int temp = getTileValue(movementLocation());
        if (isWall(temp)) {
            return false;
        } else if (isBox(temp)) {
            temp = getTileValue(boxMovementLocation());
            return !(isWall(temp) || isBox(temp));
        }
        return true;
    }

    // checks if should continue moving
    private boolean isMoving() {
        return switch (direction) {
            case 'w' -> getScreenLocationY() - 16 >= screenLocation[1];
            case 'a' -> getScreenLocationX() - 16 >= screenLocation[0];
            case 's' -> getScreenLocationY() + 16 <= screenLocation[1];
            case 'd' -> getScreenLocationX() + 16 <= screenLocation[0];
            default -> false;
        };
    }

    // move screen location
    private void screenMove() {
        switch (direction) {
            case 'a' -> screenLocation[0] -= SPEED;
            case 's' -> screenLocation[1] += SPEED;
            case 'd' -> screenLocation[0] += SPEED;
            case 'w' -> screenLocation[1] -= SPEED;
        }
    }

    private void move() {
        Game.getInstance().level.setGridTileValue(location, 0);
        updateLocation();
        Game.getInstance().level.setGridTileValue(location, tileValue);
    }

    private void push() {
        box.movement();
    }

    private int[] movementLocation() {
        int[] tempLocation = location.clone();
        switch (direction) {
            case 'w' -> tempLocation[1]--;
            case 'a' -> tempLocation[0]--;
            case 's' -> tempLocation[1]++;
            case 'd' -> tempLocation[0]++;
        }
        return new int[]{tempLocation[0], tempLocation[1]};
    }

    private int[] boxMovementLocation() {
        int[] tempLocation = location.clone();
        switch (direction) {
            case 'w' -> tempLocation[1] -= 2;
            case 'a' -> tempLocation[0] -= 2;
            case 's' -> tempLocation[1] += 2;
            case 'd' -> tempLocation[0] += 2;
        }
        return new int[]{tempLocation[0], tempLocation[1]};
    }

    private void updateLocation() {
        location = movementLocation();
    }
}