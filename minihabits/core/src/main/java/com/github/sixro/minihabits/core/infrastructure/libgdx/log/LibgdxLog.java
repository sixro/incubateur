package com.github.sixro.minihabits.core.infrastructure.libgdx.log;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Logger;
import com.github.sixro.minihabits.core.infrastructure.libgdx.Log;

public class LibgdxLog implements Log {

	private final Logger logger;
	
	public LibgdxLog(Class<?> objectType) {
		this.logger = new Logger(objectType.getSimpleName(), Gdx.app.getLogLevel());
	}

	@Override
	public void debug(String message) {
		logger.debug(message);
	}

	@Override
	public void info(String message) {
		logger.info(message);
	}

	@Override
	public void error(String message) {
		logger.error(message);
	}

	@Override
	public void error(String message, Throwable t) {
		logger.error(message, t);
	}

}
