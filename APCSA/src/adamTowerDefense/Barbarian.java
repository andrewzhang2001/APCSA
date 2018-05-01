package adamTowerDefense;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
public class Barbarian extends Enemy{
	private Image image;
	public Barbarian(int x, int y, int hp, int dmg){
		super(x,y,hp,dmg,1);
		try{
			image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\adamTowerDefense\\barbarian.png"));
		}
		catch(Exception e){
			System.out.println("CANT LOAD BARBARIAN.PNG");
		}
	}
	public void draw(Graphics window){
		window.drawImage(image, x, y, 90, 90, null);
	}
}
