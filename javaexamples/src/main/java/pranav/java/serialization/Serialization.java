package pranav.java.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class A implements Serializable{
	private int a;
	public A(){
		System.out.println("Called Constructor of A");
	}
}
class Emp extends A implements Serializable{
	private int id;

	public Emp(int id) {
		
		System.out.println("Constructor Called");
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + "]";
	}
	 /*private void writeObject(java.io.ObjectOutputStream stream){
		 System.out.println("writeObject");
	 }
	 private void readObject(java.io.ObjectInputStream stream){
		 System.out.println("readObject");
	 }*/
}

public class Serialization {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		/*Emp e1 = new Emp(1);
		FileOutputStream fs = new FileOutputStream("emp.ser");
		ObjectOutputStream os = new ObjectOutputStream(fs);
		os.writeObject(e1);*/
		FileInputStream fi = new FileInputStream("emp.ser");
		ObjectInputStream oi = new ObjectInputStream(fi);
		Emp e2 = (Emp) oi.readObject();
		System.out.println(e2);
	}

}
