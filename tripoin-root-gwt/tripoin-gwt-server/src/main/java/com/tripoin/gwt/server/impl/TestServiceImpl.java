package com.tripoin.gwt.server.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.tripoin.gwt.server.TestService;
import com.tripoin.test.pojo.Contact;

public class TestServiceImpl extends RemoteServiceServlet implements TestService, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage(String msg) {
		return null;
	}

	@Override
	public String getData() {
		String nama = "anjar";
		return nama;
	}
	
	@Override
	public List<Contact> getContact(){
		
		String name = "Agung";
		String email = "agung.ganteng@ngewe.com";
		String address = "telek";
		
//		List<Contact> cons = Arrays.asList(new Contact(name,email,address));
		List<Contact> cons = new ArrayList<Contact>();
		cons.add(new Contact(name,email,address));
		
		return cons;
	}

}
