package app;

public class Celebration extends Thread {
	static Disco disco = new Disco();

	static Music music = new Music();
	
	static Dance dance = new Dance();

	@Override
	public void run() {
		music.start();
		disco.start();
		dance.start();
	}

}


