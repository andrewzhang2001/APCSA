package adamTowerDefense;//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Battlefield extends Canvas implements KeyListener, Runnable
{

	

	private boolean[] keys;
	private BufferedImage back;
	private ArcherTower adam;
	private XBow raymond;
	private InfernoTower andy;
	private Tile[][] tiles = new Tile[8][23];
	public Battlefield()
	{
		setBackground(Color.black);

		keys = new boolean[5];

		//instantiate other stuff
		adam = new ArcherTower(30,30,30, 30,9);
		raymond = new XBow(150,150,90,90,11);
		andy = new InfernoTower(300,300,180,90,9);
		for(int i=0;i<8;i++){
			for(int j=0;j<23;j++){
				tiles[i][j]=new Tile(30*i,30*j);
				System.out.println(tiles[i][j].getX()+" "+tiles[i][j].getY()+" FFFF");
			}
		}
		this.addKeyListener(this);
		new Thread(this).start();
		setVisible(true);
		
	}

   public void update(Graphics window)
   {
	   paint(window);
   }

	public void paint( Graphics window )
	{
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();
		graphToBack.setColor(Color.BLUE);
		graphToBack.drawString("StarFighter ", 25, 50 );
		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(0,0,800,600);
		adam.draw(graphToBack);
		raymond.draw(graphToBack);
		andy.draw(graphToBack);
		for(int i=0;i<8;i++){
			for(int j=0;j<23;j++){
				//System.out.println(tiles[i][j].getX()+" "+tiles[i][j].getY());
				tiles[i][j].draw(graphToBack);
			}
		}
		

		
		//add code to move stuff
		

		//add in collision detection

	
		twoDGraph.drawImage(back, null, 0, 0);
	}


	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = true;
		}
		repaint();
	}

	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = false;
		}
		repaint();
	}

	public void keyTyped(KeyEvent e)
	{

	}

   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(10);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}
}

