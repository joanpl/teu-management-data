package com.dsoft.teu.data.dao;

import java.util.List;

import com.dsoft.teu.data.model.Person;

public interface PersonDao {
	
	void savePerson(Person person);
	
	List<Person> findAllPersons();
	
	void deletePersonByssn(String ssn);
	
	

}
