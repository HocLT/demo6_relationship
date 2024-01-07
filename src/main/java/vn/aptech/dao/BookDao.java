package vn.aptech.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import vn.aptech.entity.Book;

public class BookDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("relationshipJpaPU");

	public List<Book> findAll() {
		List<Book> result = new ArrayList<>();
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Query q = em.createQuery("SELECT o FROM Book o");
			result.addAll(q.getResultList());
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

		return result;
	}
}
