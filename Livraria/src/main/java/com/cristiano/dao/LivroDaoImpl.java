package com.cristiano.dao;

import org.hibernate.NonUniqueResultException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.cristiano.model.Livro;

public class LivroDaoImpl extends BaseDao implements LivroDao {

	public void salvar(Livro livro) {
		Session session = getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		session.save(livro);
		session.getTransaction().commit();
		session.close();
	}

	public void excluir(Integer id) {
		Session session = getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		Livro livro = getPorId(id);
		session.delete(livro);
		session.getTransaction().commit();
		session.close();
	}

	public void alterar(Livro livro) {
		Session session = getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		session.merge(livro);
		session.getTransaction().commit();
		session.close();
	}
	
	public Livro getPorId(Integer id){
		Session session = getSessionFactory().getCurrentSession();
		Livro result = null;
		String sql = "FROM Livro WHERE id = :id";
		Query query = session.createQuery(sql);
		query.setParameter("id", id);
		try{
			result = (Livro) query.uniqueResult();
		}  catch (NonUniqueResultException exc) {
			result = null;
		}
		session.close();
		return result;
	}

}
