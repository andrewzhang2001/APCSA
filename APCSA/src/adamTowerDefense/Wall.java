package adamTowerDefense;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
public class Wall extends Building{
	public Wall(int row, int col, int hp){
		super(row,col,hp);
	}
	public void draw(Graphics window){
		window.setColor(Color.BLUE);
		window.fillRect(getCol()*30, getRow()*30, 30, 30);
	}
}	
