import java.awt.Image;

class Button extends Object {
    int powerValue;
    int [] screenLocation;
    Image image;
    Button (int [] location, int powerValue) {
        super (location);
        this.screenLocation = new int [] {this.location[0] * 32 + 32, this.location[1] * 32 + 32};
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