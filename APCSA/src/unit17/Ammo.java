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

public class Ammo extends MovingThing
{
	private int speed;

	public Ammo()
	{
		this(0,0,0);
	}

	public Ammo(int x, int y)
	{
		super(x,y);
	}

	public Ammo(int x, int y, int s)
	{
		//add code
		super(x,y);
		speed =s ;
	}

	public void setSpeed(int s)
	{
	   //add code
		speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}
	
	public boolean inAlien(Alien a){
		if(this.getX()<(a.getX()+60)&&this.getX()>a.getX()+10&&this.getY()>a.getY()&&this.getY()<a.getY()+100) return true;
		return false;
	}

	public void draw( Graphics window )
	{
		//add code to draw the ammo
		window.setColor(Color.black);
		window.fillRect(getX(), getY(), 10, 10);
		window.setColor(Color.yellow);
		this.move("UP");
		window.fillRect(getX(), getY(), 10, 10);
	}

	public String toString()
	{
		return "";
	}
}
