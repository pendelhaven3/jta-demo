package com.pj.jtademo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.jtademo.dao.PersonDao;
import com.pj.jtademo.model.Person;
import com.pj.jtademo.service.PersonService;

@Service("personService")
public class PersonServiceImpl implements PersonService {

	@Autowired
	@Qualifier("personDaoMysql")
	private PersonDao personDaoMySql;
	
	@Autowired
	@Qualifier("personDaoOracle")
	private PersonDao personDaoOracle;
	
	@Transactional
	@Override
	public void save(Person person) {
		personDaoMySql.save(person);
		personDaoOracle.save(person);
		if (true) throw new RuntimeException("Monkey wrench!");
	}

}