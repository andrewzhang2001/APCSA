package unit1;

import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;

public class Lab01c extends JFrame
	{
		private static final int WIDTH = 800;
		private static final int HEIGHT = 600;

		public Lab01c()
		{
			super("Lab01c");
			
			setSize(WIDTH,HEIGHT);

			getContentPane().add(new BigHouse());
			
			
			setVisible(true);
		}
		
		public static void main( String args[] )
		{
			Lab01c run = new Lab01c();
		}
	}


class BigHouse extends Canvas
{
	  public BigHouse()    //constructor - sets up the class
	   {
	      setSize(800,600);
	      setBackground(Color.WHITE);
	      setVisible(true);
	   }

	   public void paint( Graphics window )
	   {
	      bigHouse(window);
	   }

	   public void bigHouse( Graphics window )
	   {
	      window.setColor(Color.BLUE);
	      window.drawString("ADAMR'S MANSION", 35, 35);
	      
	      window.setColor(Color.GREEN);
	      window.fillRect(0, 0, 600, 100);
	      
	      window.setColor(Color.BLUE);
	      window.fillRect(000, 100, 100, 500);
	      window.fillRect(500, 100, 100, 500);
	      
	      window.setColor(Color.red);
	      window.drawLine(100, 200, 300, 100);
	      window.drawLine(300, 100, 500, 200);
	      
	      int xpoints[] = {100, 300, 100};
	      int ypoints[] = {200, 100, 100};
	      window.fillPolygon(xpoints, ypoints, 3);
	      
	      xpoints[0] = 500;
	      xpoints[1] = 300;
	      xpoints[2] = 500;
	      window.fillPolygon(xpoints, ypoints, 3);
	   }
}


