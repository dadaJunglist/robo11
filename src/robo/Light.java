package robo;

import lejos.hardware.Button;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.SampleProvider;

public class Light implements Runnable {

	protected status is;

	public Light(status is) {
		this.is = is;
	}

	private static EV3ColorSensor sensor;
	private static SampleProvider color;
	private static float[] sample;

	public void run() {
		sensor = new EV3ColorSensor(SensorPort.S2);
		color = sensor.getRedMode();
		sample = new float[color.sampleSize()];

		while (Button.ESCAPE.isUp()) {

			color.fetchSample(sample, 0);
			float checkColor = sample[0];

			is.setLight(checkColor);

			if (checkColor < 0.081f) {
				is.setOnLine(true);
			} else {
				is.setOnLine(false);
			}

		}
	}
}
