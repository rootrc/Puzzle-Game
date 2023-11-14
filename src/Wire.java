class Wire extends GameObject {
    boolean isPowered = false;

    Wire(int[] location, int wireNum) {
        super(location);
        image = Images.wires[Game.getInstance().level.num - 1][wireNum];
    }
}