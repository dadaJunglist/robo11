package app;

import java.io.File;
import java.util.Random;
import lejos.hardware.Sound;
import lejos.utility.Delay;

public class Music extends Thread {
	
	Random random = new Random();
	int min = 1;
	int max = 4;
	int getRandomNumberInRange;
	int output = (int) (Math.random()*max + min);
	
	@Override
	public void run() {
		switch (output) {
		case 1:
			System.out.println("Rick Roll");
			Sound.playSample(new File("celebration_music1.wav"), 30);
			break;


		case 2:
			System.out.println("Giga Chad");
			Sound.playSample(new File("celebration_music3.wav"), 30);
			break;


		case 3:
			System.out.println("Calm Down");
			Sound.playSample(new File("celebration_music4.wav"), 30);
			break;


		case 4:
			System.out.println("Tunak Tunak Tun");
			Sound.playSample(new File("celebration_music5.wav"), 30);
			break;
		}
		
	}

}
