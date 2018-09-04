package pranav.java.clone;

import java.util.ArrayList;
import java.util.List;

class Student implements Cloneable{
	private String name;

	public Student(String name) {
		this.name = name;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return "Student [name=" + name + "]";
	}

}

public class CloningExample {
	public static void main(String[] args) throws CloneNotSupportedException {
		int i =- 2147483648;
		Student s1 = new Student("A");
		Student s2 = (Student) s1.clone();
		System.out.println(s2.toString());
		System.out.println(Integer.MAX_VALUE+"   "+Integer.MIN_VALUE);
		List<Object> l = new ArrayList<>();
		l.add("A");
		l.add(1);
	}
}
