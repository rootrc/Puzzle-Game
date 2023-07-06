import java.util.Arrays;
import java.util.Queue;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

class Laser extends Object {
    HashSet <List<Integer>> encounteredConnecters;
    int tileValue;
    String direction;
    char colour;
    Laser (int [] location, String direction, char colour, HashSet <List<Integer>> encounteredConnecters) {
        super(location);
        this.direction = direction;
        this.colour = colour;
        this.encounteredConnecters = encounteredConnecters;
    }
    void update() {
        this.tileValue = this.getTileValue();
    }
    int [] shootTransmitterLaser(Queue <Laser> lasers) {
        if (this.direction.length() == 2) {
            this.moveLaser();
        }
        while (true) {
            update();
            if (isBlockingWall(this.tileValue)) {
                return this.endWallLocation();
            } else if (isDoor(this.tileValue)) {
                return this.endDoorLocation();
            } else if (isBlocking(this.tileValue, this.colour)) {
                int [] screenLocation = new int [2];
                if (this.tileValue == 3) {
                    screenLocation = Game.level.player.screenLocation;
                } else {
                    for (Box box: Game.level.boxes) {
                        if (Arrays.equals(box.location, this.location)) {
                            screenLocation = box.screenLocation;
                            break;
                        }
                    }
                }
                if (this.isHit(screenLocation)) {
                    return this.endBoxLocation(screenLocation);
                }
            } else if (isConnecter(this.tileValue)) {
                if (this.checkValidConnecter(new Connecter(this.location.clone(), getColour(this.tileValue)))) {
                    this.encounteredConnecters.add(Arrays.asList(this.location[0], this.location[1]));
                    lasers.add(this);
                    return new int [] {this.location[0] * 32 + 48, this.location[1] * 32 + 48};
                }
            }
            if (this.checkReceivers(false)){
                return this.endTransmitterLocation();
            }
            this.moveLaser();
        }
    }
    List <int[]> shootConnecterLaser(Queue <Laser> lasers) {
        List <int[]> output = new ArrayList<>();
        /*Can optimize*/
        for (String direction: new String [] {"N", "NE", "E", "SE", "S", "SW", "W", "NW"}) {
            boolean blocking = false;
            int [] blockingLocation = new int [2];
            Laser temp = new Laser(this.location.clone(), direction, this.colour, (HashSet<List<Integer>>) this.encounteredConnecters.clone()); 
            if (temp.checkReceivers(false)){
                output.add(temp.endTransmitterLocation());
            }
            temp.moveLaser();
            while (true) {
                temp.update();
                if (isBlockingWall(temp.tileValue)) {
                    break;
                } else if (isDoor(temp.tileValue)) {
                    if (!blocking) {
                        blockingLocation = temp.endDoorLocation();
                        blocking = true;
                    }
                } else if (isBlocking(temp.tileValue, temp.colour)) {
                    int [] screenLocation = new int [2];
                    if (temp.tileValue == 3) {
                        screenLocation = Game.level.player.screenLocation;
                    } else {
                        for (Box box: Game.level.boxes) {
                            if (Arrays.equals(box.location, temp.location)) {
                                screenLocation = box.screenLocation;
                                break;
                            }
                        }
                    }
                    if (temp.isHit(screenLocation)) {
                        if (!blocking) {
                            blockingLocation = temp.endBoxLocation(screenLocation);
                            blocking = true;
                        }
                    }
                } else if (isConnecter(temp.tileValue)) {
                    if (this.checkValidConnecter(new Connecter(temp.location.clone(), getColour(temp.tileValue)))) {
                        if (blocking) {
                            output.add(blockingLocation);
                        } else {
                            temp.encounteredConnecters.add(Arrays.asList(temp.location[0], temp.location[1]));
                            lasers.add(temp);
                            output.add(new int [] {temp.location[0] * 32 + 48, temp.location[1] * 32 + 48});
                        }
                    }
                    break;
                }
                if (temp.checkReceivers(blocking)){
                    if (blocking) {
                        output.add(blockingLocation);
                    } else {
                        output.add(temp.endTransmitterLocation());
                    }
                    break;
            }
                temp.moveLaser();
            }
        }
        return output;
    }
    int [] endWallLocation() {
        int [] output = new int [] {this.location[0] * 32 + 32, this.location[1] * 32 + 32};
        switch (this.direction) {
            case "N":
                output [0] += 16;
                output [1] += 32;
                break;
            case "NE":
                output [0] -= 1;
                output [1] += 33;
                break;
            case "E":
                output [1] += 16;
                break;
            case "SE":
                output [0] -= 1;
                output [1] -= 1;
                break;
            case "S":
                output [0] += 16;
                break;
            case "SW":
                output [0] += 33;
                output [1] -= 1;
                break;
            case "W":
                output [0] += 32;
                output [1] += 16;
                break;
            case "NW":
                output [0] += 33;
                output [1] += 33;
                break;
        }
        return output;
    }
    int [] endDoorLocation() {
        int [] output = new int [] {this.location[0] * 32 + 32, this.location[1] * 32 + 32};
        switch (this.direction) {
            case "N":
                output [0] += 16;
                output [1] += 20;
                break;
            case "NE":
                output [0] += 14;
                output [1] += 18;
                break;
            case "E":
                output [0] += 12;
                output [1] += 16;
                break;
            case "SE":
                output [0] += 14;
                output [1] += 14;
                break;
            case "S":
                output [0] += 16;
                output [1] += 12;
                break;
            case "SW":
                output [0] += 18;
                output [1] += 14;
                break;
            case "W":
                output [0] += 20;
                output [1] += 16;
                break;
            case "NW":
                output [0] += 18;
                output [1] += 18;
                break;
        }
        return output;
    }
    int [] endBoxLocation(int [] screenLocation) {
        int [] output = new int [] {this.location[0] * 32 + 32, this.location[1] * 32 + 32};
        switch (this.direction) {
            case "N":
                return new int [] {this.location[0] * 32 + 32 + 16, screenLocation[1] + 22};
            case "NE":
                output [0] += 15;
                output [1] += 17;
                break;
            case "E":
                return new int [] {screenLocation[0] + 10, this.location[1] * 32 + 32 + 16};
            case "SE":    
                output [0] += 15;
                output [1] += 15;    
                break;
            case "S":
                return new int [] {this.location[0] * 32 + 32 + 16, screenLocation[1] + 10};
            case "SW":
                output [0] += 17;
                output [1] += 15;
                break;
            case "W":
                return new int [] {screenLocation[0] + 22, this.location[1] * 32 + 32 + 16};
            case "NW":
                output [0] += 17;
                output [1] += 17;
                break;
        }
        return output;
    }
    int [] endTransmitterLocation() {
        int [] output = new int [] {this.location[0] * 32 + 32, this.location[1] * 32 + 32};
        switch (this.direction) {
            case "N":
                output [0] += 16;
                output [1] += 6;
                break;
            case "NE":
                output [0] += 30;
                output [1] += 2;
                break;
            case "E":
                output [0] += 26;
                output [1] += 16;
                break;
            case "SE":
                output [0] += 30;
                output [1] += 30;
                break;
            case "S":
                output [0] += 16;
                output [1] += 26;
                break;
            case "SW":
                output [0] += 2;
                output [1] += 30;
                break;
            case "W":
                output [0] += 6;
                output [1] += 16;
                break;
            case "NW":
                output [0] += 2;
                output [1] += 2;
                break;
        }
        return output;
    }
    boolean isHit (int [] screenLocation) {
        if (this.direction.equals("N") || this.direction.equals("S")) {
            if (screenLocation [0] + 8 < this.location[0] * 32 + 32 + 18 && screenLocation [0] + 24 > this.location[0] * 32 + 32 + 14) {
                return true;
            }
        } else if (this.direction.equals("W") || this.direction.equals("E")) {
            if (screenLocation [1] + 8 < this.location[1] * 32 + 32 + 18 && screenLocation [1] + 24 > this.location[1] * 32 + 32 + 14) {
                return true;
            }
        } else {
            if (screenLocation [0] + 12 < this.location[0] * 32 + 32 + 24 && screenLocation [0] + 24 > this.location[0] * 32 + 32 + 12 && screenLocation [1] + 8 < this.location[1] * 32 + 32 + 24 && screenLocation [1] + 24 > this.location[1] * 32 + 32 + 8) {
                return true;
            }
        }
        return false;
    }
    void moveLaser () {
        switch (this.direction) {
            case "N":
                this.location [1] --;
                break;
            case "NE":
                this.location [0] ++;
                this.location [1] --;
                break;
            case "E":
                this.location [0] ++;
                break;
            case "SE":
                this.location [0] ++;
                this.location [1] ++;
                break;
            case "S":
                this.location [1] ++;
                break;
            case "SW":
                this.location [0] --;
                this.location [1] ++;
                break;
            case "W":
                this.location [0] --;
                break;
            case "NW":
                this.location [0] --;
                this.location [1] --;
                break;
        }
    }
    boolean checkReceivers (boolean blocking) {
        boolean output = false;
        for (Receiver receiver: Game.level.receivers) {
            if (checkReceiverHit (receiver)) {
                if (!blocking) {
                    Game.level.setPowerValueOn(receiver.powerValue);
                    receiver.isOn = true;
                }
                output = true;
            }
        }
        return output;
    }
    char getColour (int tileValue) {
        switch (tileValue) {
            case 6:
                return 'W';
            case 7:
                return 'B';
            case 8:
                return 'R';
        }
        return '_';
    }
    boolean checkReceiverHit (Receiver receiver) {
        return this.colour == receiver.colour && Arrays.equals(this.location, receiver.location) && this.direction.contains(receiver.direction);
    }
    boolean checkValidConnecter (Connecter connecter) {
        return (connecter.colour == 'W' || this.colour == connecter.colour) && !this.encounteredConnecters.contains(Arrays.asList(connecter.location[0], connecter.location[1]));
    }
}