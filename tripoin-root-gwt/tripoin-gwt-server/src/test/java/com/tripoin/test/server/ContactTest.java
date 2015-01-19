package com.tripoin.test.server;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tripoin.service.IGenericManagerJpa;
import com.tripoin.test.pojo.Contact;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { 
		"classpath*:/META-INF/spring/applicationContext-jpa.xml",
		"classpath*:/META-INF/spring/datasource/dataSourceContext_sql_server.xml" })
public class ContactTest implements ApplicationContextAware  {
	
		
	private static transient final Logger LOGGER = LoggerFactory.getLogger(ContactTest.class);
	
	@Autowired
	private IGenericManagerJpa contactService;
	
	private ApplicationContext applicationContext;
	
	public <T> T getBean(Class<T> beanType) {
		return applicationContext.getBean(beanType);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
	@Test
	public void runTest() throws Exception {
		List<Contact> contacts = contactService.loadObjects(Contact.class);
		System.out.println("debug :"+contacts.toString());
		for(Contact contact : contacts){
			LOGGER.debug("data :"+contact.toString());
		}
	}

}
