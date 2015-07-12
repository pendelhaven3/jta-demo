package com.pj.jtademo.dao.impl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.pj.jtademo.dao.PersonDao;
import com.pj.jtademo.model.Person;

public class PersonDaoImplMysql extends JdbcDaoSupport implements PersonDao {

	private static final String SAVE_SQL = "insert into PERSON (NAME) values (?)";
	
	@Override
	public void save(Person person) {
		getJdbcTemplate().update(SAVE_SQL, person.getName());
	}

}
