package com.tripoin.rest.controller.top;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tripoin.rest.controller.api.IBaseRESTController;
import com.tripoin.service.IGenericManagerJpa;

@Controller
@RequestMapping( value="/ws/rest" )
public abstract class ABaseRESTController implements IBaseRESTController{

	@Autowired protected IGenericManagerJpa genericManagerJPA;
	
	protected ObjectMapper mapper = new ObjectMapper();
	
	private static transient final Logger LOGGER = LoggerFactory.getLogger(ABaseRESTController.class);
	
	@Override
	public String testRest() {
		writeLog();
		JSONObject object = new JSONObject();
		try {
			object.put("test", "hello");
		} catch (JSONException e) {
			try {
				object.put("error", e.toString());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return object.toString();
	}
	
	@Override
	public void writeLog() {
		LOGGER.debug("LOG - IS RUNNING");
	}
}
