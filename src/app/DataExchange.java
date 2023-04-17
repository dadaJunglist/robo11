package app;

public class DataExchange {

	private boolean obstaclesDetected = false;
	private float command = 0;
	private int counter = 0;

	public DataExchange() {

	}

	public void setObstaclesDetected(boolean obstaclesDetected) {

		this.obstaclesDetected = obstaclesDetected;

	}
	public boolean getObstaclesDetected() {

		return obstaclesDetected;

	}

	public void setCommand(float command) {
		this.command = command;
	}

	public float getCommand() {
		return command;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}




}
