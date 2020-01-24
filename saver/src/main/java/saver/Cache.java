package saver;

public interface Cache {

	public Object get(Object key);

	public void put(Object key, Object value);

}
