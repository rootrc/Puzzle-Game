class Receiver extends Object {
    String direction;
    char colour;
    int powerValue; 
    boolean isOn;
    int directionImage;
    Receiver(int [] location, String direction, char colour, int powerValue) {
        super(location);
        this.direction = direction;
        this.colour = colour;
        this.powerValue = powerValue;
        if (direction.equals("N")) {
            directionImage = 0;
        } else if (direction.equals("W")) {
            directionImage = 1;
        } else if (direction.equals("S")) {
            directionImage = 2;
        } else if (direction.equals("E")) {
            directionImage = 3;
        }
        if (colour == 'R') {
            directionImage += 4;
        }
        isOn = false;
    }
}
