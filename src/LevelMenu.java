import java.awt.event.MouseEvent;

class LevelMenu {
    static boolean [] starsCollected = new boolean [] {false, false, false};
    static void mouseClicked(MouseEvent e) {
        if (Game.gameState == 0) {
            for (int x = 0; x < 6; x ++) {
                for (int y = 0; y < 4; y ++) {
                    if (x * 128 + 136 < e.getX() && e.getX() < x * 128 + 232 && y * 144 + 132 < e.getY() && e.getY() < y * 144 + 228) {
                        try {
                            Thread.sleep(50);
                        } catch (Exception execption) {
        
                        }
                        Game.gameState = 1 + x + y * 6; 
                        Game.level = new Level();
                        LevelData.setUp();
                    }
                }
            }
        }
    }

}