package robo;


import lejos.hardware.motor.*;
import lejos.hardware.port.MotorPort;
public class Wheel implements Runnable{
	public boolean side;
	private EV3LargeRegulatedMotor wheel;
 public Wheel(boolean side) {
	 this.side = side;
	 if (side) {
		 
	  wheel = new EV3LargeRegulatedMotor(MotorPort.A);
	  
	 }
	 else {
		 
	  wheel = new EV3LargeRegulatedMotor(MotorPort.D); 
	 }
 }
@Override
public void run() {
	
	
}
 
public void stop() {
	wheel.stop();
}

public void goFast() {
	wheel.setSpeed(500);
	wheel.forward();
}

public void goSlow() {
	wheel.setSpeed(215);
	wheel.forward();
}

public void go() {
	wheel.setSpeed(290);
	wheel.forward();
}

 
 
 
   

}