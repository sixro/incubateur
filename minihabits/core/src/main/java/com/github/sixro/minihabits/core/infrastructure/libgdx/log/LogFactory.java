package com.github.sixro.minihabits.core.infrastructure.libgdx.log;

import com.github.sixro.minihabits.core.infrastructure.libgdx.*;

public class LogFactory {

	private LogFactory() { }
	
	public static Log newLog(Class<?> objectType) {
		return LibgdxUtils.isLibgdxEnvironment()
			? new LibgdxLog(objectType)
			: new StdOutLog(objectType);
	}
	
}
