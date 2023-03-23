package app;

import lejos.hardware.Button;

public class Main {

	private static DataExchange dataExchange;
	private static FollowLine follower;
	private static AvoidObstacles avoider;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		dataExchange = new DataExchange();
		follower = new FollowLine(dataExchange);
		avoider = new AvoidObstacles(dataExchange);

		avoider.start();
		follower.start();

		while(!Button.ESCAPE.isDown()) {


		}

		System.exit(0);


	}

}
