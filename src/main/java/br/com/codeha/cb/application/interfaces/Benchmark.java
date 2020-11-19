package br.com.codeha.cb.application.interfaces;

public class Benchmark {

	public long execute(Calculator calculator) {
		long inicio = System.currentTimeMillis();
		
		calculator.calculate();
		
		long fim = System.currentTimeMillis();
		
		return fim - inicio;
	}
}
