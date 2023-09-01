class Receiver extends GameObject {
    String direction;
    char colour;
    int powerValue;
    boolean isOn;
    int directionImage;

    Receiver(int[] location, String direction, char colour, int powerValue) {
        super(location);
        this.direction = direction;
        this.colour = colour;
        this.powerValue = powerValue;
        switch (direction) {
            case "N" -> directionImage = 0;
            case "W" -> directionImage = 1;
            case "S" -> directionImage = 2;
            case "E" -> directionImage = 3;
        }
        if (colour == 'R') {
            directionImage += 4;
        }
        isOn = false;
    }
}
