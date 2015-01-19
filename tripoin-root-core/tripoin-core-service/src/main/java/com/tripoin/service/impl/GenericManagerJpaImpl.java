package com.tripoin.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripoin.dao.IGenericDaoJpa;
import com.tripoin.service.IGenericManagerJpa;

@Service("genericManagerJpa")
public class GenericManagerJpaImpl implements IGenericManagerJpa {

	private static final Logger LOGGER = LoggerFactory.getLogger(GenericManagerJpaImpl.class);
	
	@Autowired
	private IGenericDaoJpa genericDao;
	
	@Override
	public <T> List<T> loadObjects(Class<T> objectType) throws Exception {
		LOGGER.debug("GenericManagerRPCJpa - Class name : "+objectType.getName());
		List<T> objects = genericDao.loadObjects(objectType);
		return objects;
	}
	
}
