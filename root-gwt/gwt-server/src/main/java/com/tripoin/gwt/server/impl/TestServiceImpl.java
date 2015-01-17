package com.tripoin.gwt.server.impl;

import java.io.Serializable;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.tripoin.gwt.server.TestService;

public class TestServiceImpl extends RemoteServiceServlet implements TestService, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage(String msg) {
		return null;
	}

}
