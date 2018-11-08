package com.ybwh.dsl.jdbc.core.connection;

import java.sql.Connection;

import com.ybwh.dsl.jdbc.adapter.AbstractConnectionAdapter;

public abstract class AbstractDelegatingConnection extends AbstractConnectionAdapter{
	protected Connection conn;
	protected AbstractDelegatingConnection(Connection conn) {
		this.conn = conn;
	}



}
