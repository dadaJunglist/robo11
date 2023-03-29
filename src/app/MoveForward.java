package app;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;

public class MoveForward extends Thread {
	DataExchange DEObj;

	private static EV3LargeRegulatedMotor leftWheel;
	private static EV3LargeRegulatedMotor rightWheel;

	public MoveForward(DataExchange DE) {
		DEObj = DE;
		leftWheel = new EV3LargeRegulatedMotor(MotorPort.A);
		rightWheel = new EV3LargeRegulatedMotor(MotorPort.D);

		leftWheel.setSpeed(300);
		rightWheel.setSpeed(300);
	}

	public void run() {
		// Infinite Task
		while (true) {
			if (DEObj.getCommand() == 1) {
				leftWheel.setSpeed(300);
				rightWheel.setSpeed(300);

				leftWheel.forward();
				rightWheel.forward();

			} else {

//				Drive circle
//
				leftWheel.setSpeed(300);
				rightWheel.setSpeed(128);
				
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				
				leftWheel.setSpeed(170);
				rightWheel.setSpeed(300);
				
				
				try {
					Thread.sleep(4250);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				leftWheel.setSpeed(300);
				rightWheel.setSpeed(128);
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

//				Drive circle ends
				
				
				
				
				

//				Drive Square

				// make the right turn.
				leftWheel.forward();
				rightWheel.backward();

				leftWheel.setSpeed(200);
				rightWheel.setSpeed(200);

				// adjust time to get a 90% turn.
				try {
					Thread.sleep(700);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				leftWheel.stop();
				rightWheel.stop();

				// set right motor back to forward motion.
				leftWheel.forward();
				rightWheel.forward();
				// adjust time
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				// make the left turn.

				leftWheel.backward();
				rightWheel.forward();


				// adjust time to get a 90% turn.
				try {
					Thread.sleep(800);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				
				leftWheel.forward();
				rightWheel.forward();

				try {
					Thread.sleep(5500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				// make the left turn.
				leftWheel.backward();
				rightWheel.forward();

				// adjust time to get a 90% turn.
				try {
					Thread.sleep(800);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				leftWheel.forward();
				rightWheel.forward();

				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				// make the right turn.
				leftWheel.forward();
				rightWheel.backward();


				// adjust time to get a 90% turn.
				try {
					Thread.sleep(700);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}	

//				Drive Square ends
				
				
				
//				reverse square
				
				leftWheel.backward();
				rightWheel.forward();


				// adjust time to get a 90% turn.
				try {
					Thread.sleep(600);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				
				leftWheel.backward();
				rightWheel.backward();

				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				leftWheel.backward();
				rightWheel.forward();

				// adjust time to get a 90% turn.
				try {
					Thread.sleep(600);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				leftWheel.backward();
				rightWheel.backward();

				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				leftWheel.backward();
				rightWheel.forward();	

				// adjust time to get a 90% turn.
				try {
					Thread.sleep(600);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				leftWheel.backward();
				rightWheel.backward();

				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				leftWheel.backward();
				rightWheel.forward();


				// adjust time to get a 90% turn.
				try {
					Thread.sleep(700);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				
				
//				reverse square ends
				
				
				

			}
		}
	}
}