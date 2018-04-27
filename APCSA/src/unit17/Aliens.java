package unit17;
import java.lang.Math;
public class Aliens {
	private Alien[][] myAliens=new Alien[3][3];
	public Aliens(){
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				myAliens[i][j]=new Alien(60*i+50,70*j+50,(int)(3*Math.random())+1);
			}
		}
	}
	public Alien alienAt(int r, int c){
		return myAliens[r][c];
	}
	public void kill(int r, int c){
		myAliens[r][c]=null;
	}
}
