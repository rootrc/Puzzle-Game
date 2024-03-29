class Door extends GameObject {
    int tileValue;
    int powerValue;
    boolean isInversed;
    char direction;
    int state;

    Door(int[] location, int isInversed, char direction, int powerValue) {
        super(location);
        this.screenLocation = this.getScreenLocation();
        this.powerValue = powerValue;
        this.isInversed = isInversed == 1;
        this.direction = direction;
    }

    // updates door
    void update() {
        tileValue = getTileValue(location);
        if (isInversed) {
            if (isOn()) {
                if (image == null) {
                    state = 3;
                }
                close();
            } else {
                if (image == null) {
                    state = 0;
                }
                open();
            }
        } else {
            if (isOn()) {
                if (image == null) {
                    state = 0;
                }
                open();
            } else {
                if (image == null) {
                    state = 3;
                }
                close();
            }
        }
        image = Images.doors[getImage()][state];
    }

    // door opening animation
    private void open() {
        if (tileValue == 9 && state == 1) {
            Game.getInstance().level.setGridTileValue(location, 0);
        }
        if (state == 4) {
            state = 0;
        } else if (state != 0) {
            state--;
        }
    }

    // door closing animation
    private void close() {
        if (tileValue == 0 && state == 2) {
            Game.getInstance().level.setGridTileValue(location, 9);
        } else if (isBox(tileValue)) {
            state = 4;
        } else if (state == 4) {
            state = 0;
        }
        if (state != 3 && state != 4) {
            state++;
        }
    }

    private int getImage() {
        return switch (direction) {
            case 'W' -> 1;
            case 'S' -> 2;
            case 'E' -> 3;
            default -> 0;
        };
    }

    private boolean isOn() {
        return Game.getInstance().level.power[powerValue].isPowered;
    }

}