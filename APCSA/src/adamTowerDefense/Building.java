package adamTowerDefense;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
public abstract class Building implements Locatable{
	protected int HP;
	protected int X;
	protected int Y;
	protected boolean alive;
	protected Image image;
	public Building(int xPos, int yPos, int HP){
		X=xPos;
		Y=yPos;
		this.HP = HP;
	}
	public void setHP(int hp){
		HP = hp;
	}

	public void setX(int x){
		X=x;
	}
	public void setY(int y){
		Y=y;
	}
	public void setPos(int x, int y){
		X=x;
		Y=y;
	}
	public int getHP(){
		return HP;
	}
	public int getX(){
		return X;
	}
	public int getY(){
		return Y;
	}
	public abstract void draw(Graphics window);
}
