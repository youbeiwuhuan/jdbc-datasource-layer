package com.ybwh.dsl.api;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DslJdbcContextHolder {
	
	private static final Lock LOCK = new ReentrantLock();
	
	private static final InheritableThreadLocal<DslJdbcContext> CONTEXT_LOCAL = new InheritableThreadLocal<>();
	
	public static DslJdbcContext get() {
		return CONTEXT_LOCAL.get();
	}
	
	
	public static void set(DslJdbcContext context){
		LOCK.lock();
		try {
			if (null != get()) {
				throw new IllegalStateException();
			}
			
			CONTEXT_LOCAL.set(context);
		} finally {
			LOCK.unlock();
		}
	}
	
	
}
