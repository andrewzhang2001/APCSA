package adamTowerDefense;//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import javax.swing.JFrame;
import java.awt.Component;

public class AdamTowerDefense extends JFrame
{
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 800;

	public AdamTowerDefense()
	{
		super("Adam Tower Defense");
		setSize(WIDTH,HEIGHT);

		Battlefield theGame = new Battlefield();
		((Component)theGame).setFocusable(true);

		getContentPane().add(theGame);

		setVisible(true);
	}

	public static void main( String args[] )
	{
		AdamTowerDefense run = new AdamTowerDefense();
	}
}