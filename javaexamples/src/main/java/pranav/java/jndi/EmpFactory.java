package pranav.java.jndi;

import java.util.Enumeration;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.RefAddr;
import javax.naming.Reference;
import javax.naming.spi.ObjectFactory;

public class EmpFactory implements ObjectFactory{

	public Object getObjectInstance(Object obj, Name name, Context nameCtx, Hashtable<?, ?> environment)
			throws Exception {
		if (! (obj instanceof Reference)) {
			return null;
		}
		Reference reference = (Reference)obj;
		if (!Emp.class.getName().equals(reference.getClassName())) {
			return null;
		}
		Emp e = new Emp();
		Enumeration<RefAddr> address = reference.getAll();
		while (address.hasMoreElements()) {
			RefAddr refAddr = (RefAddr) address.nextElement();
			switch (refAddr.getType()) {
			case Emp.NAME:
				e.setName((String)refAddr.getContent());
				break;
			case Emp.ID:
				e.setId((String)refAddr.getContent());
				break;
			}
		}
		return e;
	}

}
