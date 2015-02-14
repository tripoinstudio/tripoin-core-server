package com.tripoin.rest.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tripoin.rest.DTO.BaseRESTDTO;
import com.tripoin.rest.controller.top.ABaseRESTController;
import com.tripoin.test.pojo.Contact;

@Controller
public class ContactController extends ABaseRESTController{	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ContactController.class);
	
	@ResponseBody
	@RequestMapping( value = "/selectAll", method = RequestMethod.GET )
	public String selectAllContact(HttpServletRequest servletRequest){				
		List<Contact> contacts = null;
		try {
			contacts = genericManagerJPA.loadObjects(Contact.class);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		String result="";
		try {
			result = mapper.writeValueAsString(contacts);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping( value="/select/type=inquiry&name={name}")
	public String selectContactByName( @PathVariable("name") String name ){
		List<Contact> contacts = null;
		List<Contact> contactsFiltered = new ArrayList<Contact>();
		try {
			contacts = genericManagerJPA.loadObjects(Contact.class);
			for( Contact contact: contacts ){
				if( contact.getName().equals( name) ){
					contactsFiltered.add( contact );
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		String result="";
		try {
			result = mapper.writeValueAsString(contactsFiltered);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;		
	}
	
	
	@RequestMapping( value="/index", method = RequestMethod.GET )
	public ModelAndView getIndexPage(){
		return new ModelAndView("index");
	}
	
	@ResponseBody
	@RequestMapping( value="/select/type=insert", method = RequestMethod.POST )
	public String insertContact( 
			@RequestParam( value = "name" , required= true) String name, 
			@RequestParam( value = "email" , required= true) String email,
			@RequestParam( value = "address" , required= true) String address
			){
		Contact contact = new Contact();
		contact.setId(5);
		contact.setName(name);
		contact.setAddress(address);
		contact.setEmail(email);
		LOGGER.debug(contact.toString());
		BaseRESTDTO baseRESTDTO = new BaseRESTDTO();
		try {
			genericManagerJPA.saveObject(contact);
			baseRESTDTO.setErr_code(0);
			baseRESTDTO.setErr_msg("");
			baseRESTDTO.setResult(1);
		} catch (Exception e1) {
			baseRESTDTO.setErr_code(-1);
			baseRESTDTO.setErr_msg("can not save");
			baseRESTDTO.setResult(-1);
			e1.printStackTrace();
		}		
		
		String result = "";
		try {
			result = mapper.writeValueAsString(baseRESTDTO).toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
