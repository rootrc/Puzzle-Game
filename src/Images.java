import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

class Images {
	static Image nextIcon;
	static Image restartIcon;
	static Image menuIcon;
	static Image returnIcon;
	static Image hintIcon;
	static Image player;
	static Image box;
	static Image connecterWhite;
	static Image connecterBlue;
	static Image connecterRed;
	static Image weightedButtonOn;
	static Image weightedButtonOff;
	static Image buttonOn;
	static Image buttonOff;
	static Image star;
	static Image[] levels = new Image[24];
	static Image[] receiversOn = new Image[8];
	static Image[] receiversOff = new Image[8];
	static Image[][] doors = new Image[4][5];
	static Image[][] wires = new Image[24][];

	// load all the images
	Images() {
		try{
			nextIcon = ImageIO.read(new File("Images/Next Icon.png"));
			restartIcon = ImageIO.read(new File("Images/Restart Icon.png"));
			menuIcon = ImageIO.read(new File("Images/Menu Icon.png"));
			returnIcon = ImageIO.read(new File("Images/Return Icon.png"));
			hintIcon = ImageIO.read(new File("Images/Hint Icon.png"));
			
			player = ImageIO.read(new File("Images/Player.png"));
			box = ImageIO.read(new File("Images/Box.png"));
			connecterWhite = ImageIO.read(new File("Images/Connecter.png"));
			connecterBlue = ImageIO.read(new File("Images/Connecter Blue.png"));
			connecterRed = ImageIO.read(new File("Images/Connecter Red.png"));
			weightedButtonOn = ImageIO.read(new File("Images/Weighted Button On.png"));
			weightedButtonOff = ImageIO.read(new File("Images/Weighted Button Off.png"));
			buttonOn = ImageIO.read(new File("Images/Button On.png"));
			buttonOff = ImageIO.read(new File("Images/Button Off.png"));
			star = ImageIO.read(new File("Images/Star.png"));
			for (int i = 0; i < 24; i++) {
				levels[i] = ImageIO.read(new File("Images/Level " + (i + 1) + ".png"));
			}
			int idx = 0;
			for (String colour: new String[]{"Blue", "Red"}) {
				for (char direction: "NWSE".toCharArray()) {
					receiversOn[idx] = ImageIO.read(new File("Images/Receiver " + colour + " " + direction +" On.png"));
					receiversOff[idx] = ImageIO.read(new File("Images/Receiver " + colour + " " + direction +" OFF.png"));
					idx++;
				}
			}
			idx = 0;
			for (char direction: "wasd".toCharArray()) {
				for (int i = 0; i <= 4; i++) {
					doors[idx][i] = ImageIO.read(new File("Images/Door " + direction + " " + i +".png"));
				}
				idx++;
			}
			int[] wireCount = new int[] {0, 1, 1, 3, 1, 3, 1, 2, 2, 3, 2, 4, 2, 4, 4, 7, 5, 4, 3, 3, 5, 2, 4, 4};
			for (int i = 0; i < 24; i++) {
				wires[i] = new Image[wireCount[i]];
				for (int j = 0; j < wireCount[i]; j++) {
					wires[i][j] = ImageIO.read(new File("Images/" + (i + 1) + "wire" + j +".png"));
				}
			}
		} catch (IOException e) {
        }
	}
}