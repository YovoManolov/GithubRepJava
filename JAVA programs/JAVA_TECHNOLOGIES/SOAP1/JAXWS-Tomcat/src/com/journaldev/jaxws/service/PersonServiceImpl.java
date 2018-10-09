package com.journaldev.jaxws.service;

import java.util.HashMap;
import java.util.Map;

import javax.jws.WebService;

import com.journaldev.jaxws.beans.Person;

@WebService(endpointInterface ="com.journaldev.jaxws.service.PersonService")
public class PersonServiceImpl implements PersonService {

	private static Map<Integer,Person> persons = new HashMap<Integer,Person>();
	
	
	@Override
	public boolean addPerson(Person p) {
		// TODO Auto-generated method stub
		if(persons.get(p.getId()) != null) return false;
		else {
			persons.put(p.getId(),p);
			return true;
		}
		
	}

	@Override
	public boolean deletePerson(int id) {
		// TODO Auto-generated method stub
		if(persons.get(id) == null) return false;
		else {
			persons.remove(id);
			return true;
		}
	}

	@Override
	public Person getPerson(int id) {
		return persons.get(id);
	}

	@Override
	public Person[] getAllPersons() {
		return (Person[]) persons.values().toArray();
	}

}
