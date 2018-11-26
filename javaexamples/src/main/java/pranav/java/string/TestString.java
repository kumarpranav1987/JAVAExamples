package pranav.java.string;

public class TestString {
	public static void main(String[] args) {
		//String Literal
		//Till Java6 String literals used to reside in Perm Gen Memory are but from Java7 they reside in Heap Head
		//Note Perm gen has been completely removed in Java8
		String s1 = "Test";
		String s2 = "Test";
		
		//String Object
		String s3 = new String("Test");
		final String s4 = s3.intern();
		
		System.out.println(s1 == s2);
		System.out.println(s2 == s3);
		System.out.println(s3 == s4);
		System.out.println(s1 == s3);
		System.out.println(s1 == s4);
		System.out.println(s1.equals(s2));
		System.out.println(s2.equals(s3));
		System.out.println(s3.equals(s4));
		System.out.println(s1.equals(s4));
		System.out.println(s1.equals(s3));
	}
}