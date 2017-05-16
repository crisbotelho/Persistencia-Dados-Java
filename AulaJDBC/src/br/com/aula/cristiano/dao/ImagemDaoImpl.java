package br.com.aula.cristiano.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImagemDaoImpl implements ImagemDao {

	private Connection conn;

	public ImagemDaoImpl() throws ClassNotFoundException, SQLException {
		this.conn = ConnectionFactory.getConnection();
	}
	
	@Override
	public void excluir(int id) {
		PreparedStatement ps = null;
		Connection conn = null;

		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM imagem WHERE id = ? ");

		conn = this.conn;

		try {
			ps = conn.prepareStatement(sb.toString());

			ps.setInt(1, id);

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

}
