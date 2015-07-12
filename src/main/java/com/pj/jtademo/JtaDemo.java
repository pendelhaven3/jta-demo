package com.pj.jtademo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.pj.jtademo.model.Person;
import com.pj.jtademo.service.PersonService;

@Component
public class JtaDemo {

	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml", "datasource.xml");
		context.registerShutdownHook();
		
		PersonService personService = context.getBean(PersonService.class);
		personService.save(new Person("DAENERYS"));
	}
	
}
