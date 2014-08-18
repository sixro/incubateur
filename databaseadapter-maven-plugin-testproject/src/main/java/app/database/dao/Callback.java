package app.database.dao;

public interface Callback<R> {

	void onRow(R record);
	
}
