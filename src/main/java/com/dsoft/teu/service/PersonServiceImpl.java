package com.dsoft.teu.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dsoft.teu.data.dao.PersonDao;
import com.dsoft.teu.data.model.Person;

@Service("personService")
@Transactional
public class PersonServiceImpl implements PersonService {
	
	private PersonDao dao;

	public void savePerson(Person person) {
		dao.savePerson(person);
	}

	public List<Person> findAllPersons() {
		return dao.findAllPersons();
	}

	public void deletePersonById(Integer id) {
		dao.deletePersonById(id);

	}

	public void updatePerson(Person person) {
		dao.updatePerson(person);
	}

	@Override
	public List<Person> findByNames(String firstName, String lastName) {
		return dao.findbyNames(firstName, lastName);
	}

	

}
