package app;

public class MainCeleb {
	static Disco disco = new Disco();
	static Thread disco_run = new Thread(disco);
	
	
	static Music music = new Music();
	static Thread music_run = new Thread(music);
	
	static Dance dance = new Dance();
	static Thread dance_run = new Thread(dance);


	public static void main(String[] args) {
		dance_run.start();
		music_run.start();
		disco_run.start();
		
	}

}

