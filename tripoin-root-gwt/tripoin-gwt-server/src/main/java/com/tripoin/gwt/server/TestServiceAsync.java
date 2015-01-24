package com.tripoin.gwt.server;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.tripoin.test.pojo.Contact;

public interface TestServiceAsync {
    void getMessage(String msg, AsyncCallback<String> async);
    void getData(AsyncCallback<String> itil);
    void getContact(AsyncCallback<List<Contact>> telek); 
    
    public static class util{
    	private static TestServiceAsync instance;
    	
    	public static TestServiceAsync getInstance(){
    		if(instance == null){
    			instance = (TestServiceAsync)GWT.create(TestService.class);
    		}
    		return instance;
    	}
    }
}
