package app;

import java.io.File;
import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.utility.Delay;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;

public class Celebration extends Thread {
	
	public static void main(String[] args) {
		
		
        EV3LargeRegulatedMotor motorA = new EV3LargeRegulatedMotor(MotorPort.A);
        EV3LargeRegulatedMotor motorD = new EV3LargeRegulatedMotor(MotorPort.D);
        
        motorA.setSpeed(200);
        motorD.setSpeed(200);
        
        motorA.backward();
        motorD.backward();
        
        int o = 0;
        while (o < 5) {
        	motorA.backward();
        	motorA.rotateTo(180, true);
        	o++;
        }
        
        // free up motor resources.
        motorA.close();
        motorD.close();
        
        
    int i = 0;
    while (i < 3) {		// поставить на 10
    	Button.LEDPattern(1); 
    	Delay.msDelay(300);
    	Button.LEDPattern(0);
    	Delay.msDelay(100);
    	Button.LEDPattern(2); 
    	Delay.msDelay(300);
    	Button.LEDPattern(0);
    	Delay.msDelay(100);
    	Button.LEDPattern(3); 
    	Delay.msDelay(300);
    	
    	i++;
    }  
    
    Sound.playSample(new File("celebration_music.wav"), Sound.VOL_MAX);

		Button.waitForAnyPress();
	}
}


