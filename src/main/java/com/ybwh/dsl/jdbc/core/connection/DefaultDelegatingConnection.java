package com.ybwh.dsl.jdbc.core.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.ybwh.dsl.api.interceptor.StatementInterceptor;
import com.ybwh.dsl.jdbc.adapter.AbstractDelegatingConnectionAdapter;
import com.ybwh.dsl.jdbc.core.statement.DefaultDelegatingPreparedStatement;
import com.ybwh.dsl.jdbc.core.statement.DefaultDelegatingStatement;

public class DefaultDelegatingConnection extends AbstractDelegatingConnectionAdapter {
	private List<StatementInterceptor> statementInterceptors;

	public DefaultDelegatingConnection(Connection conn, List<StatementInterceptor> statementInterceptors) {
		super(conn);
		this.statementInterceptors = statementInterceptors;
	}

	private String processSql(String sql) {
		// TODO 处理sql
		return sql;

	}

	@Override
	public Statement createStatement() throws SQLException {
		return new DefaultDelegatingStatement(conn.createStatement(), this, statementInterceptors);
	}

	@Override
	public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
		return new DefaultDelegatingStatement(conn.createStatement(resultSetType, resultSetConcurrency), this,
				statementInterceptors);
	}

	@Override
	public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability)
			throws SQLException {
		return new DefaultDelegatingStatement(
				conn.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability), this,
				statementInterceptors);
	}

	@Override
	public PreparedStatement prepareStatement(String sql) throws SQLException {

		return new DefaultDelegatingPreparedStatement(conn.prepareStatement(processSql(sql)), this,
				statementInterceptors);
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency)
			throws SQLException {
		return new DefaultDelegatingPreparedStatement(
				conn.prepareStatement(processSql(sql), resultSetType, resultSetConcurrency), this,
				statementInterceptors);
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency,
			int resultSetHoldability) throws SQLException {
		return new DefaultDelegatingPreparedStatement(
				conn.prepareStatement(processSql(sql), resultSetType, resultSetConcurrency, resultSetHoldability), this,
				statementInterceptors);
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
		return new DefaultDelegatingPreparedStatement(conn.prepareStatement(processSql(sql), autoGeneratedKeys), this,
				statementInterceptors);
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
		return new DefaultDelegatingPreparedStatement(conn.prepareStatement(processSql(sql), columnIndexes), this,
				statementInterceptors);
	}

	@Override
	public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
		return new DefaultDelegatingPreparedStatement(conn.prepareStatement(processSql(sql), columnNames), this,
				statementInterceptors);
	}
}
