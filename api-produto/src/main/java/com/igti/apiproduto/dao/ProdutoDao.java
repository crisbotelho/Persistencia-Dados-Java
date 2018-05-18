package com.igti.apiproduto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.igti.apiproduto.model.Produto;

public class ProdutoDao {

	private Connection conn;

	public ProdutoDao() {
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void salvar(Produto produto) {
		PreparedStatement ps = null;
		Connection conn = null;

		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO produto (id, nome, descricao ");
		if(produto.getIdProduto() >= 0){
			sb.append(", id_produto_pai ");
		} 
		sb.append(")");	
		sb.append("VALUES (?, ?, ? ");
		if(produto.getIdProduto() >= 0){
			sb.append(", ? ");
		} 
		sb.append(")");

		conn = this.conn;

		try {
			ps = conn.prepareStatement(sb.toString());

			ps.setInt(1, produto.getId());
			ps.setString(2, produto.getNome());
			ps.setString(3, produto.getDescricao());			
			if(produto.getIdProduto() >= 0){
				ps.setInt(4, produto.getIdProduto());
			}

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	
	public void excluir(int id) {
		PreparedStatement ps = null;
		Connection conn = null;

		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM produto WHERE id = ? ");

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

	public List<Produto> listarTodos() {
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		List<Produto> lista = new ArrayList<Produto>();

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM produto ");
		conn = this.conn;

		try {
			ps = conn.prepareStatement(sb.toString());
			rs = ps.executeQuery();
			while(rs.next()){
				Produto produto = new Produto();
				produto.setId(rs.getInt("ID"));
				produto.setNome(rs.getString("NOME"));
				produto.setDescricao(rs.getString(3));
				produto.setIdProduto(rs.getInt("ID_PRODUTO_PAI"));
				lista.add(produto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
		return lista;
	}
		
	public Long contar(){
		PreparedStatement ps = null;
		Connection conn = null;
		Long quantidade = 0L;
		ResultSet rs = null;

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT count(*) FROM produto ");
		conn = this.conn;

		try {
			ps = conn.prepareStatement(sb.toString());
			rs = ps.executeQuery();
			if(rs.next()) {
				quantidade = rs.getLong(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
		return quantidade;
	}

}
