package com.tripoin.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripoin.dao.GenericDaoJpa;
import com.tripoin.service.GenericManagerJpa;

@Service("genericManagerJpa")
public class GenericManagerJpaImpl implements GenericManagerJpa {

	private static final Logger LOGGER = LoggerFactory.getLogger(GenericManagerJpaImpl.class);
	
	@Autowired
	private GenericDaoJpa genericDao;
	
	@Override
	public <T> List<T> loadObjects(Class<T> objectType) throws Exception {
		LOGGER.debug("GenericManagerRPCJpa - Class name : "+objectType.getName());
		List<T> objects = genericDao.loadObjects(objectType);
		return objects;
	}
	
}
