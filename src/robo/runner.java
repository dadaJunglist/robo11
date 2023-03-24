package robo;


public class runner {
	
	protected status is;
	
	public runner(status is) {
		this.is = is;
	}
	

	Wheel leftWheel = new Wheel(true);
	Wheel rightWheel = new Wheel(false);
	
	Thread left = new Thread(leftWheel);
	Thread rght = new Thread(rightWheel);
	
	
	
    
    public void goForward()
    {
    	
    }
    
    public void goLeft()
    {
    	
    }
    
    public void goRight()
    {
    	
    }
    
    public void goLeftWeak()
    {
    	
    }
    
    public void goRightWeak()
    {
    	
    }
    
    public void avoidObstacleLeft()
    {
    	
    }
    
    public void avoidObstacleRight()
    {
    	
    }
    
    public void special()
    {
    	
    }
    
    public void sideCheck()
    {
    	
    }
}
