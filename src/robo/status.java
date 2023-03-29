package robo;

public class status {

	public status() {

	}

	public boolean onLine;
	public float light;
	public boolean hasObstacle;
	public boolean goesLeft;

	public boolean isOnLine() {
		return onLine;
	}

	public void setOnLine(boolean onLine) {
		this.onLine = onLine;
	}

	public boolean isHasObstacle() {
		return hasObstacle;
	}

	public void setHasObstacle(boolean hasObstacle) {
		this.hasObstacle = hasObstacle;
	}

	public boolean GoesLeft() {
		return goesLeft;
	}

	public void setGoesLeft(boolean goesLeft) {
		this.goesLeft = goesLeft;
	}

	public float getLight() {
		return light;
	}

	public void setLight(float light) {
		this.light = light;
	}

}
