package com.tripoin.gwt.server;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("SampleAppService")
public interface TestService extends RemoteService {
    // Sample interface method of remote interface
    String getMessage(String msg);

    /**
     * Utility/Convenience class.
     * Use SampleAppService.App.getInstance() to access static instance of SampleAppServiceAsync
     */
    public static class App {
        private static SampleAppServiceAsync ourInstance = GWT.create(TestService.class);

        public static synchronized SampleAppServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
