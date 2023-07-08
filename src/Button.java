class Button extends Object {
    int powerValue;
    Button (int [] location, int powerValue) {
        super (location);
        this.powerValue = powerValue;
    }
    void updatePower () {
        if (isBox(this.getTileValue())) {
            Game.level.setPowerValueOn(this.powerValue);
            this.image = Images.buttonOn;
        } else {
            this.image = Images.buttonOff;
        }
    }
}   