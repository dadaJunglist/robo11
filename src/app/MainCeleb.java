package app;

public class MainCeleb {
	static Disco disco = new Disco();

	static Music music = new Music();

	static Dance dance = new Dance();


	public static void main(String[] args) {
		dance.start();
		music.start();
		disco.start();

	}

}

