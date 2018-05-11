package adamTowerDefense;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
public class ArcherTower extends DamagingBuilding {

	public ArcherTower(int r, int c, int hp, int dmg, int range){
		super(r,c,hp,dmg,range);
		this.width=3;
		this.height = 3;
		cost = 5000;
		try{
			image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\adamTowerDefense\\archerTower.png"));
		}
		catch(Exception e){
			System.out.println("CANT LOAD ARCHER TOWER");
		}
		shootThreshold = 3000;
	}

	public void draw(Graphics window){
		window.drawImage(image, X, Y, 90, 90, null);
	}
}
