package com.ybwh.dsl.jdbc.core.datasource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.ybwh.dsl.api.interceptor.StatementInterceptor;
import com.ybwh.dsl.jdbc.adapter.AbstractDelegatingDataSourceAdapter;
import com.ybwh.dsl.jdbc.core.connection.DefaultDelegatingConnection;

public class DefaultDelegatingDatasource extends AbstractDelegatingDataSourceAdapter {
	private  List<StatementInterceptor> statementInterceptors;

	public DefaultDelegatingDatasource(DataSource dataSource,List<StatementInterceptor> statementInterceptors) {
		super(dataSource);
		this.statementInterceptors = statementInterceptors;
	}

	@Override
	public Connection getConnection() throws SQLException {
		return new DefaultDelegatingConnection(dataSource.getConnection(),statementInterceptors);
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		return new DefaultDelegatingConnection(dataSource.getConnection(username, password),statementInterceptors);

	}

}
