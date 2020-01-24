package saver;

import java.lang.reflect.Method;

class Utils {

	private Utils() { }
	
	public static Class<?>[] toParameterTypes(Object[] args) {
		Class<?>[] types = new Class<?>[args.length];
		for (int i = 0; i < args.length; i++) {
			types[i] = args[i].getClass();
		}
		return types;
	}
	
	public static Method findMethod(Class<?> owner, String methodName, Class<?>[] parameterTypes) {
		try {
			return owner.getMethod(methodName, parameterTypes);
		} catch (NoSuchMethodException | SecurityException e) {
			throw new RuntimeException("Unhandled exception " + e.getClass().getName() + " with message '" + e.getMessage() + "' obtained", e);
		}
	}

	public static String[] toStrings(Object[] objects) {
		String[] strings = new String[objects.length];
		for (int i = 0; i < objects.length; i++) {
			Object object = objects[i];
			strings[i] = (object == null) ? "<null>" : object.toString();
		}
		return strings;
	}

}
