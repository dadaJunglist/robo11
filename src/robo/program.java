package robo;

import lejos.hardware.Button;

public class program {

	public static void main(String[] args) {

		
		runner robo = new runner();
		status is = new status();
		
		Light light = new Light(is);
		Usonic usonic = new Usonic(is);
		
		Thread lcheck = new Thread(light);
		Thread scheck = new Thread(usonic);
		
		lcheck.start();
		scheck.start();
		
		while(Button.ESCAPE.isUp()) {
// going to appropriate direction
is.setGoesLeft(true);
			if(is.GoesLeft())
			{
				if(is.isOnLine()) 
				{
					robo.goForward(is.GoesLeft());
				}
				else 
				{
					robo.goLeft();
				}
			}
			else
			{
				if(is.isOnLine()) 
				{
					robo.goForward(is.GoesLeft());
				}
				else 
				{
					robo.goRight();
				}
			}
		
		}
	}
	

}
