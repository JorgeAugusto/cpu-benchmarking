package br.com.codeha.cb.application.executors;

import java.util.Random;

public class CalSecondDegreeEquationRunnable implements Runnable {

	private long numberToLoop;
	private CalSecondDegreeEquation calSecondDegreeEquation;
	private static Random random = new Random(System.currentTimeMillis());
	private int limit = 0;

	public CalSecondDegreeEquationRunnable(long numberToLoop, long idThread,
			CalSecondDegreeEquation calSecondDegreeEquation) {
		final int LIMIT_OF_LIMIT = 100;

		this.numberToLoop = numberToLoop;
		this.calSecondDegreeEquation = calSecondDegreeEquation;

		random.setSeed(System.currentTimeMillis());
		limit = 1 + random.nextInt(LIMIT_OF_LIMIT);
	}

	@Override
	public void run() {
		for (long i = 0; i < this.numberToLoop; i++) {
			precessStep(i);
			// simulatedDelay();
		}

		// notify the end of thread
		synchronized (this.calSecondDegreeEquation) {
			this.calSecondDegreeEquation.incTotalClosed();
			this.calSecondDegreeEquation.notifyAll();
		}
	}

	private void precessStep(long i) {

		int a = 1 + random.nextInt(limit);
		int b = 1 + random.nextInt(limit);
		int c = 1 + random.nextInt(limit);

		calEquation(a, b, c);
	}

	@SuppressWarnings("unused")
	private void calEquation(int a, int b, int c) {
		double delta;
		double x1;
		double x2;

		if (a != 0) {
			delta = Math.pow(b, 2) - (4 * a * c);

			if (delta >= 0) {
				x1 = ((-b + (Math.sqrt(delta))) / (2 * a));
				x2 = ((-b - (Math.sqrt(delta))) / (2 * a));
			}
		}
	}

	@SuppressWarnings("unused")
	private void simulatedDelay() {
		final long MS_TO_SLEEPING = 1000;

		try {
			Thread.sleep(MS_TO_SLEEPING);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
