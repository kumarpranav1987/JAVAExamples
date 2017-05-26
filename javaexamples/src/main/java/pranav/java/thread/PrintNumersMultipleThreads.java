package pranav.java.thread;

import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

public class PrintNumersMultipleThreads {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numberOfThreads = s.nextInt();
		int limit = s.nextInt();
		Thread[] tArray = new Thread[numberOfThreads];
		ReentrantLock[]  lockArray = new ReentrantLock[numberOfThreads];
		for(int i=(numberOfThreads-1);i>=0;i--){
			ReentrantLock l = new ReentrantLock();
			lockArray[i] = l;
			if(i==0){
				l.unlock();
			}else {
				l.lock();
			}
		}
		
		for(int i=numberOfThreads;i>=0;i--){
			tArray[i] = new Thread(new NumberPrinter(lockArray, i, limit, numberOfThreads));
			tArray[i].start();
		}
	}

}

class NumberPrinter implements Runnable {
	private static volatile boolean completed = false;
	private ReentrantLock[] lockArray;
	private ReentrantLock myLock;
	private  final int limit;
	private static volatile int numberToBePrinted = 1;
	private final int numberOfThreads;
	private static volatile int currentIndex = 0;
	public NumberPrinter(ReentrantLock[] lock,int myIndex,int limit,int numberOfThreads) {
		this.lockArray = lock;
		this.limit = limit;
		this.myLock = lockArray[myIndex];
		this.numberOfThreads = numberOfThreads;
	}

	@Override
	public void run() {
		while (!completed) {
			System.out.println(Thread.currentThread().getName() + "   " + numberToBePrinted);
			myLock.lock();
			try {
				currentIndex = (currentIndex++)%numberOfThreads;
				lockArray[currentIndex].lock();
				lockArray[currentIndex].notifyAll();
				lockArray[currentIndex].unlock();
				myLock.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
