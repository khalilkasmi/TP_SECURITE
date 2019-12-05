package org.tpsecurity.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.tpsecurity.entities.UserRole;

@Repository
@Transactional
public class EnsaRoleDAO {
	@Autowired
	private EntityManager entityManager;

	public List<String> getRoleNames(Long userId) {
		String sql = "Select ur.ensaRole.roleName from " + UserRole.class.getName() + " ur "
				+ " where ur.EnsaUser.userId = :userId ";
		Query query = this.entityManager.createQuery(sql, String.class);
		query.setParameter("userId", userId);
		return query.getResultList();
	}
}
