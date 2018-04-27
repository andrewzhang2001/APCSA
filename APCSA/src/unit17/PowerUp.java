package unit17;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
public class PowerUp implements Locatable{
	private int xPos;
	private int yPos;
	private Image image;
	
	public PowerUp(int x, int y){
		setPos(x,y);
	}
	public void setPos(int x, int y){
		xPos = x;
		yPos = y;
		try{
			image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\unit17\\pu.jpg"));
		}
		catch(Exception e){
			System.out.println("HI");
		}
	}
	public int getX(){
		return xPos;
	}
	public int getY(){
		return yPos;
	}
	public void setX(int x){
		xPos = x;
	}
	public void setY(int y){
		yPos =y ;
	}
	public void draw( Graphics window )
	{
		window.drawImage(image,getX(),getY(),80,80,null);
	}
	
	
}
