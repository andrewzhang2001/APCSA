package unit1;

import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;


public class Lab01d extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public Lab01d	()
	{
		super("Lab01d");
		
		setSize(WIDTH,HEIGHT);

		getContentPane().add(new AdamRobot());
		
		//getContentPane().add(new BigHouse());		
		
		//getContentPane().add(new Robot());
		
		setVisible(true);
	}
	
	public static void main( String args[] )
	{
		Lab01d run = new Lab01d();
	}
}

class AdamRobot extends Canvas
{
   public AdamRobot()    //constructor - sets up the class
   {
      setSize(800,600);
      setBackground(Color.WHITE);
      setVisible(true);
   }

   public void paint( Graphics window )
   {
      adamRobot(window);
   }

   public void adamRobot( Graphics window )
   {
      window.setColor(Color.BLUE);
      window.drawString("ADAM R THE ROBOT", 35, 35);

      window.setColor(Color.YELLOW);
      window.fillOval( 200, 100, 100, 100 );

      window.setColor(Color.MAGENTA);
      window.fillOval(233, 133, 30, 10);
      window.fillOval(266, 133, 10, 5);
      
      window.setColor(Color.RED);
      window.fillOval(250, 150, 20, 20);

      window.setColor(Color.MAGENTA);
      window.drawArc(225, 175, 50, 10, 180, 180);
      
      window.setColor(Color.PINK);
      window.fillOval( 300, 100, 100, 100 );

      window.setColor(Color.BLUE);
      window.fillOval(333, 133, 30, 10);
      window.fillOval(366, 133, 10, 5);
      
      window.setColor(Color.BLACK);
      window.fillOval(350, 150, 20, 20);

      window.setColor(Color.GREEN);
      window.drawArc(325, 175, 50, 10, 180, 180);
      
      window.setColor(Color.BLUE);
      window.fillRect(250, 200, 100, 100);
      
      window.setColor(Color.ORANGE);
      window.fillRect(200, 300, 200, 100);
      
      window.setColor(Color.BLACK);
      window.drawLine(100, 150, 250, 200);
      window.drawLine(500, 150, 350, 200);
      window.drawLine(100, 500, 200, 400);
      window.drawLine(500, 500, 400, 400);
   }
}