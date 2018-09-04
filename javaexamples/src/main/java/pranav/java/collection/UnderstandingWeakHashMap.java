package pranav.java.collection;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

class Key {
	private String key;

	public Key(String key) {
		this.key = key;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Key other = (Key) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}

}

public class UnderstandingWeakHashMap {
	public static void main(String[] args) {
		String value = "VALUE";
		WeakReference<String>wf=new WeakReference<String>(value);
		System.out.println(wf.get());
	}
}
