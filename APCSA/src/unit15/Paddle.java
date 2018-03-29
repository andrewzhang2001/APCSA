package unit15;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block
{
   //instance variables
   private int speed;

   public Paddle()
   {
		super(10,10);
      speed =5;
   }


   //add the other Paddle constructors
   public Paddle(int xPos, int yPos){
	   super(xPos, yPos);
	   speed = 5;
   }
   public Paddle(int xPos, int yPos, int Speed){
	   super(xPos, yPos);
	   speed = Speed;
   }
   public Paddle(int xPos, int yPos, int width, int height){
	   super(xPos, yPos, width, height);
	   speed = 5;
   }
   public Paddle(int xPos, int yPos, int width, int height, int Speed){
	   super(xPos, yPos, width, height);
	   speed = Speed;
   }
   public Paddle(int xPos, int yPos, int width, int height, Color col, int Speed){
	   super(xPos, yPos, width, height, col);
	   speed = Speed;
   }

   public void setSpeed(int s){
	   speed = s;
   }
   







   public void moveUpAndDraw(Graphics window)
   {
	   draw(window, Color.WHITE);
	   setX(getX()+speed);
	   draw(window);

   }

   public void moveDownAndDraw(Graphics window)
   {
	   draw(window, Color.WHITE);
	   setX(getX() + speed);
	   draw(window);

   }

   //add get methods
   public int getSpeed(){
	   return speed;
   }
   
   //add a toString() method
   public String toString(){
	   String output = super.toString();
	   output = output + " " + speed;
	   return output;
   }
}