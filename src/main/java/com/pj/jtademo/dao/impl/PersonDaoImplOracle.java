package com.pj.jtademo.dao.impl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.pj.jtademo.dao.PersonDao;
import com.pj.jtademo.model.Person;

public class PersonDaoImplOracle extends JdbcDaoSupport implements PersonDao {

	private static final String SAVE_SQL = "insert into PERSON (ID, NAME) values (PERSON_SEQ.nextval, ?)";
	
	@Override
	public void save(Person person) {
		getJdbcTemplate().update(SAVE_SQL, person.getName());
	}

}