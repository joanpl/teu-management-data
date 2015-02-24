package com.dsoft.teu.data.dao;

import java.util.List;



import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.dsoft.teu.data.model.Person;

public abstract class PersonDaoImpl extends AbstractDao implements PersonDao {

	public void savePerson(Person person) {
		persist(person);

	}

	@SuppressWarnings("unchecked")
	public List<Person> findAllPersons() {
		Criteria criteria = getSession().createCriteria(Person.class);
		return (List<Person>) criteria.list();
	}

	public void deletePersonByssn(String ssn) {
		Query query = getSession().createSQLQuery("delete from Person where ssn = :ssn");
		query.setString("ssn", ssn);
		query.executeUpdate();		
	}

	public Person findbySsn(String ssn) {
		Criteria criteria = getSession().createCriteria(Person.class);
		criteria.add(Restrictions.eq("ssn",ssn));
		return (Person) criteria.uniqueResult();
	}

	public void updatePerson(Person person) {
		getSession().update(person);
	}

}
