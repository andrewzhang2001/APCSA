package adamTowerDefense;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
public class GoldMine extends NondamagingBuilding{
	private Image image;
	public GoldMine(int r, int c, int hp){
		super(r,c,hp);
		try{
			image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\adamTowerDefense\\goldmine.png"));
		}
		catch(Exception e){
			System.out.println("CANT OPEN GOLDMINE.PNG");
		}
	}
	public void draw(Graphics window){
		window.drawImage(image, X, Y, 90, 90, null);
	}
}
