package robo;

import lejos.hardware.Button;
import lejos.hardware.motor.*;
import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;

public class runner implements Runnable {

	private EV3LargeRegulatedMotor outWheel;
	private EV3LargeRegulatedMotor inWheel;

	protected status is;

	public runner(boolean side, status is) {
		this.is = is;

		if (side) {
			outWheel = new EV3LargeRegulatedMotor(MotorPort.D);
			inWheel = new EV3LargeRegulatedMotor(MotorPort.A);
		} else {
			outWheel = new EV3LargeRegulatedMotor(MotorPort.A);
			inWheel = new EV3LargeRegulatedMotor(MotorPort.D);
		}
		this.is = is;
	}

	private float multiplier;

	public void run() {
		while (Button.ESCAPE.isUp()) {
			
			if(is.hasObstacle)
			{
				System.out.println(is.hasObstacle);
				avoidObstacle();
				is.setHasObstacle(false);
			}
			else
			{
				goForward();
			}
			
		}
	}
// moving robot forward, adjusting speed for small turns
	public void goForward() {
		multiplier = 1000;
		if(is.light  > 0.36) {
			multiplier = 400 ;
		}
		else if (is.light  > 0.33)
		{
			multiplier = 500 ;
		}
		else if (is.light  > 0.3)
		{
			multiplier = 750 ;
		}
		else if (is.light  > 0.25)
		{
			multiplier = 850 ;
		}
		else if (is.light  > 0.20)
		{
			multiplier = 900 ;
		}
		inWheel.setSpeed(is.light * multiplier);
		
		multiplier = 1000;
		if(is.light  < 0.07) {
			multiplier = 350;
		}
		else if (is.light  < 0.1) {
			multiplier = 600;
		}
		else if (is.light  < 0.12) {
			multiplier = 900;
		}	
		outWheel.setSpeed(is.light * multiplier);
		
		outWheel.forward();
		inWheel.forward();
	}

// routine to avoid obstacle
	public void avoidObstacle() {
		outWheel.forward();
		inWheel.forward();
		inWheel.setSpeed(500);
		outWheel.setSpeed(500);
		inWheel.stop();
		outWheel.stop();
		Delay.msDelay(1000);
//turn in
		inWheel.rotate(0, true);
        outWheel.rotate(200, true);
        Delay.msDelay(1000);
//go forward
        inWheel.rotate(220, true);
        outWheel.rotate(220, true);
        Delay.msDelay(1000);
//turn out
        inWheel.rotate(200, true);
        outWheel.rotate(0, true);
        Delay.msDelay(1000);
//go outside
        inWheel.rotate(240, true);
        outWheel.rotate(255, true);
        Delay.msDelay(1000);
	}
// routine for ending work
	public void special() {

	}

}
