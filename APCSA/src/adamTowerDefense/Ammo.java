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
	protected Enemy target;
	public Ammo(int xpos, int ypos, int xvel, int yvel, Enemy e){
		x=xpos;
		y=ypos;
		xVel = xvel;
		yVel = yvel;
		target = e;
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
	public boolean collideWithTarget(){
		if(x>target.getX()&&x<target.getX()+90&&y>target.getY()&&y<target.getY()+90)
			return true;
		return false;
	}
	public void move(){
		if(x>=target.getX()+45){
			x=x-xVel;
		}
		if(x<=target.getX()+45){
			x=x+xVel;
		}
		if(y>=target.getY()+45){
			y=y-yVel;
		}
		if(y<=target.getY()+45){
			y=y+yVel;
		}
		
	}
	public void draw(Graphics window){
		window.setColor(Color.BLUE);
		window.fillRect(x, y, 2, 2);
	}
}
