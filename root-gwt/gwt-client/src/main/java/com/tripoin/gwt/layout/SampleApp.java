package com.tripoin.gwt.layout;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class SampleApp implements EntryPoint {

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {        
        RootPanel.get().add( new Login());
    }
    
}
