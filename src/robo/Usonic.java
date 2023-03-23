package robo;

import lejos.hardware.Button;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;
import lejos.robotics.RangeFinder;

public class Usonic implements Runnable{
	
	protected status is;
	
	public Usonic(status is) {
		this.is = is;
	}

	private EV3UltrasonicSensor sensor;
	private SampleProvider		distance;
    private float [] 			sample;
	
	public void run()
	{
		sensor = new EV3UltrasonicSensor(SensorPort.S1);
	    distance = sensor.getDistanceMode();
	    sample = new float[distance.sampleSize()];
	
		while(Button.ESCAPE.isUp()) {
			System.out.println(sample);
//			if (true) { 
//				is.setHasNOobstacle(true);
//			}
//			else {
//				is.setHasNOobstacle(false);
//			}
		}
	}

}
