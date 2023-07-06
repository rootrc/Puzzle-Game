import java.awt.event.MouseEvent;

class LevelMenu {
    static void mouseClicked(MouseEvent e) {
        if (Game.gameState == 0) {
            for (int x = 0; x < 6; x ++) {
                for (int y = 0; y < 4; y ++) {
                    if (x * 128 + 136 < e.getX() && e.getX() < x * 128 + 232 && y * 144 + 132 < e.getY() && e.getY() < y * 144 + 228) {
                        Game.gameState = 1 + x + y * 6; 
                        Game.level = new Level();
                        LevelData.setUp();
                    }
                }
            }
        }
    }

}