package shoppingCartLogin;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.Shoppinguser;


public class UserDB {
	public static void insert(Shoppinguser shoppinguser) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try {
		em.persist(shoppinguser);
		trans.commit();
		} catch (Exception e) {
		System.out.println(e + "this is the insert exception");
		trans.rollback();
		} finally {
		em.close();
		}
		}

		public static void update(Shoppinguser shoppinguser) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try {
		em.merge(shoppinguser);
		trans.commit();
		} catch (Exception e) {
		System.out.println(e);
		trans.rollback();
		} finally {
		em.close();
		}
		}

		public static void delete(Shoppinguser shoppinguser) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try {
		em.remove(em.merge(shoppinguser));
		trans.commit();
		} catch (Exception e) {
		System.out.println(e);
		trans.rollback();
		} finally {
		em.close();
		} 
		}
		//new methods to select a user by username and check if a username already exists
		public static Shoppinguser selectUser(String username){
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			String qString = "select u from Shoppinguser u where u.username = :username";
			TypedQuery<Shoppinguser> q = em.createQuery(qString, Shoppinguser.class);
			q.setParameter("username", username);
			Shoppinguser shoppinguser = null;
			try {
				shoppinguser = q.getSingleResult();
			}catch (NoResultException e){
				System.out.println(e);
			}finally{
				em.close();
			}
			return shoppinguser;
		}
		public static boolean usernameExists(String username){
			Shoppinguser u = selectUser(username);
			return u != null;
		}
		
		public static Shoppinguser selectUserID(String username){
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			String qString = "select u from User u where u.username = :username";
			TypedQuery<Shoppinguser> q = em.createQuery(qString, Shoppinguser.class);
			q.setParameter("username", username);
			Shoppinguser shoppinguser = null;
			try {
				shoppinguser = q.getSingleResult();
			}catch (NoResultException e){
				System.out.println(e);
			}finally{
				em.close();
			}
			return shoppinguser;
		}

}
