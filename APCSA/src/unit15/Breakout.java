package unit15;
//© A+ Computer Science  -  www.apluscompsci.com
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
import java.lang.Math;
public class Breakout extends Canvas implements KeyListener, Runnable
{
	private Ball ball;
	private Paddle rightPaddle;
	private boolean[] keys;
	private BufferedImage back;
	private int playerscore;
	private Block[][] bricks;
	private boolean[][] visible;

	public Breakout()
	{
		//set up all variables related to the game
		System.out.println("NAME: ANDREW ZHANG\nPERIOD: 4\nDATE:4/4/2018\nCOMPUTER NUMBER:18\n");
		ball  = new Ball(500,200,10,10,Color.BLACK,-3,1);
		ball.setSpeed(-1, 1);
		rightPaddle = new Paddle(750, 100, 20, 50, Color.BLUE, 5);
		bricks = new Block[5][4];
		visible = new boolean[5][4];
		for(int i=0;i<5;i++){
			for(int j=0;j<4;j++){
				bricks[i][j]=new Block(20+50*j,20+115*i,10,75,Color.BLACK);
				visible[i][j]=true;
			}
		}
		keys = new boolean[4];

    
    	setBackground(Color.WHITE);
		setVisible(true);
		
		new Thread(this).start();
		addKeyListener(this);		//starts the key thread to log key strokes
	}
	
   public void update(Graphics window){
	   paint(window);
   }

   public void paint(Graphics window)
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
		graphToBack.drawRect(0, 10,800 , 550);
		
		ball.moveAndDraw(graphToBack);
		for(int i=0;i<5;i++){
			for(int j=0;j<4;j++){
				if(visible[i][j]){
					bricks[i][j].draw(graphToBack);
				}
			}
		}
		rightPaddle.draw(graphToBack);
		graphToBack.drawString("Score: "+playerscore, 400, 100);
		//see if ball hits left wall or right wall
		if( ball.getX()>790)
		{
			ball.setXSpeed(0);
			ball.setYSpeed(0);
			if(ball.getX()>790){
				graphToBack.setColor(Color.WHITE);
				graphToBack.drawString("Score: "+playerscore, 400, 100);
				playerscore =0;
				graphToBack.setColor(Color.BLACK);
				graphToBack.drawString("Score: "+playerscore, 400, 100);
				for(int i=0;i<5;i++){
					for(int j=0;j<4;j++){
						visible[i][j]=true;
					}
				}
			}
			ball.draw(graphToBack,Color.white);
			ball  = new Ball(500,200,10,10,Color.BLACK,-3,1);
		}
		if(ball.getX()<10){
			ball.setXSpeed(-ball.getXSpeed());
		}

		
		//see if the ball hits the top or bottom wall 
		
		if(!(ball.getY()>=10&&ball.getY()<=550)){
			ball.setYSpeed(-1*ball.getYSpeed());
		}
		if(ball.didCollideRight(rightPaddle)||ball.didCollideLeft(rightPaddle)) ball.setXSpeed(-ball.getXSpeed());
		else if(ball.didCollideTop(rightPaddle)||ball.didCollideBottom(rightPaddle)) ball.setYSpeed(-ball.getYSpeed());
		for(int i=0;i<5;i++){
			for(int j=0;j<4;j++){
				if(visible[i][j]&&(ball.didCollideBottom(bricks[i][j])||ball.didCollideTop(bricks[i][j]))){
					ball.setYSpeed(-ball.getYSpeed());
					visible[i][j]=false;
					bricks[i][j].draw(graphToBack, Color.WHITE);
					graphToBack.setColor(Color.WHITE);
					graphToBack.drawString("Score: "+playerscore, 400, 100);
					playerscore++;
					graphToBack.setColor(Color.BLACK);
					graphToBack.drawString("Score: "+playerscore, 400, 100);
				}
				else if(visible[i][j]&&(ball.didCollideLeft(bricks[i][j])||ball.didCollideRight(bricks[i][j]))){
					ball.setXSpeed(-ball.getXSpeed());
					visible[i][j] = false;
					bricks[i][j].draw(graphToBack, Color.WHITE);
					graphToBack.setColor(Color.WHITE);
					graphToBack.drawString("Score: "+playerscore, 400, 100);
					playerscore++;
					graphToBack.setColor(Color.BLACK);
					graphToBack.drawString("Score: "+playerscore, 400, 100);
				}
			}
		}
		//see if the ball hits the left paddle
		/*if(ball.getX()<=leftPaddle.getX()+leftPaddle.getWidth()+Math.abs(ball.getXSpeed())&& 
				(ball.getY()>=leftPaddle.getY()&& 
				ball.getY()<=leftPaddle.getY()+leftPaddle.getHeight()||
				ball.getY()+ball.getHeight()>=leftPaddle.getY() &&
				ball.getY()+ball.getHeight()<leftPaddle.getY()+leftPaddle.getHeight())){
			if(ball.getX()<=leftPaddle.getX()+leftPaddle.getWidth()-Math.abs(ball.getXSpeed())){
				ball.setYSpeed(-1*ball.getYSpeed());
			}
			else{
				ball.setXSpeed(-1*ball.getXSpeed());
			}
		}
		*/
		
		//see if the ball hits the right paddle
	/*	if(ball.getX()+ball.getWidth()>=rightPaddle.getX()-Math.abs(ball.getXSpeed())&& 
				(ball.getY()>=rightPaddle.getY()&& 
				ball.getY()<=rightPaddle.getY()+rightPaddle.getHeight()||
				ball.getY()+ball.getHeight()>=rightPaddle.getY() &&
				ball.getY()+ball.getHeight()<rightPaddle.getY()+rightPaddle.getHeight())){
			if(ball.getX()+ball.getWidth()>=rightPaddle.getX()+Math.abs(ball.getXSpeed())){
				ball.setYSpeed(-1*ball.getYSpeed());
			}
			else{
				ball.setXSpeed(-1*ball.getXSpeed());
			}
		}
*/
/*		
		if (ball.didCollideLeft(leftPaddle)|| ball.didCollideRight(rightPaddle)){
			ball.setXSpeed(-ball.getXSpeed());}
		else if (ball.didCollideTop(leftPaddle) || ball.didCollideTop(rightPaddle)
				|| ball.didCollideBottom(leftPaddle) || ball.didCollideBottom(rightPaddle)) {
			//ball.setXSpeed(-ball.getXSpeed());
			ball.setYSpeed(-ball.getYSpeed());
		}
*/

		//see if the paddles need to be moved
		if(keys[2]) rightPaddle.moveUpAndDraw(graphToBack);
		if(keys[3]) rightPaddle.moveDownAndDraw(graphToBack);













		
		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=true; break;
			case 'Z' : keys[1]=true; break;
			case 'I' : keys[2]=true; break;
			case 'M' : keys[3]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=false; break;
			case 'Z' : keys[1]=false; break;
			case 'I' : keys[2]=false; break;
			case 'M' : keys[3]=false; break;
		}
	}

	public void keyTyped(KeyEvent e){}
	
   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(8);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}	
}