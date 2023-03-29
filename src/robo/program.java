package robo;

import lejos.hardware.Button;
import lejos.hardware.motor.*;
import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;

public class program {

	public static int counter = 1;

	public static void main(String[] args) {

		status is = new status();
// starting to check for the light an ultra sonic sensors data
		Light light = new Light(is);
		Usonic usonic = new Usonic(is);
		Thread lcheck = new Thread(light);
		Thread scheck = new Thread(usonic);
		lcheck.start();
		scheck.start();
// providing direction of movement
		is.setGoesLeft(true);
// motors control thread
		runner robo = new runner(is.goesLeft, is);
		Thread go = new Thread(robo);
		go.start();

	}

}
