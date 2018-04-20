package PPictures;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  public void keepOnlyBlue(){
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] rowArray: pixels){
		  for(Pixel pixelObj: rowArray){
			  pixelObj.setGreen(0);
			  pixelObj.setRed(0);
		  }
	  }
  }
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  public void mirrorVerticalRightToLeft()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = width-1; col > width / 2; col--)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
        count++;
      }
    }
    System.out.println(count);
  }
  
  public void mirrorHorizontal(){
	    Pixel[][] pixels = this.getPixels2D();
	    Pixel leftPixel = null;
	    Pixel rightPixel = null;
	    int height = pixels.length;
	    int width = pixels[0].length;
	    for (int row = 0; row < pixels.length/2; row++)
	    {
	      for (int col = 0; col < width; col++)
	      {
	        leftPixel = pixels[row][col];
	        rightPixel = pixels[height - row - 1][col];
	        rightPixel.setColor(leftPixel.getColor());
	      }
	    } 
  }
  public void mirrorHorizontalBotToTop(){
	    Pixel[][] pixels = this.getPixels2D();
	    Pixel leftPixel = null;
	    Pixel rightPixel = null;
	    int height = pixels.length;
	    int width = pixels[0].length;
	    for (int row = pixels.length/2; row < pixels.length; row++)
	    {
	      for (int col = 0; col < width; col++)
	      {
	        leftPixel = pixels[row][col];
	        rightPixel = pixels[height - row - 1][col];
	        rightPixel.setColor(leftPixel.getColor());
	      }
	   } 
  }
  
  public void mirrorDiagonal(){
	  Pixel[][] pixels = this.getPixels2D();
	  int size = pixels.length>pixels[0].length ? pixels[0].length : pixels.length;
	  for(int i=0;i<size;i++){
		  for(int j=0;j<i;j++){
			  pixels[j][i].setColor(pixels[i][j].getColor());
		  }
	  }
  }
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }
  public void copy(Picture fromPic, int sr,int sc,int er,int ec,
          int startRow, int startCol)
{
Pixel fromPixel = null;
Pixel toPixel = null;
Pixel[][] toPixels = this.getPixels2D();
Pixel[][] fromPixels = fromPic.getPixels2D();
for (int fromRow = sr, toRow = startRow; 
  fromRow < er &&
  toRow < toPixels.length; 
  fromRow++, toRow++)
{
for (int fromCol = sc, toCol = startCol; 
    fromCol < ec &&
    toCol < toPixels[0].length;  
    fromCol++, toCol++)
{
 fromPixel = fromPixels[fromRow][fromCol];
 toPixel = toPixels[toRow][toCol];
 toPixel.setColor(fromPixel.getColor());
}
}   
}
  public void negate(){
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] rowArray:pixels){
		  for(Pixel pixelObj : rowArray){
			  pixelObj.setColor(new Color(255-pixelObj.getRed(),255-pixelObj.getGreen(),255-pixelObj.getBlue()));
		  }
	  }
	  
  }
  
  public void grayScale(){
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] rowArray:pixels){
		  for(Pixel pixelObj : rowArray){
			  int avg = pixelObj.getBlue() + pixelObj.getGreen()+pixelObj.getRed();
			  avg = avg /3;
			  pixelObj.setColor(new Color(avg,avg,avg));
		  }
	  }
  }
  
  public void fixUnderwater(){
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] rowArray:pixels){
		  for(Pixel pixelObj:rowArray){
			  pixelObj.setBlue(pixelObj.getBlue()>pixelObj.getGreen() ? 200 : 140);
		  }
	  }
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture(System.getProperty("user.dir")+"\\src\\pictures\\pixlab\\images\\flower1.jpg");
    Picture flower2 = new Picture(System.getProperty("user.dir")+"\\src\\pictures\\pixlab\\images\\flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write(System.getProperty("user.dir")+"\\src\\pictures\\pixlab\\images\\collage.jpg");
  }
  public void myCollage()
  {
    Picture flower1 = new Picture(System.getProperty("user.dir")+"\\src\\pictures\\pixlab\\images\\flower1.jpg");
    Picture flower2 = new Picture(System.getProperty("user.dir")+"\\src\\pictures\\pixlab\\images\\flower2.jpg");
    this.copy(flower1,50,50,70,70,0,40);
    this.copy(flower2,100,50);
    this.copy(flower1,200,60);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write(System.getProperty("user.dir")+"\\src\\pictures\\pixlab\\images\\collage.jpg");
  }
  
/* 
 * 	INCORRECT METHOD
 *  public void blur(int x, int y, int width, int height){
	  Pixel[][] pixels = this.getPixels2D();
	  boolean allsame = true;
	  int stepsize=1;
	  while(allsame){
		  Color firstcolor = pixels[x][y].getColor();
		  for(int i=x;i<x+stepsize;i++){
			  for(int j=y;j<y+stepsize;j++){
				  if(!pixels[i][j].getColor().equals(firstcolor)) allsame = false;
			  }
		  }
		  stepsize++;
	  }
	  System.out.println(stepsize);
	  for(int i=x;i<x+width;i=i+stepsize){
		  for(int j=y;j<y+height;j=j+stepsize){
			  int[] colors = {0,0,0};
			  for(int k=i;k<i+stepsize;k++){
				  for(int l=j;l<j+stepsize;l++){
					  colors[0]+=pixels[i][j].getRed();
					  colors[1]+=pixels[i][j].getGreen();
					  colors[2]+=pixels[i][j].getBlue();
				  }
			  }
			  //System.out.println(colors[0]+" "+colors[1]+" "+colors[2]);
			  colors[0]/=stepsize*stepsize;
			  colors[1]/=stepsize*stepsize;
			  colors[2]/=stepsize*stepsize;
			  for(int k=i;k<i+stepsize;k++){
				  for(int l=j;l<j+stepsize;l++){
					  pixels[k][l].setColor(new Color(colors[0],colors[1],colors[2]));
				  }
			  }
		  }
	  }
	  
  }
  */
  
  public void blur(int x , int y, int width, int height){
	  Pixel[][] pixels = this.getPixels2D();
	  Color[][] temp = new Color[pixels.length][pixels[0].length];
	  for(int i=x;i<x+width;i++){
		  for(int j=y;j<y+width;j++){
			  if(i==0||i==pixels[0].length-1||j==0||j==pixels.length-1){
				  continue;
			  }
			  else{
				  int redsum = 0, bluesum = 0, greensum =0;
				  for(int a = i-1;a<=i+1;a++){
					  for(int b = j -1;b<=j+1;b++){
						  redsum+=pixels[a][b].getRed();
						  bluesum+=pixels[a][b].getBlue();
						  greensum+=pixels[a][b].getGreen();
					  }
				  }
				  redsum/=9;
				  bluesum/=9;
				  greensum/=9;
				  temp[i][j]=new Color(redsum,greensum,bluesum);
			  }
			  
		  }
	  }
	  for(int i=x;i<x+width;i++){
		  for(int j=y;j<y+height;j++){
			  if(i==0||i==pixels[0].length-1||j==0||j==pixels.length-1){
				  continue;
			  }
			  else pixels[i][j].setColor(temp[i][j]);
		  }
	  }
  }
  
  
  public void mirrorArms(){
	  Pixel[][] pixels = this.getPixels2D();
	  for(int j =100;j<170;j++){
		  for(int i=159;i<190;i++){
			  pixels[i+80][j-7].setColor(pixels[i][j].getColor());
		  }
	  }
	  for(int i=170;i<200;i++){
		  for(int j=240;j<300;j++){
			  pixels[i+247-170][j+245-240].setColor(pixels[i][j].getColor());
		  }
	  }
  }
  public void mirrorGull(){
	  Pixel[][] pixels = this.getPixels2D();
	  for(int i=235;i<325;i++){
		  for(int j=235;j<345;j++){
			  pixels[i+20][j+150].setColor(pixels[i][j].getColor());
		  }
	  }
  }

  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel topPixel = null;
    Pixel botPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
    for(int col =0;col<pixels[0].length;col++){
    	for(int row =0;row<pixels.length-1;row++){
    		topPixel = pixels[row][col];
    		botPixel = pixels[row+1][col];
    		if(topPixel.colorDistance(botPixel.getColor())>edgeDist&&topPixel.getColor().equals(Color.WHITE)){
    			topPixel.setColor(Color.BLACK);
    		}
    	}
    }
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture(System.getProperty("user.dir")+"\\src\\pictures\\pixlab\\images\\beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
