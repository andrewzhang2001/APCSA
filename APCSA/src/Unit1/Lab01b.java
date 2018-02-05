package unit1;

import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;


public class Lab01b extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public Lab01b()
	{
		super("Graphics Runner");
		
		setSize(WIDTH,HEIGHT);

		getContentPane().add(new SmileyFace());
		
		//getContentPane().add(new BigHouse());		
		
		//getContentPane().add(new Robot());
		
		setVisible(true);
	}
	
	public static void main( String args[] )
	{
		Lab01b run = new Lab01b();
	}
}

class SmileyFace extends Canvas
{
   public SmileyFace()    //constructor - sets up the class
   {
      setSize(800,600);
      setBackground(Color.WHITE);
      setVisible(true);
   }

   public void paint( Graphics window )
   {
      smileyFace(window);
   }

   public void smileyFace( Graphics window )
   {
      window.setColor(Color.BLUE);
      window.drawString("SMILEY FACE LAB ", 35, 35);

      window.setColor(Color.YELLOW);
      window.fillOval( 210, 100, 400, 400 );

      window.setColor(Color.RED);
      window.fillOval(350, 250, 30, 10);
      window.fillOval(450, 250, 30, 10);
      
      window.setColor(Color.BLACK);
      window.fillOval(400, 300, 20, 20);

      window.setColor(Color.RED);
      window.drawArc(300, 350, 200, 50, 180, 180);
   }
}