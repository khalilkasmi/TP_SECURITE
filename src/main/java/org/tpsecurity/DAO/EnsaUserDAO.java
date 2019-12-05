package org.tpsecurity.DAO;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.tpsecurity.entities.EnsaUser;

@Repository
@Transactional
public class EnsaUserDAO {
	@Autowired
	private EntityManager entityManager;

	public EnsaUser findUserAccount(String userName) {
		try {

			String sql = "Select e from " + EnsaUser.class.getName() + " e " + " Where e.userName = :userName ";
			Query query = entityManager.createQuery(sql, EnsaUser.class);
			query.setParameter("userName", userName);
			return (EnsaUser) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
