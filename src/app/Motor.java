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
	private float accelerator;

	public Motor(DataExchange dataExchange) {

		this.dataExchange = dataExchange;

		leftWheel = new EV3LargeRegulatedMotor(MotorPort.A);
		rightWheel = new EV3LargeRegulatedMotor(MotorPort.D);

		celeb = new Celebration();

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		while (!exit) {

			if (dataExchange.getObstaclesDetected() == false) {
				//speed of the wheels is set according to amount of light, turning by giving slower speed to wheel in which side robot turns	
				//accelerator variable is used to make robot go faster on darker segments of pathway 
				multiplier = 1100;

				if (dataExchange.getCommand() > 0.09) {
					accelerator = 1;
				} else {
					accelerator = 4;
				}

				if (dataExchange.getCommand() > 0.33) {
					multiplier = multiplier * 2 / 5;
				} else if (dataExchange.getCommand() > 0.3) {
					multiplier = multiplier * 3 / 4;
				} else if (dataExchange.getCommand() > 0.25) {
					multiplier = multiplier * 4 / 5;
				} else if (dataExchange.getCommand() > 0.20) {
					multiplier = multiplier * 5 / 6;
				}
				rightWheel.setSpeed(50 + dataExchange.getCommand() * multiplier * accelerator);

				multiplier = 1100;
				if (dataExchange.getCommand() < 0.07) {
					multiplier = multiplier / 3;
				} else if (dataExchange.getCommand() < 0.1) {
					multiplier = multiplier / 2;
				} else if (dataExchange.getCommand() < 0.12) {
					multiplier = multiplier * 4 / 5;
				}
				leftWheel.setSpeed(50 + dataExchange.getCommand() * multiplier * accelerator);

			}

			else {

				counter++;
				dataExchange.setCounter(counter);

				if (dataExchange.getCounter() == 2) {

					leftWheel.stop();
					rightWheel.stop();
					celeb.start();

					// celebration dance
					leftWheel.setSpeed(200);
					rightWheel.setSpeed(200);
					leftWheel.backward();
					rightWheel.backward();
					Delay.msDelay(1100);
					leftWheel.stop();
					rightWheel.stop();
					rightWheel.rotateTo(180);
					Delay.msDelay(300);

					exit = true;
				}

//				Obstacle Avoidance
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
					Thread.sleep(3350);
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
