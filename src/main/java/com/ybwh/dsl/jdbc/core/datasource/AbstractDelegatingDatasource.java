package com.ybwh.dsl.jdbc.core.datasource;


import javax.sql.DataSource;

import com.ybwh.dsl.jdbc.adapter.AbstractDataSourceAdapter;


public abstract class AbstractDelegatingDatasource extends AbstractDataSourceAdapter{
	
	protected DataSource dataSource;
	
	protected AbstractDelegatingDatasource(DataSource dataSource) {
		this.dataSource = dataSource;
	}





}
