package unit1;


import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;

public class Shape extends JFrame {
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	public Shape(){
		super("My shape");
		
		setSize(WIDTH,HEIGHT);

		getContentPane().add(new Snape());
		
		
		setVisible(true);
	}
	public static void main(String[] args) {
		
		Shape fortyTwo = new Shape();

	}

}

class Snape extends Canvas{
	 public Snape()    //constructor - sets up the class
	   {
	      setSize(800,600);
	      setBackground(Color.WHITE);
	      setVisible(true);
	   }
	 public void paint(Graphics window){
		 snape(window);
	 }
	 
	 public void snape(Graphics window){
		 window.setColor(Color.RED);
		 int xpoints[] = {100, 300, 100, 400, 500};
	     int ypoints[] = {200, 100, 100, 300, 400};
	     window.fillPolygon(xpoints, ypoints, 5);
	     for (int i = 0; i<= 4; i++){
	    	 xpoints[i] += 400;
	    	 ypoints [i] -= 100;
	    	 xpoints[i] /= 2;
	    	 ypoints[i] /=2;
	     }
	     window.setColor(Color.MAGENTA);
	     window.fillPolygon(xpoints, ypoints, 5);
	   
	     
	 }
}
