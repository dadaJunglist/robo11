package app;

import lejos.hardware.Button;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;

public class Motor extends Thread{

	private DataExchange dataExchange;

	private static EV3LargeRegulatedMotor leftWheel;
	private static EV3LargeRegulatedMotor rightWheel;

	private float SPEED_MAX = 200;
	private float SPEED= (SPEED_MAX*6.075f)/10;


	public Motor(DataExchange dataExchange) {

		this.dataExchange = dataExchange;

		leftWheel = new EV3LargeRegulatedMotor(MotorPort.A);
		rightWheel = new EV3LargeRegulatedMotor(MotorPort.D);
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		leftWheel.setSpeed(SPEED_MAX);
		rightWheel.setSpeed(SPEED_MAX);

		while(!Button.ESCAPE.isDown()) {

			if(dataExchange.getObstaclesDetected() == true){
				
				
				leftWheel.stop();
				rightWheel.stop();
				
//				leftWheel.setSpeed(300);
//				rightWheel.setSpeed(128);
//				
//				try {
//					Thread.sleep(1500);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				
				
//				leftWheel.setSpeed(170);
//				rightWheel.setSpeed(300);
//				
//				
//				try {
//					Thread.sleep(4250);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				
//				leftWheel.setSpeed(300);
//				rightWheel.setSpeed(128);
//				
//				try {
//					Thread.sleep(2000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}

				
			}else {
				
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
				if(dataExchange.getCommand() == 1) {

					leftWheel.setSpeed(SPEED);
					rightWheel.setSpeed(SPEED_MAX);
					leftWheel.backward();
					rightWheel.forward();

				}else if (dataExchange.getCommand() == 2) {

					leftWheel.setSpeed(SPEED_MAX);
					rightWheel.setSpeed(SPEED_MAX);
					leftWheel.forward();
					rightWheel.forward();

				}else if (dataExchange.getCommand() == 3) {

					leftWheel.setSpeed(SPEED_MAX);
					rightWheel.setSpeed(SPEED);
					leftWheel.forward();
					rightWheel.backward();

				}
				
				
			}

			// Moving the robot forward
			rightWheel.forward();
			leftWheel.forward();

		}

		// Stop the motors
		leftWheel.stop(true);
		rightWheel.stop(true);


	}

}
