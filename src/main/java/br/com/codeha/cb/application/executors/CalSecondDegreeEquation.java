package br.com.codeha.cb.application.executors;

import br.com.codeha.cb.application.interfaces.Calculator;

public class CalSecondDegreeEquation implements Calculator {

	private long numberToLoop;
	private int numberOfThreads;
	private Integer totalClosed = 0;

	public CalSecondDegreeEquation(long numberToLoop, int numberOfThreads) {
		this.numberToLoop = numberToLoop;
		this.numberOfThreads = numberOfThreads;
	}

	@Override
	public void calculate() {
		numberToLoop /= numberOfThreads;

		for (long i = 0; i < this.numberOfThreads; i++) {
			createNewThread(i);
		}
	}

	private void createNewThread(long i) {
		Thread thread = new Thread(new CalSecondDegreeEquationRunnable(numberToLoop, i + 1, this));
		try {
			thread.start();
			thread.join();
		} catch (InterruptedException e) { }
	}

	public synchronized void incTotalClosed() {
		totalClosed++;
	}
}
