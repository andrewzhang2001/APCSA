package adamTowerDefense;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
public abstract class Ammo {
	protected int x;
	protected int y;
	protected int xVel;
	protected int yVel;
	protected int dmg;
	public Ammo(int xpos, int ypos, int xvel, int yvel){
		x=xpos;
		y=ypos;
		xVel = xvel;
		yVel = yvel;
	}
	public void setX(int x){
		this.x=x;
	}
	public void setY(int y){
		this.y=y;
	}
	public void setxVel(int xvel){
		xVel = xvel;
	}
	public void setyVel(int yvel){
		yVel = yvel;
	}
	public abstract void draw(Graphics window);
}
