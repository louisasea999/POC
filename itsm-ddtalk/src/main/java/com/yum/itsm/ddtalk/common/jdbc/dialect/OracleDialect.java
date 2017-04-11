package com.yum.itsm.ddtalk.common.jdbc.dialect;

/**
 * 
 * @description Oracle数据库实现
 * 
 */
public class OracleDialect
		implements Dialect {

	@Override
	public boolean supportPaginal() {
		return true;
	}

	public String getPaginationSql(	String sql,
														int offset,
														int limit) {
		sql = sql.trim();

		StringBuffer pageSql = new StringBuffer(sql.length() + 100);
		pageSql.append("select * from ( select row_.*, rownum rownum_ from ( ");
		pageSql.append(sql);
		pageSql.append(" ) row_ ) where rownum_ > " + offset + " and rownum_ <= " + (offset + limit));

		return pageSql.toString();
	}

}
