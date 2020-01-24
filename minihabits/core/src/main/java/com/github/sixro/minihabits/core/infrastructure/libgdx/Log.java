package com.github.sixro.minihabits.core.infrastructure.libgdx;

public interface Log {

	void debug(String message);
	
	void info(String message);
	
	void error(String message);
	
	void error(String message, Throwable t);
	
}
