class Star extends GameObject {
    boolean collected = false;

    Star(int[] location) {
        super(location);
        image = Images.star;
    }
}
