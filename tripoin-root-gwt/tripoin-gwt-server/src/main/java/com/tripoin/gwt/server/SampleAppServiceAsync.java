package com.tripoin.gwt.server;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface SampleAppServiceAsync {
    void getMessage(String msg, AsyncCallback<String> async);
}
