package adamTowerDefense;
import java.awt.Color;
import java.awt.Graphics;

public class Tile {
	private int x;
	private int y;
	private boolean occupied = false;
	public Tile(int x, int y){
		this.x=y;
		this.y=y;

	}
	public boolean isOccupied(){
		return occupied;
	}
	public void draw(Graphics window){
		window.setColor(Color.GREEN);
		window.drawRect(x, y, 30, 30);
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
}
