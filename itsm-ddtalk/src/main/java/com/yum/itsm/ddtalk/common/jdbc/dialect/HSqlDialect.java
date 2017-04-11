package com.yum.itsm.ddtalk.common.jdbc.dialect;

/**
 * 
 * @description HSql数据库实现
 * 
 */
public class HSqlDialect implements Dialect {
	protected static final String SQL_END_DELIMITER = ";";
	
	@Override
	public boolean supportPaginal() {
		return true;
	}

	@Override
	public String getPaginationSql(String sql, int offset, int limit) {
		sql = sql.trim();

		StringBuilder sqlBuilder = new StringBuilder(sql.length() + 20);
    sqlBuilder.append(sql);
    sqlBuilder.append(" limit " + limit + " offset " + offset);

    return sqlBuilder.toString();
	}
}
