package br.com.aula.cristiano.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Classe responsável pela conexão com o banco de dados.
 * @author Cris
 * @since 28/02/2017
 */
public class ConnectionFactory {

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		return  DriverManager.getConnection("jdbc:mysql://localhost:3306/aulajdbc", 
																	"aulajdbc", "12345");
	}

	public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) {
		close(conn, stmt, rs);
	}

	public static void closeConnection(Connection conn, Statement stmt) {
		close(conn, stmt, null);
	}

	public static void closeConnection(Connection conn) {
		close(conn, null, null);
	}

	private static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}

			if(stmt != null) {
				stmt.close();
			}

			if(conn != null) {
				conn.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
