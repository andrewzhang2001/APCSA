package unit15;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable
{
	private int xSpeed;
	private int ySpeed;

	public Ball()
	{
		super(200,200);
		xSpeed = 3;
		ySpeed = 1;
	}

	//add the other Ball constructors
	public Ball(int xPos, int yPos){
		super(xPos, yPos);
		xSpeed = 3;
		ySpeed = 1;
	}
	public Ball(int xPos, int yPos, int width, int height){
		super(xPos, yPos, width, height);
		xSpeed = 3;
		ySpeed = 1;
	}
	public Ball(int xPos, int yPos, int width, int height, Color col){
		super(xPos, yPos, width, height, col);
		xSpeed=3;
		ySpeed=1;
	}
	public Ball(int xPos, int yPos, int width, int height, Color col, int xspeed, int yspeed){
		super(xPos, yPos, width, height, col);
		xSpeed=xspeed;
		ySpeed=yspeed;
	}
	public void setSpeed(int xspeed, int yspeed){
		xSpeed = xspeed;
		ySpeed = yspeed;
	}
	public void setXSpeed(int xspeed){
		xSpeed = xspeed;
	}
	public void setYSpeed(int yspeed){
		ySpeed = yspeed;
	}
	

	public boolean didCollideLeft(Object obj) {
		Block testpaddle = (Block)obj;
		if (getX()<=testpaddle.getX()+testpaddle.getWidth()+Math.abs(getXSpeed())&&getX()>=testpaddle.getX()+Math.abs(getXSpeed())&&
				(getY()>=testpaddle.getY()-Math.abs(getYSpeed()) && getY()+getHeight()<=testpaddle.getY()+testpaddle.getHeight()+Math.abs(getYSpeed()))){
			return true;
		}
		return false;
	}


	public boolean didCollideRight(Object obj) {

		
		Block testpaddle = (Block)obj;
		if (getX()+getWidth()>=testpaddle.getX()-Math.abs(getXSpeed())&&getX()<=testpaddle.getX()+testpaddle.getWidth()-Math.abs(getXSpeed())&&(getY()>=testpaddle.getY()-Math.abs(getYSpeed()) 
				&& getY()+getHeight()<=testpaddle.getY()+testpaddle.getHeight()+Math.abs(getYSpeed()))){
			return true;
		}
		return false;
	}


	public boolean didCollideTop(Object obj) {

		Block testpaddle = (Block)obj;
		if ((getX()>=testpaddle.getX() && testpaddle.getX()+testpaddle.getWidth()>=getX()+getWidth())&&
				getY()<=testpaddle.getY()+testpaddle.getHeight()+Math.abs(getYSpeed())&&getY()+getHeight()>=testpaddle.getY()+Math.abs(getYSpeed())){

			return true;
		}
		return false;
	}


	public boolean didCollideBottom(Object obj) {

		Block testpaddle = (Block) obj;
		if ((getX()>=testpaddle.getX() && getX()+getWidth()<=testpaddle.getX()+testpaddle.getWidth())&&
				getY()+getHeight()>=testpaddle.getY()-Math.abs(getYSpeed())&&getY()<=testpaddle.getY()+testpaddle.getHeight()-Math.abs(getYSpeed())){
					return true;
				}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	   
   //add the set methods
   

   public void moveAndDraw(Graphics window)
   {
   	//draw a white ball at old ball location
	   draw(window, Color.WHITE);

      setX(getX()+xSpeed);
		//setY
      setY(getY()+ySpeed);

		//draw the ball at its new location
      draw(window);
   }
   
	public boolean equals(Object obj)
	{
		if(getX()!=((Block) obj).getX()||getY()!=((Block) obj).getY()||getHeight()!=((Block) obj).getHeight()||getWidth()!=((Block) obj).getWidth()) return false;
		if(!getColor().equals(((Block) obj).getColor())) return false;
		if(getXSpeed()!=((Ball) obj).getXSpeed()) return false;
		if(getYSpeed()!=((Ball) obj).getYSpeed()) return false;
		return true;



	}   

   //add the get methods
	public int getXSpeed(){
		return xSpeed;
	}
	public int getYSpeed(){
		return ySpeed;
	}
   //add a toString() method
	public String toString(){
		String output = super.toString();
		output = output + " "+ xSpeed + " " + ySpeed;
		return output;
	}
}