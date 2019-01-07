package pranav.java.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalWithThreadPool {
	public static void main(String[] args) throws InterruptedException {
		//Runnable runnable = new SimpleRunnable();
		
		Runnable runnable = new ThreadLocalRunnable();
		/*Thread t1 = new Thread(runnable,"First Thread");
		Thread t2 = new Thread(runnable, "Second Thread");
		t1.start();
		t1.join();
		t2.start();
		t2.join();*/
		
		ExecutorService es = Executors.newSingleThreadExecutor();
		
		
		
		//ExecutorService es = Executors.newFixedThreadPool(2);
		es.submit(runnable);
		es.submit(runnable);
		es.shutdown();
	}
	
	static class Counter {
		private int counter = 0;

		public synchronized void increment() {
			counter++;
		}

		public int getCounter() {
			return counter;
		}

	}

	static class SimpleRunnable implements Runnable {
		private Counter counter = new Counter();

		@Override
		public void run() {
			for (int i = 0; i < 5; i++) {
				counter.increment();
			}
			System.out.println(Thread.currentThread().getName() + " Counter=" + counter.getCounter());
		}
	}

	static class ThreadLocalRunnable implements Runnable {
		private ThreadLocal<Counter> counter = ThreadLocal.withInitial(() -> new Counter());;

		@Override
		public void run() {
			for (int i = 0; i < 5; i++) {
				counter.get().increment();
			}
			System.out.println(Thread.currentThread().getName() + " Counter=" + counter.get().getCounter());
			//use try finally
			//counter.remove();
		}
	}
}