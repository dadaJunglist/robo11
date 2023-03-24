package robo;

import lejos.hardware.Button;

public class program {

	public static void main(String[] args) {

		
		
		status is = new status();
		runner robo = new runner(is);
		Light light = new Light(is);
		Usonic usonic = new Usonic(is);
		
		Thread lcheck = new Thread(light);
		Thread scheck = new Thread(usonic);
		
		lcheck.start();
		scheck.start();
		
		if(is.GoesLeft()) {
			while(Button.ESCAPE.isUp())
			{
				if(is.isOnLine()) 
				{
					robo.goRightWeak();
				}
				else if(is.isOffLine())
				{
					robo.goLeft();
				}
				else
				{
					robo.goForward();
				}
			}
		}
		else
			{
			while(Button.ESCAPE.isUp())
			{
				if(is.isOnLine()) 
				{
					robo.goLeftWeak();
				}
				else if(is.offLine)
				{
					robo.goRight();
				}
				else
				{
					robo.goForward();
				}
			}
		
		}
	}
	

}
