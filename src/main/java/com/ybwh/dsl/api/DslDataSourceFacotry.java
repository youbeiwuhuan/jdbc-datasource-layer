package com.ybwh.dsl.api;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import javax.sql.DataSource;

import com.ybwh.dsl.api.interceptor.StatementInterceptor;

public class DslDataSourceFacotry {

	public static DataSource createDataSource(DataSource src, List<StatementInterceptor> statementInterceptors)
			throws SQLException {
		Objects.requireNonNull(src);
		if (null == statementInterceptors || statementInterceptors.isEmpty()) {
			return src;
		}

		return null;
	}

}
