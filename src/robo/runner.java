package robo;

import lejos.hardware.motor.*;
import lejos.hardware.port.MotorPort;


public class runner {
	
	protected status is;
	
	public runner(status is) {
		this.is = is;
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
    
    public void avoidObstacleLeft()
    {
    	
    }
    
    public void avoidObstacleRight()
    {
    	
    }
    
    public void special()
    {
    	
    }
    
    public void sideCheck()
    {
    	
    }
}
