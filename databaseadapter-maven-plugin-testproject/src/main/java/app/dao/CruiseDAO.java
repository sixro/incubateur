package app.dao;

/**
 * Represents a {@code DAO} related to the cruise context.
 */
public interface CruiseDAO {

	/**
	 * Delete all cancelled cruises returning the number of deletions.
	 * 
	 * @return number of deletions
	 */
	int deleteCancelled();
	
}
