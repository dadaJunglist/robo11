package app;

import java.io.File;
import lejos.hardware.Sound;

public class Music extends Thread {
	
	@Override
	public void run() {
		Sound.playSample(new File("celebration_music.wav"), Sound.VOL_MAX);

		
	}

}
