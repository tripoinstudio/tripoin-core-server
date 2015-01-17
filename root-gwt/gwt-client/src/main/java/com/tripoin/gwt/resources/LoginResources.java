package com.tripoin.gwt.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

/**
 * Created by Ladies Man on 1/17/15.
 */
public interface LoginResources extends ClientBundle {

    public interface MyCss extends CssResource{

        String blackText();

        String redText();

        String loginButton();

        String background();

        String box();

        String pusat();
    }

    @Source("com/tripoin/gwt/style/Login.css")
    MyCss style();

}
