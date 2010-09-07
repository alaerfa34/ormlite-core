package com.j256.ormlite.support;

import java.sql.SQLException;

/**
 * A reduction of the SQL DataSource so we can implement its functionality outside of JDBC.
 * 
 * @author graywatson
 */
public interface ConnectionSource {

	/**
	 * Return a database connection suitable for read-only operations. After you are done, you should call
	 * {@link #releaseReadOnlyConnection(DatabaseConnection)}.
	 */
	public DatabaseConnection getReadOnlyConnection() throws SQLException;

	/**
	 * Return a database connection suitable for read or write operations. After you are done, you should call
	 * {@link #releaseReadWriteConnection(DatabaseConnection)}.
	 */
	public DatabaseConnection getReadWriteConnection() throws SQLException;

	/**
	 * Release a database connection previously returned by {@link #getReadOnlyConnection()} or
	 * {@link #getReadWriteConnection()}.
	 */
	public void releaseConnection(DatabaseConnection connection) throws SQLException;

	/**
	 * Close any outstanding database connections.
	 */
	public void close() throws SQLException;
}