package com.dsoft.teu.service;

import java.util.List;

import com.dsoft.teu.data.model.Person;

public interface PersonService {
	
	void savePerson(Person person);
	
	List<Person> findAllPersons();
	
	void deletePersonbySsn(String ssn);
	
	void updatePerson(Person person);
	
	

}
