import java.awt.Graphics2D;
import java.awt.Image;
class Object {
    int [] location;
    int [] screenLocation;
    Image image;
    Object (int [] location) {
        this.location = location;
        this.screenLocation = this.getScreenLocation();
    }
    static Boolean isWall (int tileValue) {
        return tileValue == 1 || tileValue == 2 || tileValue == 9;
    }
    static Boolean isDoor (int tileValue) {
        return tileValue == 9;
    }
    static Boolean isBlockingWall (int tileValue) {
        return tileValue == 1;
    }
    static Boolean isBox (int tileValue) {
        return tileValue == 3 || (5 <= tileValue && tileValue <= 8);
    }
    static boolean isBlocking (int tileValue, char colour) {
        if (colour == 'B') {
            return (tileValue == 3 || tileValue == 5 || tileValue == 8);
        }
        if (colour == 'R') {
            return (tileValue == 3 || tileValue == 5 || tileValue == 7);
        }
        return false;
    }
    static boolean isConnecter (int tileValue) {
        return (6 <= tileValue && tileValue % 10 <= 8);
    }
    static boolean isStar (int tileValue) {
        return tileValue == 10;
    }
    int getTileValue () {
        return Game.level.grid [this.location[1]][this.location[0]];    
    }
    static int getTileValue (int [] location) {
        return Game.level.grid [location[1]][location[0]];
    }
    int [] getScreenLocation () {
        return new int [] {this.location [0] * 32 + 32, this.location [1] * 32 + 32};
    }
    void draw (Graphics2D g2d) {
        g2d.drawImage(this.image, this.screenLocation[0] + Game.level.adjustX, this.screenLocation[1] + Game.level.adjustY, Game.panel);
    }
}
