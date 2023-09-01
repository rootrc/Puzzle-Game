import java.util.*;

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

    int[] shootTransmitterLaser(Queue<Laser> lasers) {
        if (direction.length() == 2) {
            moveLaser();
        }
        while (true) {
            update();
            if (isBlockingWall(tileValue)) {
                return endWallLocation();
            } else if (isDoor(tileValue)) {
                return endDoorLocation();
            } else if (isBlocking()) {
                int[] screenLocation = new int[2];
                if (tileValue == 3) {
                    screenLocation = Game.level.player.screenLocation;
                } else {
                    for (Box box : Game.level.boxes) {
                        if (Arrays.equals(box.location, location)) {
                            screenLocation = box.screenLocation;
                            break;
                        }
                    }
                }
                if (isHit(screenLocation)) {
                    return endBoxLocation(screenLocation);
                }
            } else if (isConnector(tileValue)) {
                if (checkValidConnecter(new Connecter(location.clone(), getColour(tileValue)))) {
                    encounteredConnectors.add(Arrays.asList(location[0], location[1]));
                    lasers.add(this);
                    return new int[]{location[0] * 32 + 48, location[1] * 32 + 48};
                }
            }
            if (checkReceivers(false)) {
                return endTransmitterLocation();
            }
            moveLaser();
        }
    }

    @SuppressWarnings("unchecked")
    List<int[]> shootConnecterLaser(Queue<Laser> lasers) {
        List<int[]> output = new ArrayList<>();
        /*Can optimize*/
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
                if (isBlockingWall(temp.tileValue)) {
                    break;
                } else if (isDoor(temp.tileValue)) {
                    if (!blocking) {
                        blockingLocation = temp.endDoorLocation();
                        blocking = true;
                    }
                } else if (temp.isBlocking()) {
                    int[] screenLocation = new int[2];
                    if (temp.tileValue == 3) {
                        screenLocation = Game.level.player.screenLocation;
                    } else {
                        for (Box box : Game.level.boxes) {
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
                } else if (isConnector(temp.tileValue)) {
                    if (checkValidConnecter(new Connecter(temp.location.clone(), getColour(temp.tileValue)))) {
                        if (blocking) {
                            output.add(blockingLocation);
                        } else {
                            temp.encounteredConnectors.add(Arrays.asList(temp.location[0], temp.location[1]));
                            lasers.add(temp);
                            output.add(new int[]{temp.location[0] * 32 + 48, temp.location[1] * 32 + 48});
                        }
                    }
                    break;
                }
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

    boolean isHit(int[] screenLocation) {
        if (direction.equals("N") || direction.equals("S")) {
            return screenLocation[0] + 8 < location[0] * 32 + 32 + 18 && screenLocation[0] + 24 > location[0] * 32 + 32 + 14;
        } else if (direction.equals("W") || direction.equals("E")) {
            return screenLocation[1] + 8 < location[1] * 32 + 32 + 18 && screenLocation[1] + 24 > location[1] * 32 + 32 + 14;
        } else {
            return screenLocation[0] + 12 < location[0] * 32 + 32 + 24 && screenLocation[0] + 24 > location[0] * 32 + 32 + 12 && screenLocation[1] + 8 < location[1] * 32 + 32 + 24 && screenLocation[1] + 24 > location[1] * 32 + 32 + 8;
        }
    }

    void moveLaser() {
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

    int[] endWallLocation() {
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

    int[] endDoorLocation() {
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

    int[] endBoxLocation(int[] screenLocation) {
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

    int[] endTransmitterLocation() {
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

    boolean checkReceivers(boolean blocking) {
        boolean output = false;
        for (Receiver receiver : Game.level.receivers) {
            if (checkReceiverHit(receiver)) {
                if (!blocking) {
                    Game.level.setPowerValueOn(receiver.powerValue);
                    receiver.isOn = true;
                }
                output = true;
            }
        }
        return output;
    }

    char getColour(int tileValue) {
        return switch (tileValue) {
            case 6 -> 'W';
            case 7 -> 'B';
            case 8 -> 'R';
            default -> '_';
        };
    }

    boolean isBlocking() {
        if (colour == 'B') {
            return (tileValue == 3 || tileValue == 5 || tileValue == 8);
        }
        if (colour == 'R') {
            return (tileValue == 3 || tileValue == 5 || tileValue == 7);
        }
        return false;
    }

    boolean checkReceiverHit(Receiver receiver) {
        return colour == receiver.colour && Arrays.equals(location, receiver.location) && direction.contains(receiver.direction);
    }

    boolean checkValidConnecter(Connecter connecter) {
        return (connecter.colour == 'W' || colour == connecter.colour) && !encounteredConnectors.contains(Arrays.asList(connecter.location[0], connecter.location[1]));
    }
}