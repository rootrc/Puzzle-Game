import java.util.HashSet;

class Transmitter extends Object {
    String direction;
    char colour;
    Laser laser; 
    Transmitter(int [] location, String direction, char colour) {
        super(location);
        this.direction = direction;
        this.screenLocation = startLocation();
        this.colour = colour;
    }
    void newLaser() {
        laser = new Laser(location.clone(), direction, colour, new HashSet <>());
    }
    int [] startLocation() {
        int [] output = screenLocation;
        switch (direction) {
            case "N":
                output [0] += 16;
                output [1] += 26;
                break;
            case "NE":
                output [0] += 21;
                output [1] += 11;
                break;
            case "E":
                output [0] += 6;
                output [1] += 16;  
                break;
            case "SE":      
                output [0] += 21;
                output [1] += 21;  
                break;
            case "S":
                output [0] += 16;
                output [1] += 6;
                break;
            case "SW":
                output [0] += 11;
                output [1] += 21;
                break;
            case "W":
                output [0] += 26;
                output [1] += 16;
                break;
            case "NW":
                output [0] += 11;
                output [1] += 11;
                break;
        }
        return output;
    }

}
