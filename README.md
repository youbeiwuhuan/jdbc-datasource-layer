# jdbc-datasource-layer
写一个DataSource层的拦截层，改写select语句加上附加查询条件。对结果集进行拦截，修改返回的结果集。将参考sharding-jdbc和druid对sql进行解析和修改