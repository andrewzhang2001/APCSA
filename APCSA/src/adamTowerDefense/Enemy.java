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
	public Enemy(int x, int y, int hp ,int dmg, int range){
		this.x=x;
		this.y=y;
		this.hp=hp;
		this.dmg=dmg;
		this.range = range;
	}
	public abstract void draw(Graphics window);
}
