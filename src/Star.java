import java.awt.Image;

class Star extends Object {
    int [] screenLocation;
    boolean collected = false;
    Image image = Images.star;
    Star (int [] location) {
        super(location);
        screenLocation = new int [] {location [0] * 32 + 32, location [1] * 32 + 32};
    }
}
