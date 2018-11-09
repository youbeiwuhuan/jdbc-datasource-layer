/*
 * Copyright 1999-2015 dangdang.com.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package com.ybwh.dsl.jdbc.adapter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;

import com.ybwh.dsl.jdbc.unsupported.AbstractUnsupportedOperationStatement;

public abstract class AbstractDelegatingStatementAdapter extends AbstractUnsupportedOperationStatement {
	protected Statement stmt;
	protected AbstractDelegatingConnectionAdapter conn;

	protected AbstractDelegatingStatementAdapter(Statement stmt,AbstractDelegatingConnectionAdapter conn) {
		this.stmt = stmt;
		this.conn = conn;
	}

	@Override
	public Connection getConnection() throws SQLException {
		return conn;
	}

	@Override
	public ResultSet getResultSet() throws SQLException {
		return stmt.getResultSet();
	}

	@Override
	public int getResultSetConcurrency() throws SQLException {
		return stmt.getResultSetConcurrency();
	}

	@Override
	public int getResultSetType() throws SQLException {
		return stmt.getResultSetType();
	}

	@Override
	public ResultSet getGeneratedKeys() throws SQLException {
		return stmt.getGeneratedKeys();
	}

	@Override
	public int getResultSetHoldability() throws SQLException {
		return stmt.getResultSetHoldability();
	}

	@Override
	public final void close() throws SQLException {
		stmt.close();
	}

	@Override
	public final boolean isClosed() throws SQLException {
		return stmt.isClosed();
	}

	@Override
	public final boolean isPoolable() throws SQLException {
		return stmt.isPoolable();
	}

	@Override
	public final void setPoolable(final boolean poolable) throws SQLException {
		stmt.setPoolable(poolable);
	}

	@Override
	public final int getFetchSize() throws SQLException {
		return stmt.getFetchSize();
	}

	@Override
	public final void setFetchSize(final int rows) throws SQLException {
		stmt.setFetchSize(rows);
	}

	@Override
	public final void setEscapeProcessing(final boolean enable) throws SQLException {
		stmt.setEscapeProcessing(enable);
	}

	@Override
	public final void cancel() throws SQLException {
		stmt.cancel();
	}

	@Override
	public final int getUpdateCount() throws SQLException {

		return stmt.getUpdateCount();
	}

	@Override
	public SQLWarning getWarnings() throws SQLException {
		return stmt.getWarnings();
	}

	@Override
	public void clearWarnings() throws SQLException {
		stmt.clearWarnings();
	}

	@Override
	public final boolean getMoreResults() throws SQLException {
		return stmt.getMoreResults();
	}

	@Override
	public final boolean getMoreResults(final int current) throws SQLException {
		return stmt.getMoreResults(current);
	}

	@Override
	public final int getMaxFieldSize() throws SQLException {
		return stmt.getMaxFieldSize();
	}

	@Override
	public final void setMaxFieldSize(final int max) throws SQLException {
		stmt.setMaxFieldSize(max);
	}

	@Override
	public final int getMaxRows() throws SQLException {
		return stmt.getMaxRows();
	}

	@Override
	public final void setMaxRows(final int max) throws SQLException {

		stmt.setMaxRows(max);
	}

	@Override
	public final int getQueryTimeout() throws SQLException {
		return stmt.getQueryTimeout();
	}

	@Override
	public final void setQueryTimeout(final int seconds) throws SQLException {
		stmt.setQueryTimeout(seconds);
	}
}
