package app;

import lejos.hardware.Button;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.SampleProvider;

public class FollowLine extends Thread{

	private DataExchange dataExchange;

	private static EV3ColorSensor sensor;
	private static SampleProvider color;
	private static float[] sample;

	private static EV3LargeRegulatedMotor leftWheel;
	private static EV3LargeRegulatedMotor rightWheel;

	private static final int SPEED_MAX = 300;
	private static final int SPEED = 185;

	public FollowLine(DataExchange dataExchange) {

		this.dataExchange = dataExchange;

		sensor = new EV3ColorSensor(SensorPort.S2);
		color = sensor.getRedMode();
		sample = new float[color.sampleSize()];

		leftWheel = new EV3LargeRegulatedMotor(MotorPort.A);
		rightWheel = new EV3LargeRegulatedMotor(MotorPort.D);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		leftWheel.setSpeed(SPEED_MAX);
		rightWheel.setSpeed(SPEED_MAX);

		while (!Button.ESCAPE.isDown()) {
			// Reading the color sensor and getting the color value
			color.fetchSample(sample, 0);
			float checkColor = sample[0];

			// \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\Checking from the S1 sensor if there is no obstacle ahead
			if(dataExchange.getCommand() == 1) {

				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// Checking if the color sensor is following the black track
				if (checkColor < 0.1f) {  

					leftWheel.setSpeed(SPEED);
					rightWheel.setSpeed(SPEED_MAX);


				} else {

					leftWheel.setSpeed(SPEED_MAX);                                                                                  
					rightWheel.setSpeed(SPEED);

				}


				leftWheel.forward();
				rightWheel.forward();

				// Moving the robot forward                                                                                

			}else {

				leftWheel.stop();
				rightWheel.stop();


				while (leftWheel.isMoving() && rightWheel.isMoving()) {
					Thread.yield();
				}

			}

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		// Stop the motors and close the color sensor
		leftWheel.stop(true);
		rightWheel.stop(true);
		sensor.close();

	}
}


