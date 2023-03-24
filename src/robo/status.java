package robo;

public class status {

	public status()
	{
		
	}
	
	public boolean onLine;
	public boolean offLine;
	public boolean hasNOobstacle;
	public boolean goesLeft;
	
	
	public boolean isOnLine() {
		return onLine;
	}
	public void setOnLine(boolean onLine) {
		this.onLine = onLine;
	}
	public boolean isOffLine() {
		return offLine;
	}
	public void setOffLine(boolean offLine) {
		this.offLine = offLine;
	}
	public boolean isHasNOobstacle() {
		return hasNOobstacle;
	}
	public void setHasNOobstacle(boolean hasNOobstacle) {
		this.hasNOobstacle = hasNOobstacle;
	}
	public boolean GoesLeft() {
		return goesLeft;
	}
	public void setGoesLeft(boolean goesLeft) {
		this.goesLeft = goesLeft;
	}

}
