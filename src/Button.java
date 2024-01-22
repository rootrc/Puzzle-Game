class Button extends GameObject {
    int powerValue;

    Button(int[] location, int powerValue) {
        super(location);
        this.powerValue = powerValue;
    }

    // updates button
    void update() {
        if (isBox(getTileValue())) {
            Game.getInstance().level.setPowerValueOn(powerValue);
            image = Images.buttonOn;
        } else {
            image = Images.buttonOff;
        }
    }
}   