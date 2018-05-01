package adamTowerDefense;//© A+ Computer Science  -  www.apluscompsci.com
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
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.util.*;

public class Battlefield extends Canvas implements KeyListener, Runnable, MouseListener
{

	

	private boolean[] keys;
	private BufferedImage back;

	private Tile[][] tiles = new Tile[8][23];

	private int count = 0;
	private int curMouseXPos;
	private int curMouseYPos;
	private boolean mousePressed=false;
	private int curSelectedTileRow;
	private int curSelectedTileCol;
	private boolean tileIsSelected;
	private boolean[][] occupiedTiles = new boolean[8][23];
	private List<Building> buildings = new LinkedList<Building>(); 
	private boolean buildTime=false;
	public Battlefield()
	{
		setBackground(Color.black);

		keys = new boolean[10];

		//instantiate other stuff
		for(int i=0;i<8;i++){
			for(int j=0;j<23;j++){
				tiles[i][j]=new Tile(30*j,30*i);
			}
		}

		buildTime = true;
		this.addKeyListener(this);
		this.addMouseListener(this);
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
		for(Building i : buildings){
			i.draw(graphToBack);
		}
		if(buildTime){
			if(mousePressed){
				if(curMouseYPos<240&&curMouseXPos<690){
					curSelectedTileRow = curMouseYPos/30;
					curSelectedTileCol = curMouseXPos/30;
					tileIsSelected = true;
				}
			}
			if(tileIsSelected){
				for(int i=0;i<8;i++){
					for(int j=0;j<23;j++){
						tiles[i][j].setCurSelected(curSelectedTileRow==i&&curSelectedTileCol==j ? true : false);
					}
				}
			}
			for(int i=0;i<8;i++){
				for(int j=0;j<23;j++){
				//System.out.println(tiles[i][j].getX()+" "+tiles[i][j].getY());
					tiles[i][j].draw(graphToBack);
				}
			}
			if(tileIsSelected){
				tiles[curSelectedTileRow][curSelectedTileCol].draw(graphToBack);
			}
			if(tileIsSelected){
				if(keys[1]){
					if(checkIfValid(curSelectedTileRow, curSelectedTileCol, 1,1)){
						buildings.add(new Wall(curSelectedTileRow, curSelectedTileCol, 100));
						occupiedTiles[curSelectedTileRow][curSelectedTileCol] = true;
					}
					else{
						System.out.println("CANT ADD WALL HERE");
					}
				}
				else if(keys[2]){
					if(checkIfValid(curSelectedTileRow, curSelectedTileCol, 3,3)){
						buildings.add(new ArcherTower(curSelectedTileRow, curSelectedTileCol, 100,100,9));
						for(int i=0;i<3;i++){
							for(int j=0;j<3;j++){
								occupiedTiles[curSelectedTileRow+i][curSelectedTileCol+j]=true;
							}
						}
					}
					else{
						System.out.println("CANT ADD ARCHER TOWER HERE");
					}
				}
				else if(keys[3]){
					if(checkIfValid(curSelectedTileRow, curSelectedTileCol, 3,3)){
						buildings.add(new XBow(curSelectedTileRow, curSelectedTileCol, 100,100,14));
						for(int i=0;i<3;i++){
							for(int j=0;j<3;j++){
								occupiedTiles[curSelectedTileRow+i][curSelectedTileCol+j]=true;
							}
						}
					}
					else{
						System.out.println("CANT ADD XBOW HERE");
					}
				}
				else if(keys[4]){
					if(checkIfValid(curSelectedTileRow, curSelectedTileCol, 3,2)){
						buildings.add(new InfernoTower(curSelectedTileRow, curSelectedTileCol, 100,100,9));
						for(int i=0;i<3;i++){
							for(int j=0;j<2;j++){
								occupiedTiles[curSelectedTileRow+i][curSelectedTileCol+j]=true;
							}
						}
					}
					else{
						System.out.println("CANT ADD INFERNO TOWER HERE");
					}
				}
				else if(keys[5]){
					if(checkIfValid(curSelectedTileRow, curSelectedTileCol, 3,3)){
						buildings.add(new GoldMine(curSelectedTileRow, curSelectedTileCol, 100));
						for(int i=0;i<3;i++){
							for(int j=0;j<3;j++){
								occupiedTiles[curSelectedTileRow+i][curSelectedTileCol+j]=true;
							}
						}
					}
					else{
						System.out.println("CANT ADD GOLD MINE HERE HERE");
					}
					
				}
				

			}
		}
		
		
		else{
			tileIsSelected = false;
		}

		
		//add code to move stuff
		

		//add in collision detection

	
		twoDGraph.drawImage(back, null, 0, 0);
	}

	public boolean checkIfValid(int r, int c, int getHeight, int getWidth){
		for(int i=r;i<r+getHeight;i++){
			for(int j=c;j<c+getWidth;j++){
				if(i>=8||j>=23||occupiedTiles[i][j]){return false;
				}
			}
		}
		return true;
	}
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_1)
		{
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_2)
		{
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_3)
		{
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_4)
		{
			keys[4] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_5)
		{
			keys[5] = true;
		}
		if(e.getKeyCode()==KeyEvent.VK_DELETE){
			keys[6]=true;
		}
		repaint();
	}

	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_1)
		{
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_2)
		{
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_3)
		{
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_4)
		{
			keys[4] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_5)
		{
			keys[5] = false;
		}
		if(e.getKeyCode()==KeyEvent.VK_DELETE){
			keys[6]=false;
		}
		repaint();
	}

	public void keyTyped(KeyEvent e)
	{

	}
	public void mousePressed(MouseEvent e){
		System.out.println("Hi");
		if(e.getButton()==MouseEvent.BUTTON1)
		{
			mousePressed = true;
			curMouseXPos = e.getX();
			curMouseYPos = e.getY();
		}
	}
    public void mouseReleased(MouseEvent e) {
    	if(e.getButton()==MouseEvent.BUTTON1){
    		mousePressed = false;
    	}
    }
    
    public void mouseEntered(MouseEvent e) {
  
    }
    
    public void mouseExited(MouseEvent e) {

    }
    
    public void mouseClicked(MouseEvent e) {

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

