package com.dsoft.teu;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.joda.time.LocalDate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.dsoft.teu.data.model.Person;
import com.dsoft.teu.data.model.TEUPerson;
import com.dsoft.teu.service.PersonService;
import com.mysql.jdbc.Connection;

public class AppMain {

	public static void main(String[] args) {
		
		//testMySQLConnection();
		testHibernateConfig();
		
	}
	
	
	public static void testMySQLConnection() {
		
		System.out.println("-------- MySQL JDBC Connection Testing ------------");
		 
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}
	 
		System.out.println("MySQL JDBC Driver Registered!");
		Connection connection = null;
	 
		try {
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://jlo.cefietgq5w13.us-west-2.rds.amazonaws.com:3306/teumanagement","admin", "offtheshoulder");
			
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
	 
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}	
	
	}
	
	public static void testHibernateConfig() {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		PersonService service = (PersonService) context.getBean("personService");
		
		//Create Person
		Person me = new TEUPerson();
		me.setFirstName("Joana");
		me.setLastName("Lopes");
		me.setAge(30);
		me.setEntryDate(new LocalDate(2002, 12, 03));
		
		//Create Person
		Person other = new TEUPerson();
		other.setFirstName("John");
		other.setLastName("Doe");
		other.setAge(35);
		other.setEntryDate(new LocalDate());
				
		service.savePerson(me);
		service.savePerson(other);
		
		List<Person> persons = service.findAllPersons();
		
		for(Person person: persons) {
			System.out.println(person);
		}
		
		System.out.println("*** Deleting " + other.getId() +" ***");
		service.deletePersonById(other.getId());
		System.out.println("*** Deleted ***");
		
		System.out.println("Finding Joana...");
		List<Person> findPersons  = service.findByNames("Joana", "Lopes");
		Person pFound = null;
		for(Person pFind : findPersons) {
			System.out.println(pFind);
			if(pFind.equals(me));
			pFound = pFind;
		}
		
		System.out.println("Creating Alexandra...");
		//Create Person
		Person third = new TEUPerson();
		third.setFirstName("Alexandra");
		third.setLastName("Carreira");
		third.setAge(35);
		third.setEntryDate(new LocalDate());
				
		service.savePerson(third);
		
		System.out.println("Updating Joana Age...");
		pFound.setAge(32);
		
		service.updatePerson(pFound);
		
		System.out.println("List all people...");
		List<Person> personList = service.findAllPersons();
		
		for(Person person: personList) {
			System.out.println(person);
		}
		
		context.close();
	}

}
