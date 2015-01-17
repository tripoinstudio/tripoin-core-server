package com.tripoin.gwt.layout;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.tripoin.gwt.resources.LoginResources;

/**
 * Created by Ladies Man on 1/17/15.
 */
public class Login extends Composite{

    private static LoginUiBinder loginUiBinder = GWT.create(LoginUiBinder.class);

    @UiTemplate("Login.ui.xml")
    interface LoginUiBinder extends UiBinder<Widget, Login> {
    }

    @UiField(provided = true)
    final LoginResources res;

    public Login() {
        this.res = GWT.create(LoginResources.class);
        res.style().ensureInjected();
        initWidget(loginUiBinder.createAndBindUi( this ));
    }


    @UiField
    TextBox loginBox;

    @UiField
    TextBox passwordBox;

    @UiField
    Label completionLabel1;

    @UiField
    Label completionLabel2;

    private Boolean tooShort = false;

    @UiHandler("buttonSubmit")
    void doClickSubmit(ClickEvent clickEvent){
        if( tooShort ){
            Window.alert("Login Successfull");
        }else{
            Window.alert("Login or Password is too short");
        }
    }

    @UiHandler("loginBox")
    void handleLoginChange(ValueChangeEvent<String> event){
        if( event.getValue().length()<6){
            completionLabel1.setText("Login too short");
            tooShort = true;
        }else{
            tooShort = false;
            completionLabel1.setText("");
        }
    }


    @UiHandler("passwordBox")
    void handlePasswordChange(ValueChangeEvent<String> event){
        if (event.getValue().length() < 6) {
            tooShort = true;
            completionLabel2.setText("Password too short (Size must be > 6)");
        } else {
            tooShort = false;
            completionLabel2.setText("");
        }
    }
}