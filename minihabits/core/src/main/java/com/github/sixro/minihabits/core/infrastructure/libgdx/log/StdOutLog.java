package com.github.sixro.minihabits.core.infrastructure.libgdx.log;

import com.github.sixro.minihabits.core.infrastructure.libgdx.Log;

public class StdOutLog implements Log {

	private final String prefix;
	
	public StdOutLog(Class<?> objectType) {
		this.prefix = objectType.getSimpleName() + ": ";
	}

	@Override
	public void debug(String message) {
		log("[D]", message);
	}

	@Override
	public void info(String message) {
		log("[I]", message);
	}

	@Override
	public void error(String message) {
		log("[E]", message);
	}

	@Override
	public void error(String message, Throwable t) {
		log("[E]", message);
		t.printStackTrace(System.out);
	}

	private void log(String level, String message) {
		System.out.println(prefix + " " + level + " " + message);
	}

}
