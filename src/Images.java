import javax.swing.*;
import java.awt.*;

class Images {
    final static Image nextIcon = new ImageIcon("Images/Next Icon.png").getImage();
    final static Image restartIcon = new ImageIcon("Images/Restart Icon.png").getImage();
    final static Image menuIcon = new ImageIcon("Images/Menu Icon.png").getImage();
    final static Image[] levels = {new ImageIcon("Images/Level 1.png").getImage(),
            new ImageIcon("Images/Level 2.png").getImage(),
            new ImageIcon("Images/Level 3.png").getImage(),
            new ImageIcon("Images/Level 4.png").getImage(),
            new ImageIcon("Images/Level 5.png").getImage(),
            new ImageIcon("Images/Level 6.png").getImage(),
            new ImageIcon("Images/Level 7.png").getImage(),
            new ImageIcon("Images/Level 8.png").getImage(),
            new ImageIcon("Images/Level 9.png").getImage(),
            new ImageIcon("Images/Level 10.png").getImage(),
            new ImageIcon("Images/Level 11.png").getImage(),
            new ImageIcon("Images/Level 12.png").getImage(),
            new ImageIcon("Images/Level 13.png").getImage(),
            new ImageIcon("Images/Level 14.png").getImage(),
            new ImageIcon("Images/Level 15.png").getImage(),
            new ImageIcon("Images/Level 16.png").getImage(),
            new ImageIcon("Images/Level 17.png").getImage(),
            new ImageIcon("Images/Level 18.png").getImage(),
            new ImageIcon("Images/Level 19.png").getImage(),
            new ImageIcon("Images/Level 20.png").getImage(),
            new ImageIcon("Images/Level 21.png").getImage(),
            new ImageIcon("Images/Level 22.png").getImage(),
            new ImageIcon("Images/Level 23.png").getImage(),
            new ImageIcon("Images/Level 24.png").getImage()};
    final static Image player = new ImageIcon("Images/Player.png").getImage();
    final static Image box = new ImageIcon("Images/Box.png").getImage();
    final static Image connecterWhite = new ImageIcon("Images/Connecter.png").getImage();
    final static Image connecterBlue = new ImageIcon("Images/Connecter Blue.png").getImage();
    final static Image connecterRed = new ImageIcon("Images/Connecter Red.png").getImage();
    final static Image weightedButtonOn = new ImageIcon("Images/Weighted Button On.png").getImage();
    final static Image weightedButtonOff = new ImageIcon("Images/Weighted Button Off.png").getImage();
    final static Image buttonOn = new ImageIcon("Images/Button On.png").getImage();
    final static Image buttonOff = new ImageIcon("Images/Button Off.png").getImage();
    final static Image[] receiversOn = {new ImageIcon("Images/Receiver Blue N On.png").getImage(),
            new ImageIcon("Images/Receiver Blue W On.png").getImage(),
            new ImageIcon("Images/Receiver Blue S On.png").getImage(),
            new ImageIcon("Images/Receiver Blue E On.png").getImage(),
            new ImageIcon("Images/Receiver Red N On.png").getImage(),
            new ImageIcon("Images/Receiver Red W On.png").getImage(),
            new ImageIcon("Images/Receiver Red S On.png").getImage(),
            new ImageIcon("Images/Receiver Red E On.png").getImage()};
    final static Image[] receiversOff = {new ImageIcon("Images/Receiver Blue N Off.png").getImage(),
            new ImageIcon("Images/Receiver Blue W Off.png").getImage(),
            new ImageIcon("Images/Receiver Blue S Off.png").getImage(),
            new ImageIcon("Images/Receiver Blue E Off.png").getImage(),
            new ImageIcon("Images/Receiver Red N Off.png").getImage(),
            new ImageIcon("Images/Receiver Red W Off.png").getImage(),
            new ImageIcon("Images/Receiver Red S Off.png").getImage(),
            new ImageIcon("Images/Receiver Red E Off.png").getImage()};
    final static Image[][] doors = {
            {new ImageIcon("Images/Door w 0.png").getImage(),
                    new ImageIcon("Images/Door w 1.png").getImage(),
                    new ImageIcon("Images/Door w 2.png").getImage(),
                    new ImageIcon("Images/Door w 3.png").getImage(),
                    new ImageIcon("Images/Door w 4.png").getImage()},
            {new ImageIcon("Images/Door a 0.png").getImage(),
                    new ImageIcon("Images/Door a 1.png").getImage(),
                    new ImageIcon("Images/Door a 2.png").getImage(),
                    new ImageIcon("Images/Door a 3.png").getImage(),
                    new ImageIcon("Images/Door a 4.png").getImage()},
            {new ImageIcon("Images/Door s 0.png").getImage(),
                    new ImageIcon("Images/Door s 1.png").getImage(),
                    new ImageIcon("Images/Door s 2.png").getImage(),
                    new ImageIcon("Images/Door s 3.png").getImage(),
                    new ImageIcon("Images/Door s 4.png").getImage()},
            {new ImageIcon("Images/Door d 0.png").getImage(),
                    new ImageIcon("Images/Door d 1.png").getImage(),
                    new ImageIcon("Images/Door d 2.png").getImage(),
                    new ImageIcon("Images/Door d 3.png").getImage(),
                    new ImageIcon("Images/Door d 4.png").getImage()}};
    final static Image star = new ImageIcon("Images/Star.png").getImage();
    final static Image[][] wires = new Image[][]{new Image[]{},
            new Image[]{new ImageIcon("Images/2wire0.png").getImage()},
            new Image[]{new ImageIcon("Images/3wire0.png").getImage()},
            new Image[]{new ImageIcon("Images/4wire0.png").getImage(),
                    new ImageIcon("Images/4wire1.png").getImage(),
                    new ImageIcon("Images/4wire2.png").getImage()},
            new Image[]{new ImageIcon("Images/5wire0.png").getImage()},
            new Image[]{new ImageIcon("Images/6wire0.png").getImage(),
                    new ImageIcon("Images/6wire1.png").getImage(),
                    new ImageIcon("Images/6wire2.png").getImage()},
            new Image[]{new ImageIcon("Images/7wire0.png").getImage()},
            new Image[]{new ImageIcon("Images/8wire0.png").getImage(),
                    new ImageIcon("Images/8wire1.png").getImage()},
            new Image[]{new ImageIcon("Images/9wire0.png").getImage(),
                    new ImageIcon("Images/9wire1.png").getImage()},
            new Image[]{new ImageIcon("Images/10wire0.png").getImage(),
                    new ImageIcon("Images/10wire1.png").getImage(),
                    new ImageIcon("Images/10wire2.png").getImage()},
            new Image[]{new ImageIcon("Images/11wire0.png").getImage(),
                    new ImageIcon("Images/11wire1.png").getImage()},
            new Image[]{new ImageIcon("Images/12wire0.png").getImage(),
                    new ImageIcon("Images/12wire1.png").getImage(),
                    new ImageIcon("Images/12wire2.png").getImage(),
                    new ImageIcon("Images/12wire3.png").getImage()},
            new Image[]{new ImageIcon("Images/13wire0.png").getImage(),
                    new ImageIcon("Images/13wire1.png").getImage()},
            new Image[]{new ImageIcon("Images/14wire0.png").getImage(),
                    new ImageIcon("Images/14wire1.png").getImage(),
                    new ImageIcon("Images/14wire2.png").getImage(),
                    new ImageIcon("Images/14wire3.png").getImage()},
            new Image[]{new ImageIcon("Images/15wire0.png").getImage(),
                    new ImageIcon("Images/15wire1.png").getImage(),
                    new ImageIcon("Images/15wire2.png").getImage(),
                    new ImageIcon("Images/15wire3.png").getImage()},
            new Image[]{new ImageIcon("Images/16wire0.png").getImage(),
                    new ImageIcon("Images/16wire1.png").getImage(),
                    new ImageIcon("Images/16wire2.png").getImage(),
                    new ImageIcon("Images/16wire3.png").getImage(),
                    new ImageIcon("Images/16wire4.png").getImage(),
                    new ImageIcon("Images/16wire5.png").getImage(),
                    new ImageIcon("Images/16wire6.png").getImage()},
            new Image[]{new ImageIcon("Images/17wire0.png").getImage(),
                    new ImageIcon("Images/17wire1.png").getImage(),
                    new ImageIcon("Images/17wire2.png").getImage(),
                    new ImageIcon("Images/17wire3.png").getImage(),
                    new ImageIcon("Images/17wire4.png").getImage()},
            new Image[]{new ImageIcon("Images/18wire0.png").getImage(),
                    new ImageIcon("Images/18wire1.png").getImage(),
                    new ImageIcon("Images/18wire2.png").getImage(),
                    new ImageIcon("Images/18wire3.png").getImage()},
            new Image[]{new ImageIcon("Images/19wire0.png").getImage(),
                    new ImageIcon("Images/19wire1.png").getImage(),
                    new ImageIcon("Images/19wire2.png").getImage()},
            new Image[]{new ImageIcon("Images/20wire0.png").getImage(),
                    new ImageIcon("Images/20wire1.png").getImage(),
                    new ImageIcon("Images/20wire2.png").getImage()},
            new Image[]{new ImageIcon("Images/21wire0.png").getImage(),
                    new ImageIcon("Images/21wire1.png").getImage(),
                    new ImageIcon("Images/21wire2.png").getImage(),
                    new ImageIcon("Images/21wire3.png").getImage(),
                    new ImageIcon("Images/21wire4.png").getImage()},
            new Image[]{new ImageIcon("Images/22wire0.png").getImage(),
                    new ImageIcon("Images/22wire1.png").getImage()},
            new Image[]{new ImageIcon("Images/23wire0.png").getImage(),
                    new ImageIcon("Images/23wire1.png").getImage(),
                    new ImageIcon("Images/23wire2.png").getImage(),
                    new ImageIcon("Images/23wire3.png").getImage()},
            new Image[]{new ImageIcon("Images/24wire0.png").getImage(),
                    new ImageIcon("Images/24wire1.png").getImage(),
                    new ImageIcon("Images/24wire2.png").getImage(),
                    new ImageIcon("Images/24wire3.png").getImage()}};
}