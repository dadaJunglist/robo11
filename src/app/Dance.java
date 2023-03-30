package app;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;

public class Dance extends Thread {

	@Override
	public void run() {
		EV3LargeRegulatedMotor motorA = new EV3LargeRegulatedMotor(MotorPort.A);
		EV3LargeRegulatedMotor motorD = new EV3LargeRegulatedMotor(MotorPort.D);

		
		int o = 0;
		while (o < 6) {
		motorA.setSpeed(200);
		motorD.setSpeed(200);
		motorA.backward();
		motorD.backward();
		Delay.msDelay(1000);
		motorA.stop();
        motorD.stop();
        motorD.rotateTo(180);
		Delay.msDelay(300);
        o++;
		}
		
		// free up motor resources.
		motorA.close();
		motorD.close();
		
	}

}
