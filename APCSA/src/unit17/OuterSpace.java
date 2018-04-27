package unit17;//© A+ Computer Science  -  www.apluscompsci.com
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

public class OuterSpace extends Canvas implements KeyListener, Runnable
{
	private Ship ship;
	private int cantShoot;
	private Aliens invaders;
	private boolean alienOneLeft;
	private boolean alienTwoLeft;
	private boolean hasShield;
	private PowerUp shield;
	private ArrayList<Alien> aliens;
	private ArrayList<Ammo> shots=new ArrayList<Ammo>();
	private ArrayList<Ammo> alienShots = new ArrayList<Ammo>();
	private int score = 0;
	

	private boolean[] keys;
	private BufferedImage back;

	public OuterSpace()
	{
		setBackground(Color.black);

		keys = new boolean[5];

		//instantiate other stuff
		ship = new Ship(400,400,3);
		invaders = new Aliens();
		this.addKeyListener(this);
		new Thread(this).start();
		shield = new PowerUp(100,100);
		cantShoot = 100;
		setVisible(true);
		hasShield = false;
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
		

		ship.draw(graphToBack);
		if(!hasShield){
			if(ship.hitPowerUp(shield)){
				System.out.println("POWERUP");
				hasShield = true;
				ship.gainShield();
				shield = null;
			}
			else shield.draw(graphToBack);
		}
		for(int r=0;r<3;r++){
			for(int c=0;c<3;c++){
				
				if(invaders.alienAt(r, c)!=null){
					if(invaders.alienAt(r, c).willShoot()){
						alienShots.add(new Ammo(invaders.alienAt(r, c).getX()+50, invaders.alienAt(r, c).getY()+50, -1));
					}
					invaders.alienAt(r, c).draw(graphToBack);
					if(invaders.alienAt(r, c).getX()>680||invaders.alienAt(r, c).getX()<0) invaders.alienAt(r, c).setSpeed(-invaders.alienAt(r, c).getSpeed());
					invaders.alienAt(r, c).move("RIGHT");
					for(int i=0;i<shots.size();i++){
					if(shots.get(i).inAlien(invaders.alienAt(r, c))){
						invaders.kill(r,c);
						score++;
					}
					}
				}
			}
		}
		
		for(Ammo i: shots){
			if(i.getX()>0){
				
				i.draw(graphToBack);
 
			}

		}
		for(Ammo i:alienShots){
			if(i!=null){
				if(i.hitShip(ship)){
					i.setX(1000);
					i = null;
					if(!hasShield)score = score -1;
					System.out.println("HIT");
				}
				else if(i.getX()<800){
					i.draw(graphToBack);
				}
			}
		}
		graphToBack.drawString("SCORE = "+score, 20, 20);
		if(keys[0] == true)
		{
			ship.move("LEFT");
		}


		if(keys[1]) ship.move("RIGHT");  
		if(keys[2]) ship.move("UP"); 
		if(keys[3]) ship.move("DOWN");
		if(keys[4]&&cantShoot>100) {
			cantShoot = 0;
			shots.add(new Ammo(ship.getX()+35, ship.getY(), 4)); 
		}
		else{
			if(cantShoot<1000)
			cantShoot++;
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

