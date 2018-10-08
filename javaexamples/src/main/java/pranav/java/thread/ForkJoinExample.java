package pranav.java.thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinExample {
	public static void main(String[] args) {
		Sum s = new Sum(1, 100);
		ForkJoinPool pool = new ForkJoinPool();
		System.out.println(pool.invoke(s));
	}
}

class Sum extends RecursiveTask<Integer> {
	private static final long serialVersionUID = 1L;
	private int start;
	private int end;

	public Sum(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {
		int result = 0;
		if (start != end) {
			int mid = (start + end) / 2;
			Sum a = new Sum(start, mid);
			a.fork();
			Sum b = new Sum(mid + 1, end);
			b.fork();
			result = result + a.join() + b.join();
		} else {
			return start;
		}
		return result;
	}

}