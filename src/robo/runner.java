package robo;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.motor.*;
import lejos.hardware.port.*;
import lejos.utility.Delay;

public class runner {
	
	public runner()
	{
		
	}
	
	
    private EV3LargeRegulatedMotor motorA = new EV3LargeRegulatedMotor(MotorPort.A);
    private EV3LargeRegulatedMotor motorD = new EV3LargeRegulatedMotor(MotorPort.D);
    
    public void goForward()
    {
        motorA.setSpeed(500);
        motorA.forward();    // starts rotation.
        motorD.setSpeed(500);
        motorD.forward();    // starts rotation.
        Delay.msDelay(3000);
//        motorA.close();
//        motorB.close();
    }
    
    public void goLeft()
    {
        motorA.setSpeed(300);
        motorA.forward();    // starts rotation.
        motorD.setSpeed(185);
        motorD.forward();    // starts rotation.
        Delay.msDelay(3000);
//        motorA.close();
//        motorB.close();
    }
    
    public void goRight()
    {
        motorA.setSpeed(185);
        motorA.forward();    // starts rotation.
        motorD.setSpeed(300);
        motorD.forward();    // starts rotation.
        
//        motorA.close();
//        motorB.close();
    }

    public void returnLeft()
    {
    	
    }
    
    public void returnRight()
    {
    	
    }
    
    public void avoidObstacle()
    {
    	
    }
    
    public void special()
    {
    	
    }
}
