/**
 * 
 */
package com.dsoft.teu.data.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author jlopes
 *
 */
public abstract class AbstractDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void persist(Object entity) {
		getSession().persist(entity);
	}
	
	public void delete(Object entity) {
		getSession().delete(entity);
	}

}
