package app;

public class DataExchange {

	private boolean obstaclesDetected = false;
	private int command = 1;

	public DataExchange() {

	}

	public void setObstaclesDetected(boolean obstaclesDetected) {

		this.obstaclesDetected = obstaclesDetected;

	}
	public boolean getObstaclesDetected() {

		return obstaclesDetected;

	}

	public void setCommand(int command) {
		this.command = command;
	}

	public int getCommand() {
		return command;
	}
}
