package com.cristiano.dao;

import org.hibernate.NonUniqueResultException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.cristiano.model.Autor;

public class AutorDaoImpl extends BaseDao implements AutorDao {

	public void salvar(Autor autor) {
		Session session = getSessionFactory().openSession();
		session.getTransaction().begin();
		session.save(autor);
		session.getTransaction().commit();
		session.close();
	}

	public void excluir(Integer id) {
		Session session = getSessionFactory().openSession();
		session.getTransaction().begin();
		Autor autor = getPorId(id);
		session.delete(autor);
		session.getTransaction().commit();
		session.close();
	}

	public void alterar(Autor autor) {
		Session session = getSessionFactory().openSession();
		session.getTransaction().begin();
		session.merge(autor);
		session.getTransaction().commit();
		session.close();
	}

	public Autor getPorId(Integer id) {
		Session session = getSessionFactory().openSession();
		Autor result = null;
		String sql = "FROM Autor WHERE id = :id";
		Query query = session.createQuery(sql);
		query.setParameter("id", id);
		try{
			result = (Autor) query.uniqueResult();
		}  catch (NonUniqueResultException exc) {
			result = null;
		}
		session.close();
		return result;
	}

	
}
