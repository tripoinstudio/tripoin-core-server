package com.tripoin.service;

import java.util.List;

public interface GenericManagerJpa {
	public <T> List<T> loadObjects(Class<T> objectType) throws Exception;
}
