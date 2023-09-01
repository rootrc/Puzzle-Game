class Wire extends GameObject {
    boolean isPowered = false;

    Wire(int[] location, int wireNum) {
        super(location);
        image = Images.wires[Game.level.num - 1][wireNum];
    }
}