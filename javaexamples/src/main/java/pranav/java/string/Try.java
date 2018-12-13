package pranav.java.string;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

public class Try {

	public static void main(String[] args) throws InterruptedException {
		ReferenceQueue<String> q = new ReferenceQueue<>();
		String s = new String("Test");
		SoftReference<String> sr = new SoftReference<String>(s, q);
		s=null;
		byte[] b = new byte[8002400];
		b=null;
		try {
			System.out.println(sr.get());
			byte[] b1 = new byte[900240000];
		}catch (Throwable e) {
			System.out.println(q.poll());
			System.out.println(sr.get());
		}
	}
}
