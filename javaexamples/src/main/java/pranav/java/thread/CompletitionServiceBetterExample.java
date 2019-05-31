package pranav.java.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletitionServiceBetterExample {

	public static void main(String[] args) {

		List<Task> tasks = Arrays.asList(new Task("Long Task",5000), new Task("Small Task",2000));
		ExecutorService es = Executors.newCachedThreadPool();
		CompletionService<String> cs = new ExecutorCompletionService<String>(es);
		List<Future<String>> results = new ArrayList<Future<String>>();
		for (int i = 0; i < tasks.size(); i++) {
			results.add(es.submit(tasks.get(i)));
			//cs.submit(tasks.get(i));
		}

		for (int i = 0; i < tasks.size(); i++) {
			try {
				System.out.println(results.get(i).get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		es.shutdown();
	
	}

}
class Task implements Callable<String> {

	private int time;
	private String taskName;

	public Task(String taskName,int time) {
		this.time = time;
		this.taskName = taskName;
	}

	@Override
	public String call() throws Exception {
		System.out.println("Started Task ->"+taskName);
		Thread.sleep(time);
		String threadName = Thread.currentThread().getName();
		System.out.println("Complete Task ->" + taskName + " Thread Name:" + threadName);
		return "Got Result of ->  " + taskName;
	}

}
