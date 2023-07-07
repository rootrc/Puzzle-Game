class Object {
    int [] location;
    Object (int [] location) {
        this.location = location;
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
}
