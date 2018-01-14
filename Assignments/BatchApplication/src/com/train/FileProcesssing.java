package com.train;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FileProcesssing 
{

	public void processFiles(String[] files) {
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		for (String fileName : files) {
			executorService.execute(new LoadFile(fileName));
		}

		System.out.println("Completed scheduling the jobs..");

		executorService.shutdown();

		try {
			executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
		} catch (InterruptedException e) {
			System.out.println(e);
		}

	}
}
