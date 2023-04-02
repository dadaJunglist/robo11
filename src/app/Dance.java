package app;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;

public class Dance extends Thread {

	@Override
	public void run() {
		EV3LargeRegulatedMotor leftWheel = new EV3LargeRegulatedMotor(MotorPort.A);
		EV3LargeRegulatedMotor rightWheel = new EV3LargeRegulatedMotor(MotorPort.D);

		
		int o = 0;
		while (o < 6) {
		leftWheel.setSpeed(200);
		rightWheel.setSpeed(200);
		leftWheel.backward();
		rightWheel.backward();
		Delay.msDelay(1000);
		leftWheel.stop();
		rightWheel.stop();
		rightWheel.rotateTo(180);
		Delay.msDelay(300);
        o++;
		}
		
		// free up motor resources.
		leftWheel.close();
		rightWheel.close();
		
	}

}
