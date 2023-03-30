package app;

import lejos.hardware.Button;

public class Main {

	private static DataExchange dataExchange;
	//	private static MoveForward follower;
	private static FollowLine follower;
	private static AvoidObstacles avoider;
	private static Motor motor;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		dataExchange = new DataExchange();
		follower = new FollowLine(dataExchange);
		//		follower = new MoveForward(dataExchange);
		avoider = new AvoidObstacles(dataExchange);
		motor = new Motor(dataExchange);
		
		
		
		avoider.start();

		follower.start();

		motor.start();


		if(Button.ESCAPE.isDown()) {

			System.exit(0);

		}
		



	}

}
