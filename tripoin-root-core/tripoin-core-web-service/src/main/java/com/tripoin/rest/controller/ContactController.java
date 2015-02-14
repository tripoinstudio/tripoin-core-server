package com.tripoin.rest.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tripoin.service.GenericManagerJpa;
import com.tripoin.test.pojo.ContactPG;

@Controller
public class ContactController {
	
	@Autowired GenericManagerJpa contactService;

	@ResponseBody
	@RequestMapping( value = "/contact", method = {RequestMethod.GET} )
	public String response(){
		return "test Response";
	}
	
	@ResponseBody
	@RequestMapping( value = "/contact/selectAll", method = RequestMethod.GET )
	public String selectData(HttpServletRequest servletRequest){		
		ObjectMapper mapper = new ObjectMapper();
		List<ContactPG> contacts = null;
		try {
			contacts = contactService.loadObjects(ContactPG.class);
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
	
}
