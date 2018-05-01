package adamTowerDefense;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
public class InfernoTower extends DamagingBuilding{
	public InfernoTower(int r, int c, int hp, int dmg, int range){
		super(r,c,hp,dmg,range);
		this.width=2;
		this.height=3;
		try{
			image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\adamTowerDefense\\infernoTower.png"));
		}
		catch(Exception e){
			System.out.println("CANT LOAD INFERNO TOWER");
		}
		
	}
	public void draw(Graphics window){
		window.drawImage(image, X, Y, 60,90,null);
	}
}
