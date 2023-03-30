package app;

import lejos.hardware.Button;
import lejos.utility.Delay;

public class Disco extends Thread {

	
	@Override
	public void run() {

		int i = 0;
		while (i < 9) {
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

	}

}
