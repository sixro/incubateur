package saver;

import java.lang.reflect.Method;
import java.util.Arrays;

public class CallKey {

	private final Method method;
	private final Object[] parameters;
	
	public CallKey(Method method, Object[] parameters) {
		super();
		this.method = method;
		this.parameters = parameters;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (obj == null) return false;
		if (! getClass().isAssignableFrom(obj.getClass())) return false;
		
		CallKey that = (CallKey) obj;
		return toString().equals(that.toString());
	}

	@Override
	public String toString() {
		return "{" + method + " :: " + Arrays.toString(parameters) + "}";
	}

}
