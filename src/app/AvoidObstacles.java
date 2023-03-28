package app;

import lejos.hardware.Button;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;

public class AvoidObstacles extends Thread{

	private static DataExchange dataExchange;
	private static EV3UltrasonicSensor usSensor;
	private final int SAVE_DISTANCE;
	private static SampleProvider usDistance;
	private static float[] sample;


	public AvoidObstacles(DataExchange dataExchange) {

		this.dataExchange = dataExchange;
		usSensor = new EV3UltrasonicSensor(SensorPort.S1);
		SAVE_DISTANCE = 20;
		usDistance = usSensor.getDistanceMode();
		sample = new float[usDistance.sampleSize()];

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		try {

			while(!Button.ESCAPE.isDown()) {

				//Reading the ultrasonic sensor
				usDistance.fetchSample(sample, 0);
				float distance = sample[0] * 100;

				//Checking if the obstacle was detected 
				if(distance > SAVE_DISTANCE) {

					dataExchange.setCommand(1);


				}else {

					dataExchange.setCommand(0);

				}

			}
		}finally {

			usSensor.close();

		}


	}



}
