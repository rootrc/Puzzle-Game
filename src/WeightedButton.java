class WeightedButton extends GameObject {
    int powerValue;
    boolean isPressed = false;

    WeightedButton(int[] location, int powerValue) {
        super(location);
        this.powerValue = powerValue;
        image = Images.weightedButtonOff;
    }

    void updatePower() {
        if (isPressed) {
            Game.level.setPowerValueOn(powerValue);
        } else {
            if (isBox(getTileValue())) {
                Game.level.setPowerValueOn(powerValue);
                isPressed = true;
                image = Images.weightedButtonOn;
            }
        }
    }
}   