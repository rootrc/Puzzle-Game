import java.util.HashSet;

class Transmitter extends GameObject {
    String direction;
    char colour;
    Laser laser;

    Transmitter(int[] location, String direction, char colour) {
        super(location);
        this.direction = direction;
        this.screenLocation = startLocation();
        this.colour = colour;
    }

    void newLaser() {
        laser = new Laser(location.clone(), direction, colour, new HashSet<>());
    }

    int[] startLocation() {
        int[] output = screenLocation;
        switch (direction) {
            case "N" -> {
                output[0] += 16;
                output[1] += 26;
            }
            case "NE" -> {
                output[0] += 21;
                output[1] += 11;
            }
            case "E" -> {
                output[0] += 6;
                output[1] += 16;
            }
            case "SE" -> {
                output[0] += 21;
                output[1] += 21;
            }
            case "S" -> {
                output[0] += 16;
                output[1] += 6;
            }
            case "SW" -> {
                output[0] += 11;
                output[1] += 21;
            }
            case "W" -> {
                output[0] += 26;
                output[1] += 16;
            }
            case "NW" -> {
                output[0] += 11;
                output[1] += 11;
            }
        }
        return output;
    }

}
