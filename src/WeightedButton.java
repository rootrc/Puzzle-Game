import java.awt.Image;

class WeightedButton extends Object {
    int powerValue;
    boolean isPressed = false;
    int [] screenLocation;
    Image image = Images.weightedButtonOff;
    WeightedButton (int [] location, int powerValue) {
        super (location);
        this.powerValue = powerValue;
        this.screenLocation = new int [] {this.location[0] * 32 + 32, this.location[1] * 32 + 32};
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