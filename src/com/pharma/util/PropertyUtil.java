/**
 * 
 */
package com.pharma.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.pharma.exceptions.PharmaException;

/**
 * @author vinay.v
 * 
 *         This Class is used to establish a connection between the the MySQL
 *         DataBase and the java application
 * 
 *
 */
public final class PropertyUtil {
	/**
	 * @return connection between the MYSQL and JAVA application
	 * @throws PharmaException
	 */
	public static final Connection getConnection() throws PharmaException {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PharmaAssistant", "root", "root");
		} catch (ClassNotFoundException e) {
			throw new PharmaException(e);
		} catch (SQLException e) {
			throw new PharmaException(e);
		}
		return connection;

	}
}
