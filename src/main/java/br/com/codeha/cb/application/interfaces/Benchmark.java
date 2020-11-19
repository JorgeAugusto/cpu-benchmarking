package br.com.codeha.cb.application.interfaces;

public class Benchmark {

	public long execute(Calculator calculator) {
		long start = System.currentTimeMillis();
		
		calculator.calculate();
		
		long end = System.currentTimeMillis();
		
		return end - start;
	}
}
