package com.dsoft.teu.service;

import java.util.List;

import com.dsoft.teu.data.model.Person;

public interface PersonService {
	
	void savePerson(Person person);
	
	List<Person> findAllPersons();
	
	List<Person> findByNames(String firstName, String lastName);
	
	void deletePersonById(Integer id);
	
	void updatePerson(Person person);	

}
