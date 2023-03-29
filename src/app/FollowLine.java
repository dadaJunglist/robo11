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

	public FollowLine(DataExchange dataExchange) {

		this.dataExchange = dataExchange;

		sensor = new EV3ColorSensor(SensorPort.S2);
		color = sensor.getRedMode();
		sample = new float[color.sampleSize()];


	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		while (!Button.ESCAPE.isDown()) {
			// Reading the color sensor and getting the color value
			color.fetchSample(sample, 0);
			float checkColor = sample[0];

			// Checking if the color sensor is following the black track and sending the commands for a certain situations
			if (checkColor < 0.2f) {

				dataExchange.setCommand(1);


			} else if(checkColor > 0.2f && checkColor < 0.3f) {

				dataExchange.setCommand(2);


			}else {

				dataExchange.setCommand(3);

			}                                                                      

		}
		// Close the color sensor
		sensor.close();

	}
}
