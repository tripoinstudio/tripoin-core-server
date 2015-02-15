package com.tripoin.test.batch;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BatchTest {
	
	public static void main(String[] args) {

		String[] springConfig  = 
			{	
				"META-INF/spring/datasource/dataSourceContext_sql_server.xml",
				"META-INF/spring/applicationContext-job-file.xml"
			};
		
		ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);		

	}
}
