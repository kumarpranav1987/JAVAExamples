package pranav.java.assignment;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Question1 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Number Of Threads");
		int n = s.nextInt();
		Lock lock = new ReentrantLock();
		Counter counter = new Counter();
		Condition condition = lock.newCondition();
		for(int i=0;i<n;i++) {
			Thread t = new Thread(new SeqenceRunner(counter, i, lock,condition), "Thread-"+i);
			t.start();
		}
	}
}

class Counter {
	private volatile int count = 0;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}

class SeqenceRunner implements Runnable {
	private Counter counter;
	private int mySequenceNumber;
	private Lock lock;
	private Condition condition;
	public SeqenceRunner(Counter counter, int mySequenceNumber, Lock lock, Condition condition) {
		this.counter = counter;
		this.mySequenceNumber = mySequenceNumber;
		this.lock = lock;
		this.condition = condition;
	}

	@Override
	public void run() {
		lock.lock();
		//Condition condition = lock.newCondition();
		while (counter.getCount() != mySequenceNumber) {
			try {
				condition.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + "  Sequence Number=" + mySequenceNumber);
		counter.setCount(mySequenceNumber+1);
		condition.signalAll();
		lock.unlock();

	}

}