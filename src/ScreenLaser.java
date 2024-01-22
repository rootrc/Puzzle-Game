import java.awt.geom.Line2D;
import java.util.Arrays;
import java.util.List;

class ScreenLaser {
    char colour;
    Line2D line;
    List<Integer> startAndEnd;
    List<Integer> endAndStart;

    ScreenLaser(int[] start, int[] end, char colour) {
        // stores and reformats information about a laser
        this.line = new Line2D.Float(start[0] + Game.getInstance().level.adjustX, start[1] + Game.getInstance().level.adjustY, end[0] + Game.getInstance().level.adjustX, end[1] + Game.getInstance().level.adjustY);
        this.startAndEnd = Arrays.asList(start[0], start[1], end[0], end[1]);
        this.endAndStart = Arrays.asList(end[0], end[1], start[0], start[1]);
        this.colour = colour;
    }
}
