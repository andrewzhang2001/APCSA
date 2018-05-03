package adamTowerDefense;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
public abstract class Building{
	protected int HP;
	protected int X;
	protected int Y;
	private int row;
	private int col;
	protected int height;
	protected int width;
	protected int cost;
	protected boolean alive;
	protected Image image;
	public Building(int row, int col, int HP){
		this.row = row;
		this.col = col;
		this.HP = HP;
		X=this.col*30;
		Y=this.row*30;
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
	public int getRow(){
		return row;
	}
	public int getCol(){
		return col;
	}
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	public int getCost(){
		return cost;
	}
	public abstract void draw(Graphics window);
}
