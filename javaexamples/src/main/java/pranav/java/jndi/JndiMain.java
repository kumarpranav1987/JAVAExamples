package pranav.java.jndi;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.Reference;
import javax.naming.Referenceable;
import javax.naming.StringRefAddr;

class Emp implements Referenceable{
	public static final String NAME = "name";
	public static final String ID = "id";
	private String name;
	private String id;

	public Emp(){
		
	}
	public Emp(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Reference getReference() throws NamingException {
		Reference reference = new Reference(Emp.class.getName(),EmpFactory.class.getName(),null);
		reference.add(new StringRefAddr(NAME, name));
		reference.add(new StringRefAddr(ID, id));
		
		return reference;
	}
	@Override
	public String toString() {
		return "Emp [name=" + name + ", id=" + id + "]";
	}
	
}

public class JndiMain {
	public static void main(String[] args) throws NamingException {
		Hashtable<String, String> environment = new Hashtable<String, String>();
		environment.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");
		environment.put(Context.PROVIDER_URL, "file:/D:/jndi");
		Context context = new InitialContext(environment);
		Emp e = new Emp("Pranav", "1");
		context.rebind("P",e);
		
		Object p = context.lookup("P");
		System.out.println(p.getClass().getName());
		System.out.println(p);
	}

}
