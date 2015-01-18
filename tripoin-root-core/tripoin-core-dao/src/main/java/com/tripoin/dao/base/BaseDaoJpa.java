package com.tripoin.dao.base;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.tripoin.dao.GenericDaoJpa;


@Repository("baseDaoJpa")
public abstract class BaseDaoJpa implements GenericDaoJpa {

    @PersistenceContext
	@Qualifier(value="entityManagerFactory")
	private EntityManager entityManager;
	 
    protected EntityManager getEntityManager() {
        return entityManager;
    }
    
	@Override
	public void saveObject(Class<?> objectType) throws Exception {
		entityManager.persist(objectType);
	}

	@Override
	public void updateObject(Class<?> objectType, Serializable key) throws Exception {
		entityManager.merge(objectType);
	}

	@Override
	public void deleteObject(Class<?> objectType) throws Exception {
		entityManager.remove(objectType);
	}  
}