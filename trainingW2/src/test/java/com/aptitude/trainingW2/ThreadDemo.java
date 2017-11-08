package com.aptitude.trainingW2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

import com.google.common.util.concurrent.Callables;

public class ThreadDemo {
	
//	@Test
//	public void th() throws InterruptedException {
////		ExecutorService threadService = Executors.newSingleThreadExecutor();
//		
//		class SharedState {
//			private AtomicInteger counter = new AtomicInteger(0);
//			private int counter1 = 0;
//			
//			public synchronized void increment() {
//				counter1++;
//			}
//		}
//		
//		SharedState x = new SharedState();
//		ArrayList<Thread> threads = new ArrayList<Thread>();
//		
//		for(int i = 0; i<1000; i++) {
//			Thread thread = new Thread(() ->  {
//				for(int j = 0; j<1000; j++) {
//					x.counter.incrementAndGet();
////					x.increment();
////					x.counter1++;
//				}
//			});
//			thread.start();
//			threads.add(thread);
//		}
//		
//		for(Thread e : threads) {
//			e.join();
//		}
//		
//		System.out.println(x.counter);
//	}
	
//	@Test
//	public void th1() throws InterruptedException {
////		ExecutorService threadService = Executors.newSingleThreadExecutor();
//		
//		class SharedState {
//			private ArrayList<String> list = new ArrayList<String>();
//			private List<String> list1 = Collections.synchronizedList(new ArrayList<String>());
//			private List<String> list2 = new CopyOnWriteArrayList<String>();
//			
//			public synchronized void add(String x) {
//				list.add(x);
//			}
//		}
//		
//		SharedState x = new SharedState();
//		ArrayList<Thread> threads = new ArrayList<Thread>();
//		
//		for(int i = 0; i<1000; i++) {
//			int c = i;
//			Thread thread = new Thread(() ->  {				
//				for(int j = 0; j<1000; j++) {
//					String text = String.valueOf(c * j);
////					x.list.add(text);
//					x.list1.add(text);
////					x.list2.add(text);
////					x.add(text);
//				}
//			});
//			thread.start();
//			threads.add(thread);
//		}
//		
//		for(Thread e : threads) {
//			e.join();
//		}
//		
//		System.out.println(x.list1.size());
//	}
	
//	@Test
//	public void lockTest() throws InterruptedException, BrokenBarrierException {
//		ReentrantLock r1 = new ReentrantLock();
//		r1.lock();
//		
//		try {			
//			//something			
//		}finally {
//			r1.unlock();
//		}
//		
//		Semaphore sem = new Semaphore(3);
//		sem.acquire();
//		sem.release();
//		
//		CountDownLatch cdl = new CountDownLatch(10);
//		cdl.await();
//		cdl.countDown();
//		
//		CyclicBarrier cb = new CyclicBarrier(10);
//		cb.await();
//		cb.reset();
//	}
	
//	@Test
//	public void th() throws InterruptedException {
////		ExecutorService threadService = Executors.newSingleThreadExecutor();
//		
//		class SharedState {
//			private AtomicInteger counter = new AtomicInteger(0);
//			private int counter1 = 0;
//			
//			public synchronized void increment() {
//				counter1++;
//			}
//		}
//		
//		SharedState x = new SharedState();
//		ArrayList<Thread> threads = new ArrayList<Thread>();
//		CountDownLatch cdl = new CountDownLatch(1000);
//		
//		for(int i = 0; i<1000; i++) {
//			Thread thread = new Thread(() ->  {
//				for(int j = 0; j<1000; j++) {
//					x.counter.incrementAndGet();
////					x.increment();
////					x.counter1++;
//				}
//				cdl.countDown();
//			});
//			thread.start();
//			threads.add(thread);
//		}
//		
////		for(Thread e : threads) {
////			e.join();
////		}
//		
//		cdl.await();
//		
//		System.out.println(x.counter);
//	}
	
	@Test
	public void poolTest() throws InterruptedException, ExecutionException {
		ExecutorService ftp = Executors.newFixedThreadPool(10);
		ExecutorService ctp = Executors.newCachedThreadPool();
		ExecutorService wsp = Executors.newWorkStealingPool();
		ExecutorService ste = Executors.newSingleThreadExecutor();
		
		System.out.println();
		System.out.println("FixedThreadPool");
		f(ftp);
		
		System.out.println();
		System.out.println("CachedThreadPool");
		f(ctp);
		
		System.out.println();
		System.out.println("WorkStealingPool");
		f(wsp);
		
		System.out.println();
		System.out.println("SingleThreadExecutor");
		f(ste);
		
		

	}
	
	public void f(ExecutorService es) throws InterruptedException, ExecutionException {
		
		class c implements Callable<String> {
			public String call() {
				String temp = Thread.currentThread().getName()  + ": " +  String.valueOf(Math.random());
//				System.out.println(temp);
				return temp;
			}
		}
		
		ArrayList<Callable<String>> callables = new ArrayList<Callable<String>>();
		
		for(int i = 0; i<100; i++) {
			callables.add(new c());
		}
		
		List<Future<String>> invoked = es.invokeAll(callables);
		
		for(Future<?> f : invoked) {
			System.out.println(f.get());
		}
	}
}
