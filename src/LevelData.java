final class LevelData {  
    /* 0 - Empty 
        * 1 - Wall
        * 2 - Glass
        * 3 - Player
        * 4 - Win
        * 5 - Box
        * 6 - White connector
        * 7 - Blue connector
        * 8 - Red connector
        * 9 - Door
    */
    static void setUp() {
        levelClear();
        switch (Game.gameState) {
            case 1:
                Level1();
                break;
            case 2:
                Level2();
                break;
            case 3:
                Level3();
                break;
            case 4:
                Level4();
                break;
            case 5:
                Level5();
                break;
            case 6:
                Level6();
                break;
            case 7:
                Level7();
                break;
            case 8:
                Level8();
                break;
            case 9:
                Level9();
                break;
            case 10:
                Level10();
                break;
            case 11:
                Level11();
                break;
            case 12:
                Level12();
                break;
            case 13:
                Level13();
                break;
            case 14:
                Level14();
                break;
            case 15:
                Level15();
                break;
            case 16:
                Level16();
                break;
            case 17:
                Level17();
                break;
            case 18:
                Level18();
                break;
            case 19:
                Level19();
                break; 
            case 20:
                Level20();
                break;
            case 21:
                Level21();
                break;
            case 22:
                Level22();
                break;
        }
        Game.level.image = Images.levels[Game.gameState - 1];
        Game.level.adjustX = (1024 - Game.level.image.getWidth(null)) / 2 - 16;
        Game.level.adjustY = (768 - Game.level.image.getHeight(null)) / 2 + 16;
        Game.loaded = true;
        
    }
    static void levelClear() {
        Game.level.boxes = new Box [] {};
        Game.level.power = new boolean [] {};
        Game.level.weightedButtons = new WeightedButton [] {};
        Game.level.buttons = new Button [] {};
        Game.level.transmitters = new Transmitter [] {};
        Game.level.receivers = new Receiver [] {};
        Game.level.doors = new Door [] {};
    }
    static void Level1() {
        Game.level.grid = new int [][] {{1, 1, 1, 1, 1, 1, 1}, {1, 1, 0, 0, 0, 1, 1}, {1, 0, 0, 4, 0, 0, 1}, {1, 1, 0, 0, 0, 1, 1}, {1, 1, 0, 0, 0, 1, 1}, {1, 3, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 1, 1, 1}};
        Game.level.player = new Player (new int [] {1, 5});
    }  
    static void Level2() {
        Game.level.grid = new int [][] {{1, 1, 1, 1, 1, 1, 1, 1}, {1, 4, 0, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 9, 1, 1, 1}, {1, 0, 0, 0, 0, 1, 1, 1}, {1, 0, 0, 0, 0, 0, 3, 1}, {1, 0, 0, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1}};
        Game.level.player = new Player (new int [] {6, 5});
        Game.level.power = new boolean [] {false};
        Game.level.weightedButtons = new WeightedButton [] {new WeightedButton(new int [] {1, 5}, 0)};
        Game.level.doors = new Door [] {new Door(new int [] {4, 3}, 0, 'W',0)};
    }
    static void Level3() {
        Game.level.grid = new int [][] {{1, 1, 1, 1, 1, 1}, {1, 9, 1, 1, 1, 1}, {1, 0, 0, 0, 4, 1}, {1, 0, 1, 1, 1, 1}, {1, 5, 1, 0, 0, 1}, {1, 0, 0, 0, 3, 1}, {1, 1, 1, 1, 1, 1}};
        Game.level.player = new Player (new int [] {4, 5});
        Game.level.boxes = new Box [] {new Box (new int [] {1, 4})};
        Game.level.power = new boolean [] {false};
        Game.level.weightedButtons = new WeightedButton [] {new WeightedButton(new int [] {3, 4}, 0)};
        Game.level.doors = new Door [] {new Door(new int [] {1, 1}, 0, 'W', 0)};
    }
    static void Level4() {
        Game.level.grid = new int [][] {{1, 1, 1, 1, 1, 1, 1, 1}, {1, 0, 0, 1, 1, 1, 4, 1}, {1, 0, 5, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 1, 1, 1, 1}, {1, 0, 0, 0, 1, 1, 1, 1}, {1, 0, 0, 0, 0, 0, 3, 1}, {1, 1, 0, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1}};    
        Game.level.player = new Player (new int [] {6, 5});
        Game.level.boxes = new Box [] {new Box (new int [] {2, 2})};
        Game.level.power = new boolean [] {false, false, true};
        Game.level.buttons = new Button [] {new Button(new int [] {2, 3}, 0), new Button(new int [] {6, 5}, 2)};
        Game.level.weightedButtons = new WeightedButton [] {new WeightedButton(new int [] {3, 5}, 1)};
        Game.level.doors = new Door [] {new Door(new int [] {4, 2}, 0, 'S', 0), new Door(new int [] {5, 2}, 0, 'S', 1), new Door(new int [] {5, 5}, 0, 'S', 2)};
    }
    static void Level5() {
        Game.level.grid = new int [][] {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 5, 0, 0, 0, 9, 0, 0, 0, 0, 0, 1}, {1, 0, 0, 5, 1, 9, 1, 5, 0, 0, 5, 1}, {1, 0, 5, 5, 1, 4, 1, 0, 0, 3, 0, 1}, {1, 0, 5, 0, 1, 1, 1, 0, 0, 0, 9, 1}, {1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        Game.level.player = new Player (new int [] {9, 3});
        Game.level.boxes = new Box [] {new Box (new int [] {1, 1}), new Box (new int [] {3, 2}), new Box (new int [] {7, 2}), new Box (new int [] {10, 2}), new Box (new int [] {2, 3}), new Box (new int [] {3, 3}), new Box (new int [] {2, 4})};
        Game.level.power = new boolean [] {false, false, false};
        Game.level.buttons = new Button [] {new Button(new int [] {7, 5}, 0), new Button(new int [] {10, 5}, 1), new Button(new int [] {3, 5}, 2)};
        Game.level.doors = new Door [] {new Door(new int [] {5, 1}, 0, 'N', 0), new Door(new int [] {5, 2}, 0, 'E', 1), new Door(new int [] {10, 4}, 0, 'E', 2)};
    }
    static void Level6() {
        Game.level.grid = new int [][] {{1, 1, 1, 1, 1, 1}, {1, 1, 1, 4, 1, 1}, {1, 1, 1, 9, 1, 1}, {1, 1, 1, 0, 1, 1}, {1, 1, 1, 0, 1, 1}, {1, 1, 0, 0, 0, 1}, {1, 1, 5, 5, 5, 1}, {1, 1, 0, 0, 0, 1}, {1, 3, 5, 0, 5, 1}, {1, 1, 0, 1, 0, 1}, {1, 1, 0, 0, 0, 1}, {1, 1, 1, 1, 1, 1}};
        Game.level.player = new Player (new int [] {1, 8});
        Game.level.boxes = new Box [] {new Box (new int [] {2, 6}), new Box (new int [] {3, 6}), new Box (new int [] {4, 6}), new Box (new int [] {2, 8}), new Box (new int [] {4, 8})};
        Game.level.power = new boolean [] {false, true, true};
        Game.level.buttons = new Button [] {new Button(new int [] {4, 10}, 0), new Button(new int [] {2, 6}, 1), new Button(new int [] {4, 6}, 2)};
        Game.level.doors = new Door [] {new Door(new int [] {3, 2}, 0, 'E', 0), new Door(new int [] {3, 3}, 0, 'W', 1), new Door(new int [] {3, 4}, 0, 'E', 2)};
    }
    static void Level7() {
        Game.level.grid = new int [][] {{1, 1, 1, 1, 1, 1, 1, 1}, {1, 4, 0, 9, 0, 0, 1, 1}, {1, 1, 1, 1, 0, 5, 0, 1}, {1, 1, 1, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 0, 0, 0, 1}, {1, 1, 0, 0, 0, 0, 1, 1}, {1, 1, 1, 1, 3, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1}};
        Game.level.player = new Player (new int [] {4, 6});
        Game.level.boxes = new Box [] {new Box (new int [] {5, 2})};
        Game.level.power = new boolean [] {true};
        Game.level.transmitters = new Transmitter [] {new Transmitter (new int [] {6, 4}, "W", 'B')};
        Game.level.receivers = new Receiver [] {new Receiver (new int [] {1, 4}, "W", 'B', 0)};
        Game.level.doors = new Door [] {new Door(new int [] {3, 1}, 1, 'S', 0)};
    } 
    static void Level8 () {
        Game.level.grid = new int [][] {{1, 1, 1, 1, 1, 1, 1}, {1, 4, 1, 1, 0, 0, 1}, {1, 9, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 0, 0, 1}, {1, 0, 7, 0, 0, 1, 1}, {1, 1, 3, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}};
        Game.level.player = new Player (new int [] {2, 5});
        Game.level.boxes = new Box [] {new Box (new int [] {2, 4})};
        Game.level.power = new boolean [] {true, false};
        Game.level.transmitters = new Transmitter [] {new Transmitter (new int [] {1, 5}, "NE", 'B')};
        Game.level.receivers = new Receiver [] {new Receiver (new int [] {2, 2}, "N", 'B', 0), new Receiver (new int [] {4, 1}, "N", 'B', 1)};
        Game.level.doors = new Door [] {new Door(new int [] {1, 2}, 0, 'W', 1)};
    }
    static void Level9 () {
        Game.level.grid = new int [][] {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1}, {1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 7, 0, 0, 1}, {1, 3, 0, 7, 0, 0, 1, 1, 0, 0, 1, 7, 0, 1}, {1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 7, 0, 0, 1}, {1, 1, 1, 0, 0, 0, 9, 0, 0, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 9, 1, 0, 0, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 4, 1, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        Game.level.player = new Player (new int [] {1, 3});
        Game.level.boxes = new Box [] {new Box (new int [] {10, 2}), new Box (new int [] {3, 3}), new Box (new int [] {11, 3}), new Box (new int [] {10, 4})};
        Game.level.power = new boolean [] {false, true, false};
        Game.level.transmitters = new Transmitter [] {new Transmitter (new int [] {10, 1}, "S", 'B'), new Transmitter (new int [] {2, 5}, "NE", 'B')};
        Game.level.receivers = new Receiver [] {new Receiver (new int [] {5, 4}, "E", 'B', 0), new Receiver (new int [] {12, 4}, "E", 'B', 1), new Receiver (new int [] {9, 11}, "W", 'B', 2)};
        Game.level.doors = new Door [] {new Door(new int [] {6, 5}, 0, 'N', 0), new Door(new int [] {11, 10}, 0, 'N', 1), new Door(new int [] {7, 9}, 0, 'E', 2)};
    }
    static void Level10 () {
        Game.level.grid = new int [][] {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 0, 0, 9, 0, 0, 0, 1, 1}, {1, 1, 0, 0, 1, 0, 0, 9, 0, 7, 0, 1, 1}, {1, 1, 0, 7, 9, 0, 0, 1, 1, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 9, 9, 1, 1, 0, 0, 0, 9, 0, 0, 1}, {1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1}, {1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 9, 1, 1}, {1, 0, 0, 7, 0, 0, 3, 0, 1, 1, 4, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        Game.level.player = new Player (new int [] {6, 8});
        Game.level.boxes = new Box [] {new Box (new int [] {9, 2}), new Box (new int [] {3, 3}), new Box (new int [] {3, 8})};
        Game.level.power = new boolean [] {false, false, false, false, false};
        Game.level.buttons = new Button [] {new Button(new int [] {11, 5}, 4)};
        Game.level.transmitters = new Transmitter [] {new Transmitter (new int [] {1, 9}, "NE", 'B')};
        Game.level.receivers = new Receiver [] {new Receiver (new int [] {6, 1}, "N", 'B', 0), new Receiver (new int [] {2, 3}, "W", 'B', 1), new Receiver (new int [] {6, 5}, "N", 'B', 2), new Receiver (new int [] {1, 7}, "W", 'B', 3)};
        Game.level.doors = new Door [] {new Door(new int [] {7, 1}, 0, 'N', 0), new Door(new int [] {7, 2}, 0, 'S', 0), new Door(new int [] {4, 3}, 0, 'N', 1), new Door(new int [] {9, 5}, 0, 'N', 2), new Door(new int [] {2, 5}, 0, 'W', 3), new Door(new int [] {3, 5}, 0, 'E', 3), new Door(new int [] {10, 7}, 0, 'E', 4)};
    }
    static void Level11 () {
        Game.level.grid = new int [][] {{1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 0, 7, 0, 0, 0, 0, 4, 1}, {1, 3, 7, 0, 0, 0, 1, 1, 1}, {1, 0, 7, 0, 0, 1, 1, 1, 1}, {1, 1, 1, 1, 0, 1, 1, 1, 1}, {1, 1, 1, 1, 0, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1}};
        Game.level.player = new Player (new int [] {1, 2});
        Game.level.boxes = new Box [] {new Box (new int [] {2, 1}), new Box (new int [] {2, 2}), new Box (new int [] {2, 3})};
        Game.level.power = new boolean [] {true};
        Game.level.transmitters = new Transmitter [] {new Transmitter (new int [] {4, 1}, "S", 'B')};
        Game.level.receivers = new Receiver [] {new Receiver (new int [] {4, 5}, "S", 'B', 0)};
        Game.level.doors = new Door [] {new Door(new int [] {6, 1}, 0, 'S', 0), new Door(new int [] {4, 4}, 0, 'E', 0)};
    }
    static void Level12 () {
        Game.level.grid = new int [][] {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1}, {1, 1, 1, 0, 0, 9, 0, 0, 0, 0, 1, 7, 0, 1, 1}, {1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1}, {1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 9, 0, 0, 1, 1}, {1, 0, 0, 7, 0, 1, 1, 1, 0, 0, 9, 0, 0, 0, 1}, {1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1}, {1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, {1, 0, 0, 1, 9, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 0, 1, 1, 1, 9, 9, 4, 1, 1, 1, 1}, {1, 1, 0, 7, 0, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        Game.level.player = new Player (new int [] {5, 10});
        Game.level.boxes = new Box [] {new Box (new int [] {11, 2}), new Box (new int [] {3, 5}), new Box (new int [] {3, 10})};
        Game.level.power = new boolean [] {false, false, false, false};
        Game.level.buttons = new Button [] {new Button(new int [] {1, 9}, 3)};
        Game.level.transmitters = new Transmitter [] {new Transmitter (new int [] {5, 10}, "W", 'B'), new Transmitter (new int [] {13, 1}, "SW", 'B')};
        Game.level.receivers = new Receiver [] {new Receiver (new int [] {4, 4}, "N", 'B', 0), new Receiver (new int [] {13, 5}, "E", 'B', 1),  new Receiver (new int [] {9, 7}, "S", 'B', 2)};
        Game.level.doors = new Door [] {new Door(new int [] {10, 4}, 0, 'N', 0), new Door(new int [] {10, 5}, 0, 'S', 0), new Door(new int [] {5, 2}, 0, 'S', 1), new Door(new int [] {4, 8}, 0, 'E', 1), new Door(new int [] {9, 9}, 0, 'N', 2), new Door(new int [] {8, 9}, 0, 'W', 3)};
    }
    static void Level13 () {
        Game.level.grid = new int [][] {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1}, {1, 1, 0, 0, 0, 0, 0, 0, 1, 4, 1, 1}, {1, 1, 0, 0, 1, 0, 0, 0, 1, 9, 1, 1}, {1, 0, 0, 0, 0, 7, 0, 0, 1, 0, 0, 1}, {1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1}, {1, 1, 0, 0, 0, 0, 0, 0, 9, 0, 0, 1}, {1, 1, 1, 1, 0, 0, 0, 1, 1, 8, 0, 1}, {1, 1, 1, 1, 1, 3, 1, 1, 1, 0, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        Game.level.player = new Player (new int [] {5, 9});
        Game.level.boxes = new Box [] {new Box (new int [] {5, 5}), new Box (new int [] {9, 8})};
        Game.level.power = new boolean [] {false, false};
        Game.level.transmitters = new Transmitter [] {new Transmitter (new int [] {5, 1}, "S", 'R'), new Transmitter (new int [] {2, 7}, "E", 'B')};
        Game.level.receivers = new Receiver [] {new Receiver (new int [] {7, 3}, "N", 'B', 0), new Receiver (new int [] {1, 5}, "W", 'R', 1)};
        Game.level.doors = new Door [] {new Door(new int [] {8, 7}, 0, 'N', 0), new Door(new int [] {9, 4}, 0, 'E', 1)};
    }
    static void Level14 () {
        Game.level.grid = new int [][] {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1}, {1, 0, 9, 8, 0, 0, 0, 0, 0, 0, 0, 0, 1}, {1, 1, 0, 0, 7, 1, 1, 1, 0, 0, 0, 1, 1}, {1, 1, 1, 1, 0, 1, 1, 1, 0, 8, 0, 9, 1}, {1, 0, 4, 0, 0, 0, 0, 9, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        Game.level.player = new Player (new int [] {6, 2});
        Game.level.boxes = new Box [] {new Box (new int [] {3, 2}), new Box (new int [] {4, 3}), new Box (new int [] {9, 4})};
        Game.level.power = new boolean [] {false, false, false, true};
        Game.level.buttons = new Button [] {new Button(new int [] {9, 4}, 3)};
        Game.level.transmitters = new Transmitter [] {new Transmitter (new int [] {9, 1}, "S", 'R'), new Transmitter (new int [] {1, 2}, "E", 'R'), new Transmitter (new int [] {11, 4}, "W", 'B')};
        Game.level.receivers = new Receiver [] {new Receiver (new int [] {10, 2}, "N", 'R', 0), new Receiver (new int [] {11, 2}, "S", 'R', 1), new Receiver (new int [] {8, 4}, "W", 'B', 2)};
        Game.level.doors = new Door [] {new Door(new int [] {2, 2}, 0, 'N', 0), new Door(new int [] {11, 4}, 0, 'N', 1), new Door(new int [] {7, 5}, 0, 'N', 2), new Door(new int [] {3, 5}, 0, 'S', 3)};
    }
    static void Level15 () {
        Game.level.grid = new int [][] {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1}, {1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1}, {1, 1, 0, 0, 6, 0, 0, 9, 0, 6, 0, 9, 4, 1}, {1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1}, {1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1}, {1, 0, 0, 0, 0, 0, 0, 9, 0, 6, 0, 1, 1, 1}, {1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        Game.level.player = new Player (new int [] {4, 5});
        Game.level.boxes = new Box [] {new Box (new int [] {4, 3}), new Box (new int [] {9, 3}), new Box (new int [] {9, 7})};
        Game.level.power = new boolean [] {false, false, true, false};
        Game.level.transmitters = new Transmitter [] {new Transmitter (new int [] {4, 2}, "S", 'B'), new Transmitter (new int [] {2, 3}, "E", 'R')};
        Game.level.receivers = new Receiver [] {new Receiver (new int [] {9, 1}, "N", 'B', 0), new Receiver (new int [] {10, 7}, "E", 'R', 1), new Receiver (new int [] {6, 5}, "E", 'B', 2), new Receiver (new int [] {1, 7}, "S", 'R', 3)};
        Game.level.doors = new Door [] {new Door(new int [] {11, 3}, 0, 'N', 0), new Door(new int [] {7, 3}, 0, 'S', 1), new Door(new int [] {9, 5}, 0, 'W', 2), new Door(new int [] {7, 7}, 0, 'S', 3)};
    }
    static void Level16 () {
        Game.level.grid = new int [][] {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1}, {1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1}, {1, 0, 0, 9, 0, 0, 0, 0, 9, 0, 0, 6, 0, 1}, {1, 0, 8, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1}, {1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 9, 1, 1}, {1, 1, 1, 1, 1, 0, 7, 1, 1, 1, 1, 0, 0, 1}, {1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1}, {1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1}, {1, 1, 1, 1, 1, 9, 1, 1, 1, 1, 0, 0, 0, 1}, {1, 1, 1, 1, 0, 0, 0, 0, 0, 9, 0, 0, 1, 1}, {1, 1, 1, 1, 0, 0, 7, 3, 0, 1, 0, 0, 9, 1}, {1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 4, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        Game.level.player = new Player (new int [] {7, 11});
        Game.level.boxes = new Box [] {new Box (new int [] {11, 3}), new Box (new int [] {2, 4}), new Box (new int [] {6, 6}), new Box (new int [] {6, 11})};
        Game.level.power = new boolean [] {false, false, false, false, false, false};
        Game.level.transmitters = new Transmitter [] {new Transmitter (new int [] {12, 1}, "SW", 'R'), new Transmitter (new int [] {8, 12}, "W", 'B')};
        Game.level.receivers = new Receiver [] {new Receiver (new int [] {5, 2}, "W", 'B', 0), new Receiver (new int [] {7, 5}, "E", 'B', 1), new Receiver (new int [] {9, 4}, "S", 'R', 2), new Receiver (new int [] {10, 7}, "W", 'R', 3), new Receiver (new int [] {12, 9}, "E", 'B', 4), new Receiver (new int [] {7, 10}, "N", 'B', 5)};
        Game.level.doors = new Door [] {new Door(new int [] {3, 3}, 0, 'N', 0), new Door(new int [] {8, 3}, 0, 'S', 1), new Door(new int [] {11, 5}, 0, 'W', 2), new Door(new int [] {9, 10}, 0, 'N', 3), new Door(new int [] {12, 11}, 0, 'E', 4), new Door(new int [] {5, 9}, 0, 'E', 5)};
    }
    static void Level17 () {
        Game.level.grid = new int [][] {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1}, {1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1}, {1, 0, 6, 0, 0, 9, 0, 0, 6, 0, 1}, {1, 0, 0, 0, 0, 9, 0, 0, 0, 0, 1}, {1, 1, 9, 1, 1, 1, 1, 1, 9, 9, 1}, {1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1}, {1, 1, 0, 0, 0, 1, 1, 0, 6, 0, 1}, {1, 1, 0, 6, 0, 9, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1}, {1, 1, 0, 3, 1, 1, 1, 1, 0, 0, 1}, {1, 1, 1, 9, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 4, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        Game.level.player = new Player (new int [] {3, 10});
        Game.level.boxes = new Box [] {new Box (new int [] {2, 3}), new Box (new int [] {8, 3}), new Box (new int [] {8, 7}), new Box (new int [] {3, 8})};
        Game.level.power = new boolean [] {false, false, false, false, false};
        Game.level.transmitters = new Transmitter [] {new Transmitter (new int [] {8, 1}, "S", 'B'), new Transmitter (new int [] {1, 10}, "NE", 'R')};
        Game.level.receivers = new Receiver [] {new Receiver (new int [] {4, 1}, "E", 'R', 0), new Receiver (new int [] {9, 2}, "E", 'R', 1), new Receiver (new int [] {2, 7}, "W", 'R', 2), new Receiver (new int [] {7, 7}, "W", 'B', 3), new Receiver (new int [] {2, 10}, "S", 'B', 4)};
        Game.level.doors = new Door [] {new Door(new int [] {5, 3}, 0, 'N', 0), new Door(new int [] {5, 4}, 0, 'S', 0), new Door(new int [] {8, 5}, 0, 'W', 1), new Door(new int [] {9, 5}, 0, 'E', 1), new Door(new int [] {2, 5}, 0, 'E', 2), new Door(new int [] {5, 8}, 0, 'N', 3), new Door(new int [] {3, 11}, 0, 'W', 4)};
    }
    static void Level18 () {
        Game.level.grid = new int [][] {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 0, 1, 1, 9, 4, 1}, {1, 1, 1, 1, 1, 0, 0, 1, 9, 1, 1}, {1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1}, {1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1}, {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1}, {1, 1, 0, 0, 6, 0, 6, 0, 6, 0, 1}, {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1}, {1, 1, 9, 1, 1, 0, 0, 1, 9, 1, 1}, {1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        Game.level.player = new Player (new int [] {5, 10});
        Game.level.boxes = new Box [] {new Box (new int [] {4, 6}), new Box (new int [] {6, 6}), new Box (new int [] {8, 6})};
        Game.level.power = new boolean [] {false, false, false, false};
        Game.level.transmitters = new Transmitter [] {new Transmitter (new int [] {3, 3}, "S", 'R'), new Transmitter (new int [] {2, 9}, "N", 'B'), new Transmitter (new int [] {8, 9}, "N", 'B')};
        Game.level.receivers = new Receiver [] {new Receiver (new int [] {5, 1}, "W", 'B', 0), new Receiver (new int [] {2, 3}, "W", 'R', 1), new Receiver (new int [] {5, 5}, "N", 'B', 2), new Receiver (new int [] {6, 9}, "E", 'R', 3)};
        Game.level.doors = new Door [] {new Door(new int [] {8, 1}, 0, 'N', 0), new Door(new int [] {8, 2}, 0, 'W', 1), new Door(new int [] {8, 9}, 0, 'E', 2), new Door(new int [] {2, 9}, 0, 'E', 3)};
    }
    static void Level19 () {
        Game.level.grid = new int [][] {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 4, 9, 0, 0, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 9, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1}, {1, 3, 8, 0, 0, 1, 0, 8, 0, 1, 1}, {1, 1, 0, 0, 0, 9, 0, 0, 0, 1, 1}, {1, 1, 1, 0, 0, 9, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        Game.level.player = new Player (new int [] {1, 5});
        Game.level.boxes = new Box [] {new Box (new int [] {2, 5}), new Box (new int [] {7, 5})};
        Game.level.power = new boolean [] {false, false, false};
        Game.level.buttons = new Button [] {new Button(new int [] {9, 1}, 0)};
        Game.level.transmitters = new Transmitter [] {new Transmitter (new int [] {4, 8}, "N", 'R')};
        Game.level.receivers = new Receiver [] {new Receiver (new int [] {6, 4}, "W", 'R', 1), new Receiver (new int [] {3, 7}, "W", 'R', 2)};
        Game.level.doors = new Door [] {new Door(new int [] {6, 1}, 0, 'N', 0), new Door(new int [] {8, 3}, 0, 'W', 1), new Door(new int [] {5, 6}, 0, 'N', 2), new Door(new int [] {5, 7}, 0, 'S', 2)};
    }
    static void Level20 () {
        Game.level.grid = new int [][] {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 4, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 9, 1, 1, 1, 1, 1, 1}, {1, 1, 0, 0, 0, 0, 0, 0, 0, 8, 0, 1}, {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1}, {1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1}, {1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1}, {1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1}, {1, 1, 1, 1, 0, 0, 0, 0, 9, 0, 0, 1}, {1, 1, 1, 1, 0, 0, 7, 0, 1, 1, 1, 1}, {1, 1, 1, 1, 0, 3, 0, 0, 1, 1, 1, 1}, {1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 9, 9, 1, 1, 1, 1, 1, 1}, {1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, {1, 0, 0, 6, 0, 6, 0, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        Game.level.player = new Player (new int [] {5, 10});
        Game.level.boxes = new Box [] {new Box (new int [] {9, 3}), new Box (new int [] {6, 9}), new Box (new int [] {3, 14}), new Box (new int [] {5, 14})};
        Game.level.power = new boolean [] {false, false, false};
        Game.level.transmitters = new Transmitter [] {new Transmitter (new int [] {7, 10}, "W", 'B'), new Transmitter (new int [] {6, 15}, "W", 'R')};
        Game.level.receivers = new Receiver [] {new Receiver (new int [] {2, 3}, "W", 'R', 0), new Receiver (new int [] {4, 8}, "N", 'B', 1), new Receiver (new int [] {1, 14}, "W", 'B', 2)};
        Game.level.doors = new Door [] {new Door(new int [] {5, 2}, 0, 'W', 0), new Door(new int [] {4, 12}, 0, 'W', 1), new Door(new int [] {5, 12}, 0, 'E', 1), new Door(new int [] {8, 8}, 0, 'S', 2)};
    }
    static void Level21 () {
        Game.level.grid = new int [][] {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 2, 0, 0, 1, 1}, {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 0, 4, 0, 1}, {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 1, 1}, {1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 2, 1, 2, 1, 1, 1}, {1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 1, 1}, {1, 0, 0, 1, 0, 0, 0, 0, 3, 0, 0, 1, 0, 6, 0, 0, 0, 1}, {1, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 1}, {1, 0, 0, 1, 0, 0, 0, 1, 2, 1, 2, 1, 2, 1, 0, 0, 0, 1}, {1, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 0, 0, 0, 1}, {1, 0, 0, 1, 0, 6, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1}, {1, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 1}, {1, 1, 0, 1, 1, 1, 2, 1, 2, 1, 2, 1, 2, 1, 0, 0, 0, 1}, {1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, {1, 1, 0, 0, 9, 0, 0, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        Game.level.player = new Player (new int [] {8, 7});
        Game.level.boxes = new Box [] {new Box (new int [] {13, 7}), new Box (new int [] {5, 11}), new Box (new int [] {9, 15})};
        Game.level.power = new boolean [] {false, false, false};
        Game.level.transmitters = new Transmitter [] {new Transmitter (new int [] {5, 6}, "SE", 'B'), new Transmitter (new int [] {2, 15}, "E", 'R')};
        Game.level.receivers = new Receiver [] {new Receiver (new int [] {12, 1}, "E", 'R', 0), new Receiver (new int [] {12, 11}, "E", 'B', 1), new Receiver (new int [] {5, 14}, "W", 'B', 2)};
        Game.level.doors = new Door [] {new Door(new int [] {13, 3}, 0, 'N', 0), new Door(new int [] {13, 10}, 0, 'S', 1), new Door(new int [] {4, 15}, 0, 'N', 2)};
    }
    static void Level22 () {
        Game.level.grid = new int [][] {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 0, 9, 0, 1, 1, 1, 1}, {1, 1, 1, 0, 0, 2, 0, 0, 1, 1, 1}, {1, 0, 0, 0, 0, 2, 0, 0, 1, 1, 1}, {1, 0, 0, 6, 0, 2, 0, 6, 0, 0, 1}, {1, 0, 0, 0, 0, 2, 0, 0, 0, 1, 1}, {1, 0, 0, 3, 0, 2, 0, 0, 1, 1, 1}, {1, 1, 0, 0, 0, 2, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1}, {1, 1, 1, 4, 9, 0, 0, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        Game.level.player = new Player (new int [] {3, 6});
        Game.level.boxes = new Box [] {new Box (new int [] {3, 4}), new Box (new int [] {7, 4})};
        Game.level.power = new boolean [] {false, false};
        Game.level.transmitters = new Transmitter [] {new Transmitter (new int [] {1, 3}, "E", 'B'), new Transmitter (new int [] {9, 3}, "SW", 'R')};
        Game.level.receivers = new Receiver [] {new Receiver (new int [] {1, 6}, "W", 'B', 0), new Receiver (new int [] {4, 7}, "S", 'R', 1)};
        Game.level.doors = new Door [] {new Door(new int [] {5, 1}, 0, 'S', 0), new Door(new int [] {4, 9}, 0, 'N', 1)};
    }
}   