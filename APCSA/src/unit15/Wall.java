package unit15;
import java.awt.Color;
public class Wall extends Block{
	public Wall(int a, int b, int c, int d, Color e){
		super(a,b,c,d,e);
	}
	public Wall(int a, int b){
		super(a,b);
	}
	public Wall(int a, int b, int c, int d){
		super(a,b,c,d);
	}
	public Wall(){
		super();
	}
}
