class Door extends Object {
    int powerValue;
    int tileValue;
    boolean isInversed;
    char direction;
    int imageState;
    Door (int [] location, int isInversed, char direction, int powerValue) {
        super (location);
        this.screenLocation = this.getScreenLocation();
        this.powerValue = powerValue;
        this.isInversed = isInversed == 1;
        this.direction = direction;;
    }
    void update () {
        this.tileValue = getTileValue(this.location);
        if (this.isInversed) {
             if (this.isOn()) {
                if (this.image == null) {
                    this.imageState = 3;
                }
                this.close();
            } else {
                if (this.image == null) {
                    this.imageState = 0;
                }
                this.open();
            }
        }
        else {
            if (this.isOn()) {
                if (this.image == null) {
                    this.imageState = 0;
                }
                this.open();
            } else {
                if (this.image == null) {
                    this.imageState = 3;
                }
                this.close();
            }
        }
        this.image = Images.doors [this.getImage()][this.imageState];
    }
    void open () {
        if (this.tileValue == 9 && this.imageState == 1) {
            Game.level.setGridTileValue(this.location, 0);
        }
        if (this.imageState == 4) {
            this.imageState = 0;
        } else if (this.imageState != 0) {
            this.imageState --;
        }
    }
    void close () {
        if (this.tileValue == 0 && this.imageState == 2) {
            Game.level.setGridTileValue(this.location, 9);
        } else if (isBox(this.tileValue)){
            this.imageState = 4;
        } else if (this.imageState == 4) {
            this.imageState = 0;
        }
        if (this.imageState != 3 && this.imageState != 4) {
            this.imageState ++;
        }
    }
    boolean isOn() {
        return Game.level.power [this.powerValue];
    }
    int getImage() {
        switch (this.direction) {
            case 'N':
                return 0;
            case 'W':
                return 1;
            case 'S':
                return 2;
            case 'E':
                return 3;                                                
        }
        return 0;
    }

}