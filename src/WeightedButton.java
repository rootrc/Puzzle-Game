class WeightedButton extends Object {
    int powerValue;
    boolean isPressed = false;
    WeightedButton (int [] location, int powerValue) {
        super (location);
        image = Images.weightedButtonOff;
        this.powerValue = powerValue;
    }
    void updatePower () {
        if (this.isPressed) {
            Game.level.setPowerValueOn(this.powerValue);
        } else {
            if (isBox(this.getTileValue())) {
                Game.level.setPowerValueOn(this.powerValue);
                this.isPressed = true;
                this.image = Images.weightedButtonOn;
            }
        }
    }
}   