package robo;

import lejos.hardware.Button;
import lejos.robotics.Color;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.SampleProvider;

public class Light implements Runnable{
<<<<<<< Updated upstream
=======

	protected status is;
>>>>>>> Stashed changes
	
	public Light(status is) {
		this.is = is;
	}
	
	private static EV3ColorSensor sensor;
	private static SampleProvider color;
	private static float[] sample;

	public void run()
	{
		sensor = new EV3ColorSensor(SensorPort.S2);
		color = sensor.getRedMode();
		sample = new float[color.sampleSize()];
		
		while(Button.ESCAPE.isUp()) {
			color.fetchSample(sample, 0);
			float checkColor = sample[0];
			
			if (checkColor < 0.1f) { 
				is.setOnLine(true);
			}
			else {
				is.setOnLine(false);
			}
						
		}
	}
}
