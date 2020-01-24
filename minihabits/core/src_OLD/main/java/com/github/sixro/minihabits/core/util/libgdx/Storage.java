package com.github.sixro.minihabits.core.util.libgdx;

import java.util.*;

public interface Storage<T> {

	List<T> findAll();
	
	void saveAll(List<T> items);
	
}
