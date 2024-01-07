package vn.aptech.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import vn.aptech.entity.Category;

public class CategoryDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("relationshipJpaPU");

	public List<Category> findAll() {
		List<Category> result = new ArrayList<>();
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Query q = em.createQuery("SELECT o FROM Category o");
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

	public Category findById(int id) {
		Category result = null;
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			result = em.find(Category.class, id);
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
