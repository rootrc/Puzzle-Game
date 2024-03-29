import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

class Laser extends GameObject {
    int tileValue;
    String direction;
    char colour;
    HashSet<List<Integer>> encounteredConnectors;

    Laser(int[] location, String direction, char colour, HashSet<List<Integer>> encounteredConnectors) {
        super(location);
        this.direction = direction;
        this.colour = colour;
        this.encounteredConnectors = encounteredConnectors;
    }

    void update() {
        tileValue = getTileValue();
    }
    
    // Shoots a laser from a transmitter
    int[] shootTransmitterLaser(Queue<Laser> lasers) {
        // if direction is diagonal, skip checking own tile
        if (direction.length() == 2) {
            moveLaser();
        }
        while (true) {
            update();
            // checks what laser hits and returns screen location
            if (isBlockingWall(tileValue)) {
                return endWallLocation();
            } else if (isDoor(tileValue)) {
                return endDoorLocation();
            // if it's hitting a player, box, or different coloured receiver
            } else if (isBlocking()) {
                int[] screenLocation = new int[2];
                if (tileValue == 3) {
                    screenLocation = Game.getInstance().level.player.screenLocation;
                } else {
                    // find the box that's been hit
                    for (Box box : Game.getInstance().level.boxes) {
                        if (Arrays.equals(box.location, location)) {
                            screenLocation = box.screenLocation;
                            break;
                        }
                    }
                }
                // checks if it's hit on the screen location
                if (isHit(screenLocation)) {
                    // return hit screen location
                    return endBoxLocation(screenLocation);
                }
            // if it's hitting a connecter
            } else if (isConnector(tileValue)) {
                // check if it's a valid connecter
                if (checkValidConnecter(new Connecter(location.clone(), getColour(tileValue)))) {
                    // add it to encountered connectors to dfs can be done
                    encounteredConnectors.add(Arrays.asList(location[0], location[1]));
                    // adds the laser to the queue
                    lasers.add(this);
                    return new int[]{location[0] * 32 + 48, location[1] * 32 + 48};
                }
            }
            // if it's hitting a receiver
            if (checkReceivers(false)) {
                return endTransmitterLocation();
            }
            moveLaser();
        }
    }

    @SuppressWarnings("unchecked")
    // Shoots a laser from a connecter
    List<int[]> shootConnecterLaser(Queue<Laser> lasers) {
        List<int[]> output = new ArrayList<>();
        for (String i : new String[]{"N", "NE", "E", "SE", "S", "SW", "W", "NW"}) {
            boolean blocking = false;
            int[] blockingLocation = new int[2];
            Laser temp = new Laser(location.clone(), i, colour, (HashSet<List<Integer>>) encounteredConnectors.clone());
            if (temp.checkReceivers(false)) {
                output.add(temp.endTransmitterLocation());
            }
            temp.moveLaser();
            while (true) {
                temp.update();
                // checks what laser hits and returns screen location
                if (isBlockingWall(temp.tileValue)) {
                    break;
                } else if (isDoor(temp.tileValue)) {
                    // if it hits a door, continue checking, but remember the lser is blocked
                    if (!blocking) {
                        blockingLocation = temp.endDoorLocation();
                        blocking = true;
                    }
                // if it's hitting a player, box, or different coloured receiver
                } else if (temp.isBlocking()) {
                    int[] screenLocation = new int[2];
                    if (temp.tileValue == 3) {
                        screenLocation = Game.getInstance().level.player.screenLocation;
                    } else {
                        // find the box that's been hit
                        for (Box box : Game.getInstance().level.boxes) {
                            if (Arrays.equals(box.location, temp.location)) {
                                screenLocation = box.screenLocation;
                                break;
                            }
                        }
                    }
                    // checks if it's hit on the screen location
                    if (temp.isHit(screenLocation)) {
                        if (!blocking) {
                            // if it hits something, continue checking, but remember the lser is blocked
                            blockingLocation = temp.endBoxLocation(screenLocation);
                            blocking = true;
                        }
                    }
                // it if hits a connecter
                } else if (isConnector(temp.tileValue)) {
                    // if connecter can transmit light
                    if (checkValidConnecter(new Connecter(temp.location.clone(), getColour(temp.tileValue)))) {
                        // if laser is blocked, add visual effect
                        if (blocking) {
                            output.add(blockingLocation);
                        // add connecter to encountered conneecters
                        } else {
                            temp.encounteredConnectors.add(Arrays.asList(temp.location[0], temp.location[1]));
                            lasers.add(temp);
                            output.add(new int[]{temp.location[0] * 32 + 48, temp.location[1] * 32 + 48});
                        }
                    }
                    break;
                }
                // if it's hitting a receiver
                if (temp.checkReceivers(blocking)) {
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

    // checks if laser hits a moving player or box
    private boolean isHit(int[] screenLocation) {
        if (direction.equals("N") || direction.equals("S")) {
            return screenLocation[0] + 8 < location[0] * 32 + 32 + 18 && screenLocation[0] + 24 > location[0] * 32 + 32 + 14;
        } else if (direction.equals("W") || direction.equals("E")) {
            return screenLocation[1] + 8 < location[1] * 32 + 32 + 18 && screenLocation[1] + 24 > location[1] * 32 + 32 + 14;
        } else {
            return screenLocation[0] + 12 < location[0] * 32 + 32 + 24 && screenLocation[0] + 24 > location[0] * 32 + 32 + 12 && screenLocation[1] + 8 < location[1] * 32 + 32 + 24 && screenLocation[1] + 24 > location[1] * 32 + 32 + 8;
        }
    }

    // Moves grid location of the location being checked by the laser based on direction
    private void moveLaser() {
        switch (direction) {
            case "N" -> location[1]--;
            case "NE" -> {
                location[0]++;
                location[1]--;
            }
            case "E" -> location[0]++;
            case "SE" -> {
                location[0]++;
                location[1]++;
            }
            case "S" -> location[1]++;
            case "SW" -> {
                location[0]--;
                location[1]++;
            }
            case "W" -> location[0]--;
            case "NW" -> {
                location[0]--;
                location[1]--;
            }
        }
    }
    
    // Adjusts the screen location of a laser hitting a wall based on direction
    private int[] endWallLocation() {
        int[] output = new int[]{location[0] * 32 + 32, location[1] * 32 + 32};
        switch (direction) {
            case "N" -> {
                output[0] += 16;
                output[1] += 32;
            }
            case "NE" -> {
                output[0] -= 1;
                output[1] += 33;
            }
            case "E" -> output[1] += 16;
            case "SE" -> {
                output[0] -= 1;
                output[1] -= 1;
            }
            case "S" -> output[0] += 16;
            case "SW" -> {
                output[0] += 33;
                output[1] -= 1;
            }
            case "W" -> {
                output[0] += 32;
                output[1] += 16;
            }
            case "NW" -> {
                output[0] += 33;
                output[1] += 33;
            }
        }
        return output;
    }

    // Adjusts the screen location of a laser hitting a door based on direction
    private int[] endDoorLocation() {
        int[] output = new int[]{location[0] * 32 + 32, location[1] * 32 + 32};
        switch (direction) {
            case "N" -> {
                output[0] += 16;
                output[1] += 20;
            }
            case "NE" -> {
                output[0] += 14;
                output[1] += 18;
            }
            case "E" -> {
                output[0] += 12;
                output[1] += 16;
            }
            case "SE" -> {
                output[0] += 14;
                output[1] += 14;
            }
            case "S" -> {
                output[0] += 16;
                output[1] += 12;
            }
            case "SW" -> {
                output[0] += 18;
                output[1] += 14;
            }
            case "W" -> {
                output[0] += 20;
                output[1] += 16;
            }
            case "NW" -> {
                output[0] += 18;
                output[1] += 18;
            }
        }
        return output;
    }

    // Adjusts the screen location of a laser hitting a box based on direction
    private int[] endBoxLocation(int[] screenLocation) {
        int[] output = new int[]{location[0] * 32 + 32, location[1] * 32 + 32};
        switch (direction) {
            case "N" -> {
                return new int[]{location[0] * 32 + 32 + 16, screenLocation[1] + 22};
            }
            case "NE" -> {
                output[0] += 15;
                output[1] += 17;
            }
            case "E" -> {
                return new int[]{screenLocation[0] + 10, location[1] * 32 + 32 + 16};
            }
            case "SE" -> {
                output[0] += 15;
                output[1] += 15;
            }
            case "S" -> {
                return new int[]{location[0] * 32 + 32 + 16, screenLocation[1] + 10};
            }
            case "SW" -> {
                output[0] += 17;
                output[1] += 15;
            }
            case "W" -> {
                return new int[]{screenLocation[0] + 22, location[1] * 32 + 32 + 16};
            }
            case "NW" -> {
                output[0] += 17;
                output[1] += 17;
            }
        }
        return output;
    }

    // Finds the screen location of the end of the transmiter laser based on grid location
    private int[] endTransmitterLocation() {
        int[] output = new int[]{location[0] * 32 + 32, location[1] * 32 + 32};
        switch (direction) {
            case "N" -> {
                output[0] += 16;
                output[1] += 6;
            }
            case "NE" -> {
                output[0] += 30;
                output[1] += 2;
            }
            case "E" -> {
                output[0] += 26;
                output[1] += 16;
            }
            case "SE" -> {
                output[0] += 30;
                output[1] += 30;
            }
            case "S" -> {
                output[0] += 16;
                output[1] += 26;
            }
            case "SW" -> {
                output[0] += 2;
                output[1] += 30;
            }
            case "W" -> {
                output[0] += 6;
                output[1] += 16;
            }
            case "NW" -> {
                output[0] += 2;
                output[1] += 2;
            }
        }
        return output;
    }

    // Check if a receiver can be hit
    private boolean checkReceivers(boolean blocking) {
        boolean output = false;
        for (Receiver receiver : Game.getInstance().level.receivers) {
            if (checkReceiverHit(receiver)) {
                // if it's actually being hit, activate the wire connected to the receiver
                if (!blocking) {
                    Game.getInstance().level.setPowerValueOn(receiver.powerValue);
                    receiver.isOn = true;
                }
                output = true;
                break;
            }
        }
        return output;
    }

    private char getColour(int tileValue) {
        return switch (tileValue) {
            case 6 -> 'W';
            case 7 -> 'B';
            case 8 -> 'R';
            default -> '_';
        };
    }

    private boolean isBlocking() {
        if (colour == 'B') {
            return (tileValue == 3 || tileValue == 5 || tileValue == 8);
        }
        if (colour == 'R') {
            return (tileValue == 3 || tileValue == 5 || tileValue == 7);
        }
        return false;
    }

    private boolean checkReceiverHit(Receiver receiver) {
        return colour == receiver.colour && Arrays.equals(location, receiver.location) && direction.contains(receiver.direction);
    }

    private boolean checkValidConnecter(Connecter connecter) {
        return (connecter.colour == 'W' || colour == connecter.colour) && !encounteredConnectors.contains(Arrays.asList(connecter.location[0], connecter.location[1]));
    }
}