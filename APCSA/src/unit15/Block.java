package unit15;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;

	private Color color;

	public Block()
	{
		xPos = 100;
		yPos = 150;
		width = 10;
		height = 10;
		color = Color.BLACK;


	}

	//add other Block constructors - x , y , width, height, color
	public Block(int x, int y){
		xPos = x;
		yPos = y;
		width = 10; 
		height = 10;
		color = Color.BLACK;
	}
	public Block(int x, int y, int w, int h){
		xPos = x;
		yPos = y;
		width = w;
		height = h;
		color = Color.BLACK;
	}
	public Block(int x, int y, int w, int h, Color c){
		xPos = x;
		yPos = y;
		width = w;
		height = h;
		color = c;
	}
	public void setWidth(int w){
		width = w;
	}
	public void setHeight(int h){
		height = h;
	}
	
	
	
	
	
	
	
	
	
	
	
   //add the other set methods

	public void setX(int x){
		xPos = x;
	}
	public void setY(int y){
		yPos = y;
	}
   public void setPos(int x, int y){
	   xPos = x;
	   yPos = y;
   }

   public void setColor(Color col)
   {
	   color = col;

   }
  

   public void draw(Graphics window)
   {
      window.setColor(color);
      window.fillRect(getX(), getY(), getWidth(), getHeight());
   }

   public void draw(Graphics window, Color col)
   {
	   window.setColor(col);
	   window.fillRect(getX(), getY(), getWidth(), getHeight());

   }
   
	public boolean equals(Object obj)
	{
		if(getX()!=((Block) obj).getX()||getY()!=((Block) obj).getY()||getHeight()!=((Block) obj).getHeight()||getWidth()!=((Block) obj).getWidth()) return false;
		if(!getColor().equals(((Block) obj).getColor())) return false;
		return true;
	}   

   //add the other get methods
    public int getX(){
    	return xPos;
    }
    
    public int getY(){
    	return yPos;
    }
    public int getWidth(){
    	return width;
    }
    public int getHeight(){
    	return height;
    }
    public Color getColor(){
    	return color;
    }
   //add a toString() method  - x , y , width, height, color
	public String toString(){
		String output = xPos + " " + yPos + " " +width + " " + height + " " + color;
		return output;
	}
}