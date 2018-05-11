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
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Battlefield extends Canvas implements KeyListener, Runnable, MouseListener
{

	

	private boolean[] keys;
	private BufferedImage back;

	private Tile[][] tiles = new Tile[8][23];

	private int count = 0;
	private int moneys=0;
	private int curMouseXPos;
	private int curMouseYPos;
	private boolean mousePressed=false;
	private int curSelectedTileRow;
	private int curSelectedTileCol;
	private boolean tileIsSelected;
	private int income = 5000;
	private boolean[][] occupiedTiles = new boolean[8][23];
	private List<Building> buildings = new LinkedList<Building>(); 
	private List<Enemy> enemies = new ArrayList<Enemy>();
	private List<Ammo> bullets = new ArrayList<Ammo>();
	private boolean buildTime=false;
	private boolean introScreen = true;
	private Image image;
	private int livesRemaining=3;
	private boolean battletime = true;
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
		try{
			image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\adamTowerDefense\\TITLESLIDE.png"));
		}
		catch(Exception e){
			
		}
		moneys = 10000;
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
		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(0,0,1000,700);
		if(introScreen){
			graphToBack.drawImage(image, 0, 0, 800, 600, null);
			if(mousePressed) introScreen = false;
		}
		else if(buildTime){

			for(Building i : buildings){
				i.draw(graphToBack);
			}
			graphToBack.setColor(Color.GREEN);
			graphToBack.drawString("CASH: $"+moneys, 720, 50);
			graphToBack.drawString("INCOME: $"+income, 720, 70);
			Color before = graphToBack.getColor();
			graphToBack.setColor(Color.red);
			graphToBack.fillRect(410, 390, 180, 50);
			graphToBack.setColor(Color.YELLOW);
			graphToBack.drawString("GIVE ME SOME GOLD", 420, 420);
			graphToBack.setColor(Color.GRAY);
			graphToBack.fillRect(30, 300, 300, 200);
			graphToBack.setColor(Color.BLUE);
			graphToBack.drawString("THE SHOP", 130, 315);
			graphToBack.drawString("WALL [1]: 500 GOLD" , 50, 345);
			graphToBack.drawString("ARCHER TOWER [2]: 5000 GOLD" , 50, 375);
			graphToBack.drawString("XBOW [3]: 12000 GOLD" , 50, 405);
			graphToBack.drawString("INFERNO TOWER [4]: 20000 GOLD" , 50, 435);
			graphToBack.drawString("GOLD MINE [5]: 1000 GOLD" , 50, 465);
			graphToBack.drawString("SELL TOWER [DELETE]: ENTIRE REFUND :)" , 50, 495);
			graphToBack.setColor(before);
			if(mousePressed){
				if(curMouseXPos<=590&&curMouseXPos>=410&&curMouseYPos<=440&&curMouseYPos>=390){
					moneys+=income;
					mousePressed = false;
					
					
				}
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
				if(keys[1]&&moneys>=500){
					if(checkIfValid(curSelectedTileRow, curSelectedTileCol, 1,1)){
						buildings.add(new Wall(curSelectedTileRow, curSelectedTileCol, 100));
						moneys-=500;
						occupiedTiles[curSelectedTileRow][curSelectedTileCol] = true;
					}
					else{
						System.out.println("CANT ADD WALL HERE");
					}
				}
				else if(keys[2]&&moneys>=5000){
					if(checkIfValid(curSelectedTileRow, curSelectedTileCol, 3,3)){
						buildings.add(new ArcherTower(curSelectedTileRow, curSelectedTileCol, 100,100,9));
						moneys-=5000;
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
				else if(keys[3]&&moneys>=12000){
					if(checkIfValid(curSelectedTileRow, curSelectedTileCol, 3,3)){
						buildings.add(new XBow(curSelectedTileRow, curSelectedTileCol, 100,100,14));
						moneys-=12000;
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
				else if(keys[4]&&moneys>=20000){
					if(checkIfValid(curSelectedTileRow, curSelectedTileCol, 3,2)){
						buildings.add(new InfernoTower(curSelectedTileRow, curSelectedTileCol, 100,100,9));
						moneys-=20000;
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
				else if(keys[5]&&moneys>=1000){
					if(checkIfValid(curSelectedTileRow, curSelectedTileCol, 3,3)){
						buildings.add(new GoldMine(curSelectedTileRow, curSelectedTileCol, 100));
						moneys-=1000;
						income+=1000;
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
				else if(keys[6]){
					if(occupiedTiles[curSelectedTileRow][curSelectedTileCol]){
						ListIterator<Building> it = buildings.listIterator();
						while(it.hasNext()){
							Building cur = it.next();
							it.previous();
							int cost = it.next().getCost();
							if(curSelectedTileRow>=cur.getRow()&&curSelectedTileRow<cur.getRow()+cur.getHeight()
							&&curSelectedTileCol>=cur.getCol()&&curSelectedTileCol<cur.getCol()+cur.getWidth()){
								System.out.println(cur.getClass().getName());
								if(cur.getClass().getName().equals("adamTowerDefense.GoldMine")) income-=1000;
								it.remove();
								moneys+=cost;
								for(int i=0;i<cur.getHeight();i++){
									for(int j=0;j<cur.getWidth();j++){
										occupiedTiles[cur.getRow()+i][cur.getCol()+j]=false;
									}
								}
								break;
							}
						}
					}
					else{
						System.out.println("NOTHING TO DO HERE");
					}
				}
				else if(keys[7]){
					buildTime = false;
				}
				

			}
		}
		
		
		else if(battletime){
			tileIsSelected = false;
			graphToBack.setColor(Color.red);
			graphToBack.drawString("LIVES REMAINING: "+livesRemaining , 790, 30);
			count++;
			if(count>100){
				enemies.add(new Barbarian((int)(Math.random()*690), 500));
				count = 0;
			}
			for(Ammo ammo:bullets){
				for(int i=0;i<enemies.size();i++){
					if (ammo.collideWithTarget(enemies.get(i))){
						enemies.remove(i);
						break;
					}
				}
			}
			for(Building b:buildings){
				b.draw(graphToBack);
				if(b.getClass().getName().equals("adamTowerDefense.GoldMine")||b.getClass().getName().equals("adamTowerDefense.Wall")) continue;
				else{
					if(b.getRC()>b.getShootThreshold()){
						if(b.getClass().getName().equals("adamTowerDefense.ArcherTower")){
							bullets.add(new Ammo(b.getX()+45, b.getY()+45, 1,0));
							bullets.add(new Ammo(b.getX()+45,b.getY()+45,-1,0));
							bullets.add(new Ammo(b.getX()+45,b.getY()+45,1,1));
							bullets.add(new Ammo(b.getX()+45,b.getY()+45, -1, 1));
						}
						if(b.getClass().getName().equals("adamTowerDefense.XBow")){
							bullets.add(new Ammo(b.getX()+45, b.getY()+45, 2,1));
							bullets.add(new Ammo(b.getX()+45,b.getY()+45,-2,1));
							bullets.add(new Ammo(b.getX()+45,b.getY()+45,1,2));
							bullets.add(new Ammo(b.getX()+45,b.getY()+45, -1, 2));
						}
						if(b.getClass().getName().equals("adamTowerDefense.InfernoTower")){
							bullets.add(new Ammo(b.getX()+30, b.getY()+45, 1,0));
							bullets.add(new Ammo(b.getX()+30,b.getY()+45,-1,0));
							bullets.add(new Ammo(b.getX()+30,b.getY()+45,1,1));
							bullets.add(new Ammo(b.getX()+30,b.getY()+45, -1, 1));
							bullets.add(new Ammo(b.getX()+30,b.getY()+45, 0, 1));
						}
						b.setRC(0);
					}
					else{
						b.setRC(b.getRC()+1);
					}
				}
			}
			for(Ammo b:bullets){
				b.move();
				b.draw(graphToBack);
			}
			ListIterator it = bullets.listIterator();
			int index = -1;
			while(it.hasNext()){
				it.next();
				index++;
				if(bullets.get(index).getX()>790||bullets.get(index).getX()<-10||bullets.get(index).getY()>700||bullets.get(index).getY()<0){
					it.remove();
					index--;
					continue;
				}
				for(int i=0;i<enemies.size();i++){
					if(bullets.get(index).collideWithTarget(enemies.get(i))){
						enemies.remove(i);
						it.remove();
						index--;
						break;
					}
				}
			}
			ListIterator ronak = enemies.listIterator();
			int eindex = -1;
			for(Enemy e:enemies){
				ronak.next();
				
				eindex++;
				if(e.getY()<-10){
					ronak.remove();
					eindex--;
					continue;
				}
				e.move();
				e.draw(graphToBack);
			}
		}
		else{
			
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
		if(e.getKeyCode()==KeyEvent.VK_0){
			keys[7]=true;
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
		if(e.getKeyCode()==KeyEvent.VK_0){
			keys[7]=false;
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

