package com.aptitude.trainingW2;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

public class ThreadDemo {
	
	@Test
	public void th() throws InterruptedException {
//		ExecutorService threadService = Executors.newSingleThreadExecutor();
		
		class SharedState {
			private AtomicInteger counter = new AtomicInteger(0);
			private int counter1 = 0;
			
			public synchronized void increment() {
				counter1++;
			}
		}
		
		SharedState x = new SharedState();
		ArrayList<Thread> threads = new ArrayList<Thread>();
		
		for(int i = 0; i<1000; i++) {
			Thread thread = new Thread(() ->  {
				for(int j = 0; j<1000; j++) {
					x.counter.incrementAndGet();
//					x.increment();
//					x.counter1++;
				}
			});
			thread.start();
			threads.add(thread);
		}
		
		for(Thread e : threads) {
			e.join();
		}
		
		System.out.println(x.counter);
	}
}
