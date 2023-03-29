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
			outWheel = new EV3LargeRegulatedMotor(MotorPort.A);
			inWheel = new EV3LargeRegulatedMotor(MotorPort.D);
		} else {
			outWheel = new EV3LargeRegulatedMotor(MotorPort.D);
			inWheel = new EV3LargeRegulatedMotor(MotorPort.A);
		}
		this.is = is;
	}

	private float multiplier;

	public void run() {
		while (Button.ESCAPE.isUp()) {
			
//			if (is.onLine) {
//				goOut();
//			} else if (is.offLine) {
//				goIn();
//			} else {
				goForward();
//			}

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
		
		System.out.println(is.light);
		outWheel.forward();
		inWheel.forward();
	}
// moving robot closer to envelope, by rotating inner wheel slower
//	public void goIn() {
//		outWheel.setSpeed(is.light * multiplier);
//		inWheel.setSpeed(is.light * multiplier * 5 /7);
//		outWheel.forward();
//		inWheel.forward();
//	}
// moving robot away from line by rotating outer wheel slower
//	public void goOut() {
//		outWheel.setSpeed((1/is.light) * multiplier * 2 /7);
//		inWheel.setSpeed((1/is.light) * multiplier);
//		outWheel.forward();
//		inWheel.forward();
//	}
// routine to avoid obstacle
	public void avoidObstacle() {
//		inWheel.stop();
//		outWheel.stop();
//        outWheel.rotate(200, true);
//        Delay.msDelay(500);
//        inWheel.rotate(200, true);
//        outWheel.rotate(200, true);
//        Delay.msDelay(500);
//        inWheel.rotate(200, true);
//        Delay.msDelay(500);
//        inWheel.rotate(200, true);
//        outWheel.rotate(200, true);
	}
// routine for ending work
	public void special() {

	}

}
