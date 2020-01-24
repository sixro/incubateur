package net.sixro.xuperior;

/**
 * Represents a listener of size change.
 */
public interface OnSizeChangeListener {

	/**
	 * Called when the size of a width changes.
	 * 
	 * @param width the new width
	 * @param height the new height
	 */
	void onSizeChange(int width, int height);
	
}
