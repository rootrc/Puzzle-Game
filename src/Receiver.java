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
        if (this.direction.equals("N")) {
            this.directionImage = 0;
        } else if (this.direction.equals("W")) {
            this.directionImage = 1;
        } else if (this.direction.equals("S")) {
            this.directionImage = 2;
        } else if (this.direction.equals("E")) {
            this.directionImage = 3;
        }
        if (this.colour == 'R') {
            directionImage += 4;
        }
        this.isOn = false;
    }
}
