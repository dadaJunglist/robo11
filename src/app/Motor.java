package app;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;

public class Motor extends Thread {

	private DataExchange dataExchange;

	private static EV3LargeRegulatedMotor leftWheel;
	private static EV3LargeRegulatedMotor rightWheel;

	private static int counter = 0;
	private static Celebration celeb;
	private static boolean exit = false;
	private float multiplier;

	public Motor(DataExchange dataExchange) {

		this.dataExchange = dataExchange;

		leftWheel = new EV3LargeRegulatedMotor(MotorPort.D);
		rightWheel = new EV3LargeRegulatedMotor(MotorPort.A);

		celeb = new Celebration();

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		while (!exit) {

			if(dataExchange.getObstaclesDetected() == false){
//speed of the wheels is set according to amount of light, turning by giving slower speed to wheel in which side robot turns				
				multiplier = 1000;
				if(dataExchange.command  > 0.36) {
					multiplier = 400 ;
				}
<<<<<<< Updated upstream

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

=======
				else if (dataExchange.command  > 0.33)
				{
					multiplier = 500 ;
>>>>>>> Stashed changes
				}
				else if (dataExchange.command  > 0.3)
				{
					multiplier = 750 ;
				}
				else if (dataExchange.command  > 0.25)
				{
					multiplier = 850 ;
				}
				else if (dataExchange.command  > 0.20)
				{
					multiplier = 900 ;
				}
				rightWheel.setSpeed(dataExchange.command * multiplier);
				
				multiplier = 1000;
				if(dataExchange.command  < 0.07) {
					multiplier = 350;
				}
				else if (dataExchange.command  < 0.1) {
					multiplier = 600;
				}
				else if (dataExchange.command  < 0.12) {
					multiplier = 900;
				}	
				leftWheel.setSpeed(dataExchange.command * multiplier);
				
			}


			else {
				
				counter++;
				dataExchange.setCounter(counter);
				
				if(dataExchange.getCounter() == 2) {
					
					leftWheel.stop();
					rightWheel.stop();
					celeb.start();
					
					// celebration dance
					int i = 0;
					while (i < 3) {
					leftWheel.setSpeed(200);
					rightWheel.setSpeed(200);
					leftWheel.backward();
					rightWheel.backward();
					Delay.msDelay(1000);
//					leftWheel.stop();
//					rightWheel.stop();
					rightWheel.rotateTo(180);
					Delay.msDelay(300);
			        i++;
					}
					
					exit = true;
				}
				
				leftWheel.setSpeed(300);
				rightWheel.setSpeed(128);
				
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				
				leftWheel.setSpeed(150);
				rightWheel.setSpeed(300);
				
				
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				leftWheel.setSpeed(300);
				rightWheel.setSpeed(128);
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
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
