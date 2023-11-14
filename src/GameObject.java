import java.awt.*;

class GameObject {
    int[] location;
    int[] screenLocation;
    Image image;

    GameObject(int[] location) {
        this.location = location;
        this.screenLocation = this.getScreenLocation();
    }

    static Boolean isWall(int tileValue) {
        return tileValue == 1 || tileValue == 2 || tileValue == 9;
    }

    static Boolean isDoor(int tileValue) {
        return tileValue == 9;
    }

    static Boolean isBlockingWall(int tileValue) {
        return tileValue == 1;
    }

    static Boolean isBox(int tileValue) {
        return tileValue == 3 || (5 <= tileValue && tileValue <= 8);
    }

    static boolean isConnector(int tileValue) {
        return (6 <= tileValue && tileValue % 10 <= 8);
    }

    static Boolean isWin(int tileValue) {
        return tileValue == 4;
    }

    static boolean isStar(int tileValue) {
        return tileValue == 10;
    }

    static int getTileValue(int[] location) {
        return Game.getInstance().level.grid[location[1]][location[0]];
    }

    int getTileValue() {
        return Game.getInstance().level.grid[location[1]][location[0]];
    }

    int getScreenLocationX() {
        return location[0] * 32 + 32;
    }

    int getScreenLocationY() {
        return location[1] * 32 + 32;
    }

    int[] getScreenLocation() {
        return new int[]{getScreenLocationX(), getScreenLocationY()};
    }

    void draw(Graphics2D g2d) {
        g2d.drawImage(image, screenLocation[0] + Game.getInstance().level.adjustX, screenLocation[1] + Game.getInstance().level.adjustY, Game.getInstance().panel);
    }
}
