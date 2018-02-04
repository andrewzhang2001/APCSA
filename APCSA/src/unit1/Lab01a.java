package unit1;

import static java.lang.System.*;

public class Lab01a {
  public static void main(String[] args) {
    StarsAndStripes drawer = new StarsAndStripes();
    drawer.printASmallBox();
    drawer.printTwoBlankLines();
    drawer.printABigBox();
  }
}

class StarsAndStripes
{
    public StarsAndStripes(){
      System.out.println("Stars and Stripes");
      this.printTwoBlankLines();
    }
    public void printTwentyStars(){
      System.out.println("********************");
    }
    public void printTwentyDashes(){
      System.out.println("--------------------");
    }
    public void printTwoBlankLines(){
      System.out.print("\n\n");
    }
    public void printASmallBox(){
      for (int i = 0; i <= 2; i++){
      this.printTwentyDashes();
      this.printTwentyStars();
      }
      this.printTwentyDashes();
    }
    public void printABigBox(){
      for (int i = 0; i <=1; i++){
        this.printASmallBox();
      }
      System.out.println("\n\n");
      }
    }


