package robo;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.motor.*;
import lejos.hardware.port.*;
import lejos.utility.Delay;
import lejos.hardware.port.MotorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.SampleProvider;

public class runner {
	
	public runner()
	{
		
	}
	
    private EV3LargeRegulatedMotor leftWheel = new EV3LargeRegulatedMotor(MotorPort.A);
    private EV3LargeRegulatedMotor rightWheel = new EV3LargeRegulatedMotor(MotorPort.D);
	private static final int SPEED_MAX = 500;
	private static final int SPEED = 290;
	private static final int SPEED_TURN = 215;

    
    public void goForward(boolean goesleft)
    {
    	leftWheel.forward();
		rightWheel.forward();
		if(goesleft)
		{
			leftWheel.setSpeed(SPEED_MAX);
			rightWheel.setSpeed(SPEED);
		}
		else
		{
			leftWheel.setSpeed(SPEED);
			rightWheel.setSpeed(SPEED_MAX);
		}
    }
    
    public void goLeft()
    {
    	leftWheel.setSpeed(SPEED_TURN);
		rightWheel.setSpeed(SPEED_MAX);
    }
    
    public void goRight()
    {
    	leftWheel.setSpeed(SPEED);
		rightWheel.setSpeed(SPEED_TURN);
    }
    
    public void avoidObstacle()
    {
    	
    }
    
    public void special()
    {
    	
    }
}
