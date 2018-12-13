package pranav.java.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.Function;

public class Java8CompletableFuture {
	public static void main(String[] args) {
		try {
			Function<String, Future<String>> s = Java8CompletableFuture::getName;
			System.out.println(s.apply("A").get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("End");
	}

	public static Future<String> getName(String a) {
		return CompletableFuture.supplyAsync(() -> a);
	}

}
