package unit1;


import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;

public class RectangleMaker extends JFrame {
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	public RectangleMaker(){
		super("Lab01d");
		
		setSize(WIDTH,HEIGHT);

		getContentPane().add(new Danktagle());
		
		
		setVisible(true);
	}
	public static void main(String[] args) {
		
		RectangleMaker fortyTwo = new RectangleMaker();

	}

}

class Danktagle extends Canvas{
	 public Danktagle()    //constructor - sets up the class
	   {
	      setSize(800,600);
	      setBackground(Color.WHITE);
	      setVisible(true);
	   }
	 public void paint(Graphics window){
		 danktagle(window);
	 }
	 
	 public void danktagle(Graphics window){
		 window.setColor(Color.BLACK);
		 window.fillRect(0, 0, 6, 7);
		 window.fillRect(6, 7, 10, 11);
	 }
}
