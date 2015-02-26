package com.dsoft.teu.data.dao;

import java.util.List;




import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

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

	public void deletePersonById(Integer id) {
		Query query = getSession().createSQLQuery("delete from Person where id = :id");
		query.setString("id", id.toString());
		query.executeUpdate();		
	}

	@SuppressWarnings("unchecked")
	public List<Person> findbyNames(String firstName, String lastName) {
		Criteria criteria = getSession().createCriteria(Person.class);
		criteria.add(Restrictions.eq("firstName",firstName));
		criteria.add(Restrictions.eq("lastName",lastName));
		return (List<Person>) criteria.list();
	}

	public void updatePerson(Person person) {
		getSession().update(person);
	}

}
