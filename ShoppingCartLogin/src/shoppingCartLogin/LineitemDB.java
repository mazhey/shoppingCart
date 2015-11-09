package shoppingCartLogin;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Lineitem;


public class LineitemDB {
	public static void insert(Lineitem lineitem) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try {
		em.persist(lineitem);
		trans.commit();
		} catch (Exception e) {
		System.out.println(e);
		trans.rollback();
		} finally {
		em.close();
		}
		}

		public static void update(Lineitem lineitem) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try {
		em.merge(lineitem);
		trans.commit();
		} catch (Exception e) {
		System.out.println(e);
		trans.rollback();
		} finally {
		em.close();
		}
		}

		public static void delete(Lineitem lineitem) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try {
		em.remove(em.merge(lineitem));
		trans.commit();
		} catch (Exception e) {
		System.out.println(e);
		trans.rollback();
		} finally {
		em.close();
		} 
		}
		
}
