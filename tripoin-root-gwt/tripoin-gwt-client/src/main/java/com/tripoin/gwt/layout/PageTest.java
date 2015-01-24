package com.tripoin.gwt.layout;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.tripoin.gwt.server.TestServiceAsync;
import com.tripoin.test.pojo.Contact;

public class PageTest extends Composite {

	private static PageTestUiBinder uiBinder = GWT
			.create(PageTestUiBinder.class);

	interface PageTestUiBinder extends UiBinder<Widget, PageTest> {
	}
	
	@UiField
	Button btnTest;
	
	@UiField
	Label lblTest;
	
	@UiField
	VerticalPanel tab;

	
	// Create a CellTable.
    CellTable<Contact> table = new CellTable<Contact>();

    List<Contact> contacts = new ArrayList<Contact>();
	public PageTest() {
		initWidget(uiBinder.createAndBindUi(this));
		btnTest.setText("Get Data");
		lblTest.setText("Agu");
		
		// Create name column.
	    TextColumn<Contact> nameColumn = new TextColumn<Contact>() {
	      @Override
	      public String getValue(Contact contact) {
	        return contact.getName();
	      }
	    };
	    
	 // Make the name column sortable.
	    nameColumn.setSortable(true);

	    // Create address column.
	    TextColumn<Contact> emailColumn = new TextColumn<Contact>() {
	      @Override
	      public String getValue(Contact contact) {
	        return contact.getEmail();
	      }
	    };
	    
	    // Create address column.
	    TextColumn<Contact> addressColumn = new TextColumn<Contact>() {
	      @Override
	      public String getValue(Contact contact) {
	        return contact.getAddress();
	      }
	    };

	    // Add the columns.
	    table.addColumn(nameColumn, "Name");
	    table.addColumn(emailColumn, "Email");
	    table.addColumn(addressColumn, "Address");

	    TestServiceAsync.util.getInstance().getContact(new AsyncCallback<List<Contact>>(){

			@Override
			public void onFailure(Throwable caught) {
				
			}

			@Override
			public void onSuccess(List<Contact> result) {
			    table.setRowCount(result.size(), true);

			    // Push the data into the widget.
			    table.setRowData(0, result);
			}
			
		});

//	    // We know that the data is sorted alphabetically by default.
//	    table.getColumnSortList().push(nameColumn);
	    tab.setWidth("400");
	    tab.add(table);
	}	
	
	
	@UiHandler("btnTest")
	public void onClickBtn(ClickEvent e){
		
		TestServiceAsync.util.getInstance().getData(new AsyncCallback<String>(){

			@Override
			public void onFailure(Throwable caught) {
				
			}

			@Override
			public void onSuccess(String result) {
				lblTest.setText(result);
			}
			
		});;
	}

}
