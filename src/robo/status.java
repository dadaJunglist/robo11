package robo;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.RangeFinder;
import lejos.robotics.SampleProvider;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.Color;
import lejos.robotics.ColorDetector;
import lejos.robotics.ColorIdentifier;

public class status {

	public status()
	{
		
	}
	
	public boolean isONline;
	public boolean outFromline;
	public boolean hasNOobstacle;
	public boolean goesLeft;
	public boolean goesRight;
	
	

}
