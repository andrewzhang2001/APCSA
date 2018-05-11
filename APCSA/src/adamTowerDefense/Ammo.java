package adamTowerDefense;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
public class Ammo {
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
	//objectaid
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
	public boolean collideWithTarget(Enemy target){
		if(x>target.getX()&&x<target.getX()+90&&y>target.getY()&&y<target.getY()+90)
			return true;
		return false;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void move(){
		x=x+xVel;
		y=y+yVel;
		
	}
	public void draw(Graphics window){
		Color random = new Color((int)(Math.random()*256),(int)(Math.random()*256), (int)(Math.random()*256));
		window.setColor(random);
		window.fillRect(x, y, 4, 4);
	}
}
