package pranav.java.thread;

public class InheritableThreadLocalExample {
	public static void main(String[] args) {
		Thread parentThread = new ParentThread();
		parentThread.start();
	}

	static class ParentThread extends Thread {
		// public static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
		// public static InheritableThreadLocal<Integer> threadLocal = new InheritableThreadLocal<>();
		public static InheritableThreadLocal<Integer> threadLocal = new InheritableThreadLocal<Integer>() {

			@Override
			protected Integer childValue(Integer parentValue) {
				return 200;
			}
			
		};
		@Override
		public void run() {
			Thread.currentThread().setName("Parent Thread");
			threadLocal.set(100);
			System.out.println(Thread.currentThread().getName() + " = " + ParentThread.threadLocal.get());
			Thread childThread = new ChildThread();
			childThread.start();
		}
	}

	static class ChildThread extends Thread {
		@Override
		public void run() {
			Thread.currentThread().setName("Child Thread");
			System.out.println(Thread.currentThread().getName() + " = " + ParentThread.threadLocal.get());
		}
	}
}
