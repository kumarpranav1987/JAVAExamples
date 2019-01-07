package pranav.java.thread;

public class ThreadLocalExample {
	public static void main(String[] args) throws InterruptedException {
		Counter counter = new Counter();
		Runnable runnable = new SimpleRunnable();
		//Runnable runnable = new ThreadLocalRunnable();
		Thread firstThread = new Thread(runnable, "First Thread");
		Thread secondThread = new Thread(runnable, "Seconds Thread");
		firstThread.start();
		firstThread.join();
		secondThread.start();
		secondThread.join();
	}
}

class Counter {
	private int counter = 0;

	public synchronized void increment() {
		counter++;
	}

	public int getCounter() {
		return counter;
	}

}

class SimpleRunnable implements Runnable {
	private Counter counter = new Counter();

	/*
	 * public SimpleRunnable(Counter counter) { this.counter = counter; }
	 */

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			counter.increment();
		}
		System.out.println(Thread.currentThread().getName() + " Counter=" + counter.getCounter());
	}
}

class ThreadLocalRunnable implements Runnable {
	private ThreadLocal<Counter> counter = ThreadLocal.withInitial(() -> new Counter());;

	/*
	 * public ThreadLocalRunnable(Counter counter) { this.counter =
	 * ThreadLocal.withInitial(() -> counter); }
	 */

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			counter.get().increment();
		}
		System.out.println(Thread.currentThread().getName() + " Counter=" + counter.get().getCounter());
	}
}