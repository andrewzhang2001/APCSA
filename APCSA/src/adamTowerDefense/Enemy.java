package adamTowerDefense;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
public abstract class Enemy {
	protected int dmg;
	protected int hp;
	protected int x;
	protected int y;
	protected int range;
	protected int speed;
	public Enemy(int x, int y){
		this.x=x;
		this.y=y;

	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public abstract void move();
	public abstract void draw(Graphics window);
}
