package com.tripoin.gwt.server;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.tripoin.test.pojo.Contact;;

@RemoteServiceRelativePath("SampleAppService")
public interface TestService extends RemoteService {
    // Sample interface method of remote interface
    public String getMessage(String msg);
    public String getData();
    
    public List<Contact> getContact();
}