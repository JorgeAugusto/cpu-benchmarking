package br.com.codeha.cb.application;

import java.util.Scanner;

import br.com.codeha.cb.application.executors.CalSecondDegreeEquation;
import br.com.codeha.cb.application.interfaces.Benchmark;

public class Application {

	private long numberToLoop = 50_000_000L;
	private int numberOfCpuCores = Runtime.getRuntime().availableProcessors();;
	private int numberOfThreads = numberOfCpuCores;
	private long totalTimeInMs = 0L;

	public void execute() {
		Benchmark benchmark = new Benchmark();

		getNumberOfThreads();
		showMsgStartProcessing();

		totalTimeInMs = benchmark.execute(new CalSecondDegreeEquation(this.numberToLoop, this.numberOfThreads));

		showResults();
	}

	private void getNumberOfThreads() {
		try (Scanner input = new Scanner(System.in)) {
			System.out.println(String.format(
					"Informe o número de thread para executar (segerido = %d, cores/núcleos no processador.): ",
					this.numberOfCpuCores));

			this.numberOfThreads = input.nextInt();
		}
	}

	private void showMsgStartProcessing() {
		System.out.println(String.format("Processando: %d repetições com %d threads, aguarde...", this.numberToLoop,
				this.numberOfThreads));
	}

	public void showResults() {
		System.out.println(String.format("Tempo total: %dms", this.totalTimeInMs));
	}
}
