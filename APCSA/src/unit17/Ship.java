package unit17;//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Ship extends MovingThing
{
	private int speed;
	private Image image;

	public Ship()
	{
		this(0,0,0);
	}

	public Ship(int x, int y)
	{
		this(x,y,0);
	}

	public Ship(int x, int y, int s)
	{
		super(x, y);
		speed=s;
		try
		{
			image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\unit17\\ship.jpg"));
		}
		catch(Exception e)
		{
			//feel free to do something here
			System.out.println("402 glaze it");
		}
	}
	public void gainShield(){
		try{
			image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\unit17\\ship.jpgWithShield.jpg"));
		}
		
		catch(Exception e){
			System.out.println("Unlucky");
		}
		
	}
	public boolean hitPowerUp(PowerUp a){
		if(this.getX()<(a.getX()+80)&&this.getX()+80>a.getX()&&this.getY()+80>a.getY()&&this.getY()<a.getY()+80) return true;
		return false;
	}


	public void setSpeed(int s)
	{
	   //add more code
		speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void draw( Graphics window )
	{
		window.drawImage(image,getX(),getY(),80,80,null);
	}
	public boolean collideWithPowerUp(PowerUp p){
		if(this.getX()+50>p.getX()&&this.getX()<p.getX()){
			if(this.getY()+50<p.getY()&&this.getY()<p.getY()+50){
				return true;
			}
		}
		return false;
	}

	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
