final class LevelFactory {
    void setUp() {
        levelClear();
        Game.getInstance().level.num = Game.getInstance().gameState;
        switch (Game.getInstance().level.num) {
            case 1 -> Level1();
            case 2 -> Level2();
            case 3 -> Level3();
            case 4 -> Level4();
            case 5 -> Level5();
            case 6 -> Level6();
            case 7 -> Level7();
            case 8 -> Level8();
            case 9 -> Level9();
            case 10 -> Level10();
            case 11 -> Level11();
            case 12 -> Level12();
            case 13 -> Level13();
            case 14 -> Level14();
            case 15 -> Level15();
            case 16 -> Level16();
            case 17 -> Level17();
            case 18 -> Level18();
            case 19 -> Level19();
            case 20 -> Level20();
            case 21 -> Level21();
            case 22 -> Level22();
            case 23 -> Level23();
            case 24 -> Level24();
        }
        Game.getInstance().level.image = Images.levels[Game.getInstance().gameState - 1];
        Game.getInstance().level.adjustX = (1024 - Game.getInstance().level.image.getWidth(null)) / 2 - 16;
        Game.getInstance().level.adjustY = (768 - Game.getInstance().level.image.getHeight(null)) / 2 + 16;
        Game.getInstance().stack.clear();
        Game.getInstance().stack.addLast(Game.getInstance().level.copy());
        Game.getInstance().loaded = true;
    }

    private void levelClear() {
        Game.getInstance().level.boxes = new Box[]{};
        Game.getInstance().level.power = new Wire[]{};
        Game.getInstance().level.weightedButtons = new WeightedButton[]{};
        Game.getInstance().level.buttons = new Button[]{};
        Game.getInstance().level.transmitters = new Transmitter[]{};
        Game.getInstance().level.receivers = new Receiver[]{};
        Game.getInstance().level.doors = new Door[]{};
        Game.getInstance().level.star = null;
        Game.getInstance().level.win = false;
    }

    /*
        0 - Empty 
        * 1 - Wall
        * 2 - Glass
        * 3 - Player
        * 4 - Win
        * 5 - Box
        * 6 - White connector
        * 7 - Blue connector
        * 8 - Red connector
        * 9 - Door
        * 10 - Star
    */
    private void Level1() {
        Game.getInstance().level.name = "WASD";
        Game.getInstance().level.grid = new int[][]{{1, 1, 1, 1, 1, 1, 1}, {1, 1, 0, 0, 0, 1, 1}, {1, 0, 0, 4, 0, 0, 1}, {1, 1, 0, 0, 0, 1, 1}, {1, 1, 0, 0, 0, 1, 1}, {1, 3, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 1, 1, 1}};
        Game.getInstance().level.player = new Player(new int[]{1, 5});
    }

    private void Level2() {
        Game.getInstance().level.name = "Weighted Button";
        Game.getInstance().level.grid = new int[][]{{1, 1, 1, 1, 1, 1, 1, 1}, {1, 4, 0, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 9, 1, 1, 1}, {1, 0, 0, 0, 0, 1, 1, 1}, {1, 0, 0, 0, 0, 0, 3, 1}, {1, 0, 0, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1}};
        Game.getInstance().level.player = new Player(new int[]{6, 5});
        Game.getInstance().level.power = new Wire[]{new Wire(new int[]{1, 3}, 0)};
        Game.getInstance().level.weightedButtons = new WeightedButton[]{new WeightedButton(new int[]{1, 5}, 0)};
        Game.getInstance().level.doors = new Door[]{new Door(new int[]{4, 3}, 0, 'W', 0)};
    }

    private void Level3() {
        Game.getInstance().level.name = "Box";
        Game.getInstance().level.grid = new int[][]{{1, 1, 1, 1, 1, 1}, {1, 9, 1, 1, 1, 1}, {1, 0, 0, 0, 4, 1}, {1, 0, 1, 1, 1, 1}, {1, 5, 1, 0, 0, 1}, {1, 0, 0, 0, 3, 1}, {1, 1, 1, 1, 1, 1}};
        Game.getInstance().level.player = new Player(new int[]{4, 5});
        Game.getInstance().level.boxes = new Box[]{new Box(new int[]{1, 4})};
        Game.getInstance().level.power = new Wire[]{new Wire(new int[]{0, 1}, 0)};
        Game.getInstance().level.weightedButtons = new WeightedButton[]{new WeightedButton(new int[]{3, 4}, 0)};
        Game.getInstance().level.doors = new Door[]{new Door(new int[]{1, 1}, 0, 'W', 0)};
    }

    private void Level4() {
        Game.getInstance().level.name = "Button";
        Game.getInstance().level.grid = new int[][]{{1, 1, 1, 1, 1, 1, 1, 1}, {1, 0, 0, 1, 1, 1, 4, 1}, {1, 0, 5, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 1, 1, 1, 1}, {1, 0, 0, 0, 1, 1, 1, 1}, {1, 0, 0, 0, 0, 0, 3, 1}, {1, 1, 0, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1}};
        Game.getInstance().level.player = new Player(new int[]{6, 5});
        Game.getInstance().level.boxes = new Box[]{new Box(new int[]{2, 2})};
        Game.getInstance().level.power = new Wire[]{new Wire(new int[]{2, 2}, 0), new Wire(new int[]{3, 2}, 1), new Wire(new int[]{5, 5}, 2)};
        Game.getInstance().level.power[2].isPowered = true;
        Game.getInstance().level.buttons = new Button[]{new Button(new int[]{2, 3}, 0), new Button(new int[]{6, 5}, 2)};
        Game.getInstance().level.weightedButtons = new WeightedButton[]{new WeightedButton(new int[]{3, 5}, 1)};
        Game.getInstance().level.doors = new Door[]{new Door(new int[]{4, 2}, 0, 'S', 0), new Door(new int[]{5, 2}, 0, 'S', 1), new Door(new int[]{5, 5}, 0, 'S', 2)};
    }

    private void Level5() {
        Game.getInstance().level.name = "More Boxes";
        Game.getInstance().level.grid = new int[][]{{1, 1, 1, 1, 1, 1, 1, 1}, {1, 0, 0, 5, 0, 1, 1, 1}, {1, 0, 5, 0, 0, 1, 1, 1}, {1, 0, 5, 5, 5, 9, 4, 1}, {1, 5, 0, 5, 0, 1, 1, 1}, {1, 0, 0, 0, 5, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1}};
        Game.getInstance().level.player = new Player(new int[]{1, 3});
        Game.getInstance().level.boxes = new Box[]{new Box(new int[]{3, 1}), new Box(new int[]{2, 2}), new Box(new int[]{2, 3}), new Box(new int[]{3, 3}), new Box(new int[]{4, 3}), new Box(new int[]{1, 4}), new Box(new int[]{3, 4}), new Box(new int[]{4, 5})};
        Game.getInstance().level.power = new Wire[]{new Wire(new int[]{3, 3}, 0)};
        Game.getInstance().level.buttons = new Button[]{new Button(new int[]{3, 3}, 0)};
        Game.getInstance().level.doors = new Door[]{new Door(new int[]{5, 3}, 1, 'S', 0)};
    }

    private void Level6() {
        Game.getInstance().level.name = "Big Decisions";
        Game.getInstance().level.grid = new int[][]{{1, 1, 1, 1, 1, 1}, {1, 1, 1, 4, 1, 1}, {1, 1, 1, 9, 1, 1}, {1, 1, 1, 0, 1, 1}, {1, 1, 1, 0, 1, 1}, {1, 1, 0, 0, 0, 1}, {1, 1, 5, 5, 5, 1}, {1, 1, 0, 0, 0, 1}, {1, 3, 5, 0, 5, 1}, {1, 1, 0, 1, 0, 1}, {1, 1, 0, 0, 0, 1}, {1, 1, 1, 1, 1, 1}};
        Game.getInstance().level.player = new Player(new int[]{1, 8});
        Game.getInstance().level.boxes = new Box[]{new Box(new int[]{2, 6}), new Box(new int[]{3, 6}), new Box(new int[]{4, 6}), new Box(new int[]{2, 8}), new Box(new int[]{4, 8})};
        Game.getInstance().level.power = new Wire[]{new Wire(new int[]{3, 2}, 0), new Wire(new int[]{2, 3}, 1), new Wire(new int[]{3, 4}, 2)};
        Game.getInstance().level.power[1].isPowered = true;
        Game.getInstance().level.power[2].isPowered = true;
        Game.getInstance().level.buttons = new Button[]{new Button(new int[]{4, 10}, 0), new Button(new int[]{2, 6}, 1), new Button(new int[]{4, 6}, 2)};
        Game.getInstance().level.doors = new Door[]{new Door(new int[]{3, 2}, 0, 'E', 0), new Door(new int[]{3, 3}, 0, 'W', 1), new Door(new int[]{3, 4}, 0, 'E', 2)};
    }

    private void Level7() {
        Game.getInstance().level.name = "Laser";
        Game.getInstance().level.grid = new int[][]{{1, 1, 1, 1, 1, 1, 1, 1}, {1, 4, 0, 9, 0, 0, 1, 1}, {1, 1, 1, 1, 0, 5, 0, 1}, {1, 1, 1, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 0, 0, 0, 1}, {1, 1, 0, 0, 0, 0, 1, 1}, {1, 1, 1, 1, 3, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1}};
        Game.getInstance().level.player = new Player(new int[]{4, 6});
        Game.getInstance().level.boxes = new Box[]{new Box(new int[]{5, 2})};
        Game.getInstance().level.power = new Wire[]{new Wire(new int[]{0, 1}, 0)};
        Game.getInstance().level.power[0].isPowered = true;
        Game.getInstance().level.transmitters = new Transmitter[]{new Transmitter(new int[]{6, 4}, "W", 'B')};
        Game.getInstance().level.receivers = new Receiver[]{new Receiver(new int[]{1, 4}, "W", 'B', 0)};
        Game.getInstance().level.doors = new Door[]{new Door(new int[]{3, 1}, 1, 'S', 0)};
    }

    private void Level8() {
        Game.getInstance().level.name = "Connecter";
        Game.getInstance().level.grid = new int[][]{{1, 1, 1, 1, 1, 1, 1}, {1, 4, 1, 1, 0, 0, 1}, {1, 9, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 0, 0, 1}, {1, 0, 7, 0, 0, 1, 1}, {1, 1, 3, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}};
        Game.getInstance().level.player = new Player(new int[]{2, 5});
        Game.getInstance().level.boxes = new Box[]{new Box(new int[]{2, 4})};
        Game.getInstance().level.power = new Wire[]{new Wire(new int[]{2, -1}, 0), new Wire(new int[]{0, 0}, 1)};
        Game.getInstance().level.power[0].isPowered = true;
        Game.getInstance().level.transmitters = new Transmitter[]{new Transmitter(new int[]{1, 5}, "NE", 'B')};
        Game.getInstance().level.receivers = new Receiver[]{new Receiver(new int[]{2, 2}, "N", 'B', 0), new Receiver(new int[]{4, 1}, "N", 'B', 1)};
        Game.getInstance().level.doors = new Door[]{new Door(new int[]{1, 2}, 0, 'W', 1)};
    }

    private void Level9() {
        Game.getInstance().level.name = "Sitting Duck";
        Game.getInstance().level.grid = new int[][]{{1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 0, 0, 1, 1}, {1, 1, 0, 0, 7, 0, 0, 1}, {1, 1, 0, 0, 1, 7, 0, 1}, {1, 1, 0, 0, 7, 0, 0, 1}, {1, 9, 0, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 1, 1, 0, 1}, {1, 0, 0, 1, 1, 1, 0, 1}, {1, 0, 0, 0, 1, 1, 0, 1}, {1, 9, 1, 0, 0, 1, 0, 1}, {1, 0, 1, 0, 0, 0, 0, 1}, {1, 4, 1, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 1}};
        Game.getInstance().level.player = new Player(new int[]{1, 5});
        Game.getInstance().level.boxes = new Box[]{new Box(new int[]{4, 2}), new Box(new int[]{5, 3}), new Box(new int[]{4, 4})};
        Game.getInstance().level.power = new Wire[]{new Wire(new int[]{5, 4}, 0), new Wire(new int[]{1, 9}, 1)};
        Game.getInstance().level.power[0].isPowered = true;
        Game.getInstance().level.transmitters = new Transmitter[]{new Transmitter(new int[]{4, 1}, "S", 'B')};
        Game.getInstance().level.receivers = new Receiver[]{new Receiver(new int[]{6, 4}, "E", 'B', 0), new Receiver(new int[]{3, 11}, "W", 'B', 1)};
        Game.getInstance().level.doors = new Door[]{new Door(new int[]{5, 10}, 0, 'N', 0), new Door(new int[]{1, 9}, 0, 'E', 1)};
    }

    private void Level10() {
        Game.getInstance().level.name = "Abandonment";
        Game.getInstance().level.grid = new int[][]{{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 4, 1, 1}, {1, 1, 0, 3, 0, 1, 0, 0, 1, 1, 1, 9, 1, 1}, {1, 1, 0, 0, 0, 9, 0, 7, 0, 1, 0, 0, 1, 1}, {1, 0, 0, 7, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 0, 9, 0, 0, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        Game.getInstance().level.player = new Player(new int[]{3, 2});
        Game.getInstance().level.boxes = new Box[]{new Box(new int[]{3, 4}), new Box(new int[]{7, 3})};
        Game.getInstance().level.power = new Wire[]{new Wire(new int[]{3, 0}, 0), new Wire(new int[]{8, 3}, 1), new Wire(new int[]{10, 2}, 2)};
        Game.getInstance().level.transmitters = new Transmitter[]{new Transmitter(new int[]{1, 5}, "NE", 'B'), new Transmitter(new int[]{6, 2}, "S", 'B')};
        Game.getInstance().level.receivers = new Receiver[]{new Receiver(new int[]{3, 1}, "N", 'B', 0), new Receiver(new int[]{8, 3}, "E", 'B', 1), new Receiver(new int[]{10, 3}, "N", 'B', 2)};
        Game.getInstance().level.doors = new Door[]{new Door(new int[]{5, 3}, 0, 'N', 0), new Door(new int[]{9, 5}, 0, 'N', 1), new Door(new int[]{11, 2}, 0, 'W', 2)};
    }

    private void Level11() {
        Game.getInstance().level.name = "Tripwire";
        Game.getInstance().level.grid = new int[][]{{1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 4, 1}, {1, 0, 7, 0, 0, 0, 0, 0, 1}, {1, 3, 7, 0, 0, 0, 1, 0, 1}, {1, 0, 7, 0, 0, 1, 1, 10, 1}, {1, 1, 1, 1, 0, 1, 1, 1, 1}, {1, 1, 1, 1, 0, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1}};
        Game.getInstance().level.player = new Player(new int[]{1, 3});
        Game.getInstance().level.boxes = new Box[]{new Box(new int[]{2, 2}), new Box(new int[]{2, 3}), new Box(new int[]{2, 4})};
        Game.getInstance().level.power = new Wire[]{new Wire(new int[]{3, 0}, 0), new Wire(new int[]{4, 2}, 1)};
        Game.getInstance().level.power[1].isPowered = true;
        Game.getInstance().level.transmitters = new Transmitter[]{new Transmitter(new int[]{4, 2}, "S", 'B')};
        Game.getInstance().level.receivers = new Receiver[]{new Receiver(new int[]{3, 2}, "N", 'B', 0), new Receiver(new int[]{4, 6}, "S", 'B', 1)};
        Game.getInstance().level.doors = new Door[]{new Door(new int[]{7, 3}, 0, 'E', 0), new Door(new int[]{6, 2}, 0, 'S', 1), new Door(new int[]{4, 5}, 0, 'E', 1)};
        Game.getInstance().level.star = new Star(new int[]{7, 4});
    }

    private void Level12() {
        Game.getInstance().level.name = "Paradox";
        Game.getInstance().level.grid = new int[][]{{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1}, {1, 1, 1, 0, 0, 9, 0, 0, 1, 1, 1, 7, 0, 1, 1}, {1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1}, {1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 9, 0, 0, 1, 1}, {1, 0, 0, 7, 0, 1, 1, 1, 0, 0, 9, 0, 0, 0, 1}, {1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1}, {1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, {1, 0, 0, 1, 9, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 0, 1, 1, 1, 9, 9, 4, 1, 1, 1, 1}, {1, 1, 0, 7, 0, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        Game.getInstance().level.player = new Player(new int[]{5, 10});
        Game.getInstance().level.boxes = new Box[]{new Box(new int[]{11, 2}), new Box(new int[]{3, 5}), new Box(new int[]{3, 10})};
        Game.getInstance().level.power = new Wire[]{new Wire(new int[]{4, 3}, 0), new Wire(new int[]{4, 2}, 1), new Wire(new int[]{9, 7}, 2), new Wire(new int[]{1, 9}, 3)};
        Game.getInstance().level.buttons = new Button[]{new Button(new int[]{1, 9}, 3)};
        Game.getInstance().level.transmitters = new Transmitter[]{new Transmitter(new int[]{5, 10}, "W", 'B'), new Transmitter(new int[]{13, 1}, "SW", 'B')};
        Game.getInstance().level.receivers = new Receiver[]{new Receiver(new int[]{4, 4}, "N", 'B', 0), new Receiver(new int[]{13, 5}, "E", 'B', 1), new Receiver(new int[]{9, 7}, "S", 'B', 2)};
        Game.getInstance().level.doors = new Door[]{new Door(new int[]{10, 4}, 0, 'N', 0), new Door(new int[]{10, 5}, 0, 'S', 0), new Door(new int[]{5, 2}, 0, 'S', 1), new Door(new int[]{4, 8}, 0, 'E', 1), new Door(new int[]{9, 9}, 0, 'N', 2), new Door(new int[]{8, 9}, 0, 'W', 3)};
    }

    private void Level13() {
        Game.getInstance().level.name = "Rabbit";
        Game.getInstance().level.grid = new int[][]{{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1}, {1, 1, 0, 0, 0, 0, 0, 0, 1, 4, 1, 1}, {1, 1, 0, 0, 1, 0, 0, 0, 1, 9, 1, 1}, {1, 0, 0, 0, 0, 7, 0, 0, 1, 0, 0, 1}, {1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1}, {1, 1, 0, 0, 0, 0, 0, 0, 9, 0, 0, 1}, {1, 1, 1, 1, 0, 0, 0, 1, 1, 8, 0, 1}, {1, 1, 1, 1, 1, 3, 1, 1, 1, 0, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        Game.getInstance().level.player = new Player(new int[]{5, 9});
        Game.getInstance().level.boxes = new Box[]{new Box(new int[]{5, 5}), new Box(new int[]{9, 8})};
        Game.getInstance().level.power = new Wire[]{new Wire(new int[]{7, 2}, 0), new Wire(new int[]{0, 4}, 1)};
        Game.getInstance().level.transmitters = new Transmitter[]{new Transmitter(new int[]{5, 1}, "S", 'R'), new Transmitter(new int[]{2, 7}, "E", 'B')};
        Game.getInstance().level.receivers = new Receiver[]{new Receiver(new int[]{7, 3}, "N", 'B', 0), new Receiver(new int[]{1, 5}, "W", 'R', 1)};
        Game.getInstance().level.doors = new Door[]{new Door(new int[]{8, 7}, 0, 'N', 0), new Door(new int[]{9, 4}, 0, 'E', 1)};
    }

    private void Level14() {
        Game.getInstance().level.name = "Warehouse";
        Game.getInstance().level.grid = new int[][]{{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1}, {1, 0, 9, 8, 0, 0, 0, 0, 0, 0, 0, 0, 1}, {1, 1, 0, 0, 7, 1, 1, 1, 0, 0, 0, 1, 1}, {1, 1, 1, 1, 0, 1, 1, 1, 0, 8, 0, 9, 1}, {1, 0, 4, 0, 0, 0, 0, 9, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        Game.getInstance().level.player = new Player(new int[]{6, 2});
        Game.getInstance().level.boxes = new Box[]{new Box(new int[]{3, 2}), new Box(new int[]{4, 3}), new Box(new int[]{9, 4})};
        Game.getInstance().level.power = new Wire[]{new Wire(new int[]{2, 0}, 0), new Wire(new int[]{11, 2}, 1), new Wire(new int[]{7, 4}, 2), new Wire(new int[]{3, 4}, 3)};
        Game.getInstance().level.power[3].isPowered = true;
        Game.getInstance().level.buttons = new Button[]{new Button(new int[]{9, 4}, 3)};
        Game.getInstance().level.transmitters = new Transmitter[]{new Transmitter(new int[]{9, 1}, "S", 'R'), new Transmitter(new int[]{1, 2}, "E", 'R'), new Transmitter(new int[]{11, 4}, "W", 'B')};
        Game.getInstance().level.receivers = new Receiver[]{new Receiver(new int[]{10, 2}, "N", 'R', 0), new Receiver(new int[]{11, 2}, "S", 'R', 1), new Receiver(new int[]{8, 4}, "W", 'B', 2)};
        Game.getInstance().level.doors = new Door[]{new Door(new int[]{2, 2}, 0, 'N', 0), new Door(new int[]{11, 4}, 0, 'N', 1), new Door(new int[]{7, 5}, 0, 'N', 2), new Door(new int[]{3, 5}, 0, 'S', 3)};
    }

    private void Level15() {
        Game.getInstance().level.name = "One at a Time";
        Game.getInstance().level.grid = new int[][]{{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1}, {1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1}, {1, 1, 0, 0, 6, 0, 0, 9, 0, 6, 0, 9, 4, 1}, {1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1}, {1, 1, 0, 0, 3, 0, 0, 1, 1, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1}, {1, 0, 0, 0, 0, 0, 0, 9, 0, 6, 0, 1, 1, 1}, {1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        Game.getInstance().level.player = new Player(new int[]{4, 5});
        Game.getInstance().level.boxes = new Box[]{new Box(new int[]{4, 3}), new Box(new int[]{9, 3}), new Box(new int[]{9, 7})};
        Game.getInstance().level.power = new Wire[]{new Wire(new int[]{9, 0}, 0), new Wire(new int[]{7, 3}, 1), new Wire(new int[]{6, 5}, 2), new Wire(new int[]{1, 7}, 3)};
        Game.getInstance().level.power[2].isPowered = true;
        Game.getInstance().level.transmitters = new Transmitter[]{new Transmitter(new int[]{4, 2}, "S", 'B'), new Transmitter(new int[]{2, 3}, "E", 'R')};
        Game.getInstance().level.receivers = new Receiver[]{new Receiver(new int[]{9, 1}, "N", 'B', 0), new Receiver(new int[]{10, 7}, "E", 'R', 1), new Receiver(new int[]{6, 5}, "E", 'B', 2), new Receiver(new int[]{1, 7}, "S", 'R', 3)};
        Game.getInstance().level.doors = new Door[]{new Door(new int[]{11, 3}, 0, 'N', 0), new Door(new int[]{7, 3}, 0, 'S', 1), new Door(new int[]{9, 5}, 0, 'W', 2), new Door(new int[]{7, 7}, 0, 'S', 3)};
    }

    static void Level16() {
        Game.getInstance().level.name = "Locked";
        Game.getInstance().level.grid = new int[][]{{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1}, {1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1}, {1, 0, 0, 9, 0, 0, 0, 0, 9, 0, 0, 6, 0, 1}, {1, 0, 8, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1}, {1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 9, 1, 1}, {1, 1, 0, 1, 1, 0, 6, 1, 1, 1, 1, 0, 0, 1}, {1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1}, {1, 1, 0, 10, 9, 0, 1, 1, 1, 1, 0, 0, 0, 1}, {1, 1, 1, 1, 1, 9, 1, 1, 1, 1, 0, 0, 0, 1}, {1, 1, 1, 1, 0, 0, 0, 0, 0, 9, 0, 0, 1, 1}, {1, 1, 1, 1, 0, 0, 7, 3, 0, 1, 0, 0, 9, 1}, {1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 4, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        Game.getInstance().level.player = new Player(new int[]{7, 11});
        Game.getInstance().level.boxes = new Box[]{new Box(new int[]{11, 3}), new Box(new int[]{2, 4}), new Box(new int[]{6, 6}), new Box(new int[]{6, 11})};
        Game.getInstance().level.power = new Wire[]{new Wire(new int[]{3, 2}, 0), new Wire(new int[]{7, 3}, 1), new Wire(new int[]{9, 4}, 2), new Wire(new int[]{9, 7}, 3), new Wire(new int[]{12, 9}, 4), new Wire(new int[]{5, 9}, 5), new Wire(new int[]{0, 3}, 6)};
        Game.getInstance().level.power[2].isPowered = true;
        Game.getInstance().level.transmitters = new Transmitter[]{new Transmitter(new int[]{12, 1}, "SW", 'R'), new Transmitter(new int[]{8, 12}, "W", 'B')};
        Game.getInstance().level.receivers = new Receiver[]{new Receiver(new int[]{5, 2}, "W", 'B', 0), new Receiver(new int[]{7, 5}, "E", 'B', 1), new Receiver(new int[]{9, 4}, "S", 'R', 2), new Receiver(new int[]{10, 7}, "W", 'R', 3), new Receiver(new int[]{12, 9}, "E", 'B', 4), new Receiver(new int[]{7, 10}, "N", 'B', 5), new Receiver(new int[]{1, 3}, "W", 'R', 6)};
        Game.getInstance().level.doors = new Door[]{new Door(new int[]{3, 3}, 0, 'N', 0), new Door(new int[]{8, 3}, 0, 'S', 1), new Door(new int[]{11, 5}, 0, 'W', 2), new Door(new int[]{9, 10}, 0, 'N', 3), new Door(new int[]{12, 11}, 0, 'E', 4), new Door(new int[]{5, 9}, 0, 'E', 5), new Door(new int[]{4, 8}, 0, 'N', 6)};
        Game.getInstance().level.star = new Star(new int[]{3, 8});
    }

    private void Level17() {
        Game.getInstance().level.name = "Deception";
        Game.getInstance().level.grid = new int[][]{{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1}, {1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1}, {1, 0, 6, 0, 0, 9, 0, 0, 6, 0, 1}, {1, 0, 0, 0, 0, 9, 0, 0, 0, 0, 1}, {1, 1, 0, 1, 1, 1, 1, 1, 9, 9, 1}, {1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1}, {1, 1, 0, 0, 0, 1, 1, 0, 6, 0, 1}, {1, 1, 0, 6, 0, 9, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1}, {1, 1, 0, 3, 1, 1, 1, 1, 0, 0, 1}, {1, 1, 1, 9, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 4, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        Game.getInstance().level.player = new Player(new int[]{3, 10});
        Game.getInstance().level.boxes = new Box[]{new Box(new int[]{2, 3}), new Box(new int[]{8, 3}), new Box(new int[]{8, 7}), new Box(new int[]{3, 8})};
        Game.getInstance().level.power = new Wire[]{new Wire(new int[]{4, 1}, 0), new Wire(new int[]{7, 2}, 1), new Wire(new int[]{1, 5}, 2), new Wire(new int[]{5, 7}, 3), new Wire(new int[]{2, 10}, 4)};
        Game.getInstance().level.power[2].isPowered = true;
        Game.getInstance().level.transmitters = new Transmitter[]{new Transmitter(new int[]{8, 1}, "S", 'B'), new Transmitter(new int[]{1, 10}, "NE", 'R')};
        Game.getInstance().level.receivers = new Receiver[]{new Receiver(new int[]{4, 1}, "E", 'R', 0), new Receiver(new int[]{9, 2}, "E", 'R', 1), new Receiver(new int[]{2, 7}, "W", 'R', 2), new Receiver(new int[]{7, 7}, "W", 'B', 3), new Receiver(new int[]{2, 10}, "S", 'B', 4)};
        Game.getInstance().level.doors = new Door[]{new Door(new int[]{5, 3}, 0, 'N', 0), new Door(new int[]{5, 4}, 0, 'S', 0), new Door(new int[]{8, 5}, 0, 'W', 1), new Door(new int[]{9, 5}, 0, 'E', 1), new Door(new int[]{2, 5}, 0, 'W', 2), new Door(new int[]{5, 8}, 0, 'N', 3), new Door(new int[]{3, 11}, 0, 'W', 4)};
    }

    private void Level18() {
        Game.getInstance().level.name = "Laser Trivia";
        Game.getInstance().level.grid = new int[][]{{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 0, 1, 1, 9, 4, 1}, {1, 1, 1, 1, 1, 0, 0, 1, 9, 1, 1}, {1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1}, {1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1}, {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1}, {1, 1, 0, 0, 6, 0, 6, 0, 6, 0, 1}, {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1}, {1, 1, 9, 1, 1, 0, 0, 1, 9, 1, 1}, {1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        Game.getInstance().level.player = new Player(new int[]{5, 10});
        Game.getInstance().level.boxes = new Box[]{new Box(new int[]{4, 6}), new Box(new int[]{6, 6}), new Box(new int[]{8, 6})};
        Game.getInstance().level.power = new Wire[]{new Wire(new int[]{4, 0}, 0), new Wire(new int[]{1, 2}, 1), new Wire(new int[]{5, 4}, 2), new Wire(new int[]{2, 9}, 3)};
        Game.getInstance().level.transmitters = new Transmitter[]{new Transmitter(new int[]{3, 3}, "S", 'R'), new Transmitter(new int[]{2, 9}, "N", 'B'), new Transmitter(new int[]{8, 9}, "N", 'B')};
        Game.getInstance().level.receivers = new Receiver[]{new Receiver(new int[]{5, 1}, "W", 'B', 0), new Receiver(new int[]{2, 3}, "W", 'R', 1), new Receiver(new int[]{5, 5}, "N", 'B', 2), new Receiver(new int[]{6, 9}, "E", 'R', 3)};
        Game.getInstance().level.doors = new Door[]{new Door(new int[]{8, 1}, 0, 'N', 0), new Door(new int[]{8, 2}, 0, 'W', 1), new Door(new int[]{8, 9}, 0, 'E', 2), new Door(new int[]{2, 9}, 0, 'E', 3)};
    }

    private void Level19() {
        Game.getInstance().level.name = "Brute Force";
        Game.getInstance().level.grid = new int[][]{{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 4, 9, 0, 0, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 9, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1}, {1, 3, 8, 0, 0, 1, 0, 8, 0, 1, 1}, {1, 1, 0, 0, 0, 9, 0, 0, 0, 1, 1}, {1, 1, 1, 0, 0, 9, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        Game.getInstance().level.player = new Player(new int[]{1, 5});
        Game.getInstance().level.boxes = new Box[]{new Box(new int[]{2, 5}), new Box(new int[]{7, 5})};
        Game.getInstance().level.power = new Wire[]{new Wire(new int[]{6, 0}, 0), new Wire(new int[]{5, 3}, 1), new Wire(new int[]{2, 5}, 2)};
        Game.getInstance().level.buttons = new Button[]{new Button(new int[]{9, 1}, 0)};
        Game.getInstance().level.transmitters = new Transmitter[]{new Transmitter(new int[]{4, 8}, "N", 'R')};
        Game.getInstance().level.receivers = new Receiver[]{new Receiver(new int[]{6, 4}, "W", 'R', 1), new Receiver(new int[]{3, 7}, "W", 'R', 2)};
        Game.getInstance().level.doors = new Door[]{new Door(new int[]{6, 1}, 0, 'N', 0), new Door(new int[]{8, 3}, 0, 'W', 1), new Door(new int[]{5, 6}, 0, 'N', 2), new Door(new int[]{5, 7}, 0, 'S', 2)};
    }

    private void Level20() {
        Game.getInstance().level.name = "Sight";
        Game.getInstance().level.grid = new int[][]{{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 4, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 9, 1, 1, 1, 1, 1, 1}, {1, 1, 0, 0, 0, 0, 0, 0, 0, 8, 0, 1}, {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1}, {1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1}, {1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1}, {1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1}, {1, 1, 1, 1, 0, 0, 0, 0, 9, 0, 0, 1}, {1, 1, 1, 1, 0, 0, 7, 0, 1, 1, 1, 1}, {1, 1, 1, 1, 0, 3, 0, 0, 1, 1, 1, 1}, {1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 9, 9, 1, 1, 1, 1, 1, 1}, {1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, {1, 0, 0, 6, 0, 6, 0, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        Game.getInstance().level.player = new Player(new int[]{5, 10});
        Game.getInstance().level.boxes = new Box[]{new Box(new int[]{9, 3}), new Box(new int[]{6, 9}), new Box(new int[]{3, 14}), new Box(new int[]{5, 14})};
        Game.getInstance().level.power = new Wire[]{new Wire(new int[]{1, 2}, 0), new Wire(new int[]{3, 7}, 1), new Wire(new int[]{0, 8}, 2)};
        Game.getInstance().level.transmitters = new Transmitter[]{new Transmitter(new int[]{7, 10}, "W", 'B'), new Transmitter(new int[]{6, 15}, "W", 'R')};
        Game.getInstance().level.receivers = new Receiver[]{new Receiver(new int[]{2, 3}, "W", 'R', 0), new Receiver(new int[]{4, 8}, "N", 'B', 1), new Receiver(new int[]{1, 14}, "W", 'B', 2)};
        Game.getInstance().level.doors = new Door[]{new Door(new int[]{5, 2}, 0, 'W', 0), new Door(new int[]{4, 12}, 0, 'W', 1), new Door(new int[]{5, 12}, 0, 'E', 1), new Door(new int[]{8, 8}, 0, 'S', 2)};
    }

    private void Level21() {
        Game.getInstance().level.name = "Obseratory";
        Game.getInstance().level.grid = new int[][]{{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 2, 0, 1, 1, 1}, {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 0, 4, 1, 1}, {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 1, 1, 1}, {1, 1, 9, 1, 1, 1, 1, 1, 0, 1, 1, 1, 2, 1, 2, 1, 1, 1}, {1, 1, 9, 1, 1, 1, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 1, 1}, {1, 0, 0, 1, 0, 0, 0, 0, 3, 0, 0, 1, 0, 6, 0, 0, 0, 1}, {1, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 1}, {1, 0, 0, 1, 0, 0, 0, 1, 2, 1, 2, 1, 2, 1, 0, 0, 0, 1}, {1, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 0, 0, 0, 1}, {1, 0, 0, 1, 0, 6, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1}, {1, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 1}, {1, 1, 10, 1, 1, 1, 2, 1, 2, 1, 2, 1, 2, 1, 0, 0, 0, 1}, {1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, {1, 1, 0, 0, 9, 0, 0, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        Game.getInstance().level.player = new Player(new int[]{8, 7});
        Game.getInstance().level.boxes = new Box[]{new Box(new int[]{13, 7}), new Box(new int[]{5, 11}), new Box(new int[]{9, 15})};
        Game.getInstance().level.power = new Wire[]{new Wire(new int[]{12, 0}, 0), new Wire(new int[]{12, 10}, 1), new Wire(new int[]{4, 14}, 2), new Wire(new int[]{0, 3}, 3), new Wire(new int[]{2, 6}, 4)};
        Game.getInstance().level.transmitters = new Transmitter[]{new Transmitter(new int[]{5, 6}, "SE", 'B'), new Transmitter(new int[]{2, 15}, "E", 'R')};
        Game.getInstance().level.receivers = new Receiver[]{new Receiver(new int[]{12, 1}, "N", 'R', 0), new Receiver(new int[]{12, 11}, "E", 'B', 1), new Receiver(new int[]{5, 14}, "W", 'B', 2), new Receiver(new int[]{1, 3}, "W", 'R', 3), new Receiver(new int[]{5, 12}, "S", 'B', 4)};
        Game.getInstance().level.doors = new Door[]{new Door(new int[]{13, 3}, 0, 'N', 0), new Door(new int[]{13, 10}, 0, 'S', 1), new Door(new int[]{4, 15}, 0, 'N', 2), new Door(new int[]{2, 5}, 0, 'W', 3), new Door(new int[]{2, 6}, 0, 'E', 4)};
        Game.getInstance().level.star = new Star(new int[]{2, 13});
    }

    private void Level22() {
        Game.getInstance().level.name = "Zig Zag";
        Game.getInstance().level.grid = new int[][]{{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 0, 9, 0, 1, 1, 1, 1}, {1, 1, 1, 0, 0, 2, 0, 0, 1, 1, 1}, {1, 0, 0, 0, 0, 2, 0, 0, 1, 1, 1}, {1, 0, 0, 6, 0, 2, 0, 6, 0, 0, 1}, {1, 0, 0, 0, 0, 2, 0, 0, 0, 1, 1}, {1, 0, 0, 3, 0, 2, 0, 0, 1, 1, 1}, {1, 1, 0, 0, 0, 2, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1}, {1, 1, 1, 4, 9, 0, 0, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        Game.getInstance().level.player = new Player(new int[]{3, 6});
        Game.getInstance().level.boxes = new Box[]{new Box(new int[]{3, 4}), new Box(new int[]{7, 4})};
        Game.getInstance().level.power = new Wire[]{new Wire(new int[]{0, 1}, 0), new Wire(new int[]{4, 7}, 1)};
        Game.getInstance().level.transmitters = new Transmitter[]{new Transmitter(new int[]{1, 3}, "E", 'B'), new Transmitter(new int[]{9, 3}, "SW", 'R')};
        Game.getInstance().level.receivers = new Receiver[]{new Receiver(new int[]{1, 6}, "W", 'B', 0), new Receiver(new int[]{4, 7}, "S", 'R', 1)};
        Game.getInstance().level.doors = new Door[]{new Door(new int[]{5, 1}, 0, 'S', 0), new Door(new int[]{4, 9}, 0, 'N', 1)};
    }

    private void Level23() {
        Game.getInstance().level.name = "Through Glass";
        Game.getInstance().level.grid = new int[][]{{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 4, 9, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 0, 0, 0, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1}, {1, 1, 1, 1, 9, 1, 1, 0, 0, 0, 2, 0, 0, 0, 0, 0, 1, 1, 1}, {1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 9, 0, 0, 0, 7, 0, 0, 1, 1}, {1, 1, 0, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 1}, {1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1}, {1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1}, {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 2, 2, 9, 2, 2, 1, 1}, {1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 2, 0, 0, 6, 3, 0, 0, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 7, 0, 2, 0, 0, 0, 0, 0, 0, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 2, 0, 0, 0, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        Game.getInstance().level.player = new Player(new int[]{14, 12});
        Game.getInstance().level.boxes = new Box[]{new Box(new int[]{14, 6}), new Box(new int[]{13, 12}), new Box(new int[]{8, 13})};
        Game.getInstance().level.power = new Wire[]{new Wire(new int[]{2, 2}, 0), new Wire(new int[]{10, 3}, 1), new Wire(new int[]{4, 4}, 2), new Wire(new int[]{14, 10}, 3)};
        Game.getInstance().level.transmitters = new Transmitter[]{new Transmitter(new int[]{12, 4}, "S", 'B')};
        Game.getInstance().level.receivers = new Receiver[]{new Receiver(new int[]{3, 3}, "W", 'B', 0), new Receiver(new int[]{16, 9}, "E", 'B', 1), new Receiver(new int[]{5, 4}, "S", 'B', 2), new Receiver(new int[]{5, 6}, "N", 'B', 2), new Receiver(new int[]{16, 13}, "E", 'B', 3)};
        Game.getInstance().level.doors = new Door[]{new Door(new int[]{2, 2}, 0, 'S', 0), new Door(new int[]{10, 6}, 0, 'N', 1), new Door(new int[]{4, 5}, 0, 'E', 2), new Door(new int[]{14, 10}, 0, 'E', 3)};
    }

    private void Level24() {
        Game.getInstance().level.name = "Inelegance";
        Game.getInstance().level.grid = new int[][]{{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1}, {1, 1, 0, 0, 0, 9, 0, 0, 0, 0, 0, 9, 0, 1, 1}, {1, 0, 0, 0, 0, 9, 0, 0, 0, 0, 0, 9, 0, 0, 1}, {1, 0, 0, 8, 0, 2, 0, 0, 0, 0, 1, 1, 0, 1, 1}, {1, 1, 0, 0, 0, 2, 2, 2, 2, 2, 1, 1, 4, 1, 1}, {1, 1, 0, 0, 0, 2, 0, 0, 0, 0, 1, 1, 1, 1, 1}, {1, 1, 9, 9, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 0, 2, 0, 0, 3, 0, 0, 2, 0, 1, 1}, {1, 1, 0, 0, 0, 2, 0, 0, 0, 0, 0, 1, 0, 1, 1}, {1, 1, 0, 0, 0, 2, 0, 0, 0, 6, 0, 1, 1, 1, 1}, {1, 1, 0, 6, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        Game.getInstance().level.player = new Player(new int[]{8, 8});
        Game.getInstance().level.boxes = new Box[]{new Box(new int[]{3, 4}), new Box(new int[]{9, 10}), new Box(new int[]{3, 11})};
        Game.getInstance().level.power = new Wire[]{new Wire(new int[]{5, 0}, 0), new Wire(new int[]{1, 1}, 1), new Wire(new int[]{10, 1}, 2), new Wire(new int[]{5, 7}, 3)};
        Game.getInstance().level.power[3].isPowered = true;
        Game.getInstance().level.transmitters = new Transmitter[]{new Transmitter(new int[]{10, 10}, "W", 'B'), new Transmitter(new int[]{2, 13}, "N", 'R')};
        Game.getInstance().level.receivers = new Receiver[]{new Receiver(new int[]{8, 1}, "N", 'B', 0), new Receiver(new int[]{2, 2}, "N", 'R', 1), new Receiver(new int[]{12, 9}, "E", 'R', 2), new Receiver(new int[]{6, 7}, "W", 'B', 3)};
        Game.getInstance().level.doors = new Door[]{new Door(new int[]{5, 2}, 0, 'N', 0), new Door(new int[]{5, 3}, 0, 'S', 0), new Door(new int[]{2, 7}, 0, 'W', 1), new Door(new int[]{3, 7}, 0, 'E', 1), new Door(new int[]{11, 2}, 0, 'N', 2), new Door(new int[]{11, 3}, 0, 'S', 2), new Door(new int[]{5, 11}, 0, 'N', 3)};
    }
}  