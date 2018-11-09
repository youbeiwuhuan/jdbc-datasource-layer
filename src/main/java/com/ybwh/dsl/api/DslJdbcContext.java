package com.ybwh.dsl.api;

import java.util.concurrent.ConcurrentHashMap;

public class DslJdbcContext {
	private ConcurrentHashMap<String, Object> content = new ConcurrentHashMap<>();

	public void put(String key, Object val) {
		content.put(key, val);
	}

	public Object get(String key) {
		return content.get(key);
	}

}
